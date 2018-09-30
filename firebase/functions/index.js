const functions = require('firebase-functions');
const admin = require('firebase-admin');
const request = require('request');
admin.initializeApp();

exports.cleanUserData = functions
.runWith({ memory: '1GB' })
.database.ref('questions/{questionId}')
.onWrite((snap, context) => {

  // Get an object representing the document
  // e.g. {'name': 'Marie', 'age': 66}
  const data = snap.data();

  // access a particular field as you would any JS property
  //const name = data.question;

  const postData = {
    "id": context.params.questionId,
    "title": data.question,
    "category": data.category,
    "toSend": data.TO_SEND.toMillis(),
    "toEnd": data.TO_END.toMillis(),
    "choices": data.choices,
  };

  console.log(postData);

  // make the request
  return request.post({
    url: 'http://104.248.120.152/api/question/',
    body: postData
  }, (error, response, body) => {
    if (error) {
      throw response;
    }

    // Print the error if one occurred
    //console.log('statusCode:', response && response.statusCode); // Print the response status code if a response was received
    console.log('body:', body); // Print the HTML response
    response.json({
      'error': error,
      'statusCode': response && response.statusCode,
      'body': body
    });
    console.log(response);
  }).catch(error => {
    return console.log('failed: ', error);
  });

});