const functions = require('firebase-functions');
const admin = require('firebase-admin');
const request = require('request');
admin.initializeApp();

exports.onQuestionCreate = functions.firestore.document('questions/{questionId}').onCreate(
  (snap, context) => {
    // Get an object representing the document
    // e.g. {'name': 'Marie', 'age': 66}
    const newValue = snap.data();

    // access a particular field as you would any JS property
    //const name = newValue.question;

    // perform desired operations ...
    // import the module

    const postData = {
      "id": context.params.questionId,
      "question": newValue.question,
      "category": newValue.category,
      "toSend": newValue.TO_SEND.toMillis(),
      "toEnd": newValue.TO_END.toMillis(),
    };

    //return console.log(postData);

    // make the request
    // request.post('/104.248.120.152/api/question/new/', { json: postData },
    //   (error, response, body) => {
    //     if (error) {
    //       throw response;
    //     }
    //     // Print the error if one occurred
    //     //console.log('statusCode:', response && response.statusCode); // Print the response status code if a response was received
    //     console.log('body:', body); // Print the HTML response
    //     response.json({
    //       'error': error,
    //       'statusCode': response && response.statusCode,
    //       'body': body
    //     })
    //   }).catch(error => {
    //   return console.log('failed: ', error);
    // });

  });