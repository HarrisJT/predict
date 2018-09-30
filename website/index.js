const express = require('express')
const admin = require('firebase-admin')
const bodyParser = require("body-parser")
const serviceAccount = require('./service-key.json')
const app = express()
const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  databaseURL: "https://predict-454c2.firebaseio.com"
})
app.set('view engine', 'ejs')
app.use(express.static('public'))
app.use(bodyParser.urlencoded({ extended: true }));

app.get('/', function(req, res) {
  res.render('index', {
    completed: false
  })
})

app.post('/', function(req, res) {
  var userRef = admin.database().ref("users");
  if(req.body.email != null && re.test(String(req.body.email).toLowerCase())) {
    var transformed = req.body.email.replace('.', ',')
    console.log('Valid email, adding email to database: ' + req.body.email)
    userRef.once('value').then(function(snapshot) {
        console.log('Got snapshot, verifying non-duplicate')
        if(!snapshot.hasChild(transformed)) {
          console.log('Non-duplicate, adding to database')
          userRef.child(transformed).set({
            email: transformed.replace(',', '.'),
            weights: {
              international_politics: 0.1,
              national_politics: 0.1,
              environment: 0.1,
              entertainment: 0.1,
              sports: 0.1,
              biology: 0.1,
              technology: 0.1,
              natural_disasters: 0.1,
              economics: 0.1
            }
          })
        }
      })
  }
  res.render('index', {
    completed: true
  })
})

app.listen(3000, function () {
  console.log('App started, listening on port 3000')
})