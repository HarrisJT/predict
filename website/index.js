const express = require('express');
const admin = require('firebase-admin');
const bodyParser = require("body-parser");
const serviceAccount = require('./service-key.json');
const app = express();
const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  databaseURL: "https://predict-454c2.firebaseio.com"
});
app.set('view engine', 'ejs');
app.use(express.static('public'));
app.use(bodyParser.urlencoded({ extended: true }));

app.get('/', function (req, res) {
  res.render('index', {
    completed: false
  })
});

app.post('/', function (req, res) {
  const userRef = admin.database().ref("users");
  if (req.body.email != null && re.test(String(req.body.email).toLowerCase())) {
    const transformed = req.body.email.replace('.', ',');
    console.log('Valid email, adding email to database: ' + req.body.email);
    userRef.once('value').then(function (snapshot) {
      console.log('Got snapshot, verifying non-duplicate');
      if (!snapshot.hasChild(transformed)) {
        console.log('Non-duplicate, adding to database');
        userRef.child(transformed).set({
          email: transformed.replace(',', '.'),
          weights: {
            Inter_Politics: 0.1,
            Nation_Politics: 0.1,
            Economics: 0.1,
            Entertainment: 0.1,
            Sports: 0.1,
            Biology: 0.1,
            Technology: 0.1,
            Natural_Disasters: 0.1,
            Environment: 0.1
          }
        })
      }
    })
  }
  res.render('index', {
    completed: true
  })
});

app.listen(3000, function () {
  console.log('App started, listening on port 3000')
});