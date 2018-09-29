const functions = require('firebase-functions');
const admin = require('firebase-admin');
const request = require('request');
admin.initializeApp();

exports.onQuestionCreate = functions.firestore.document('questions/{questionId}').onCreate(
  (snap, context) => {
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