DatabasePath-cordova
====================

Simple plugin to get the database location path on the device. 

# Usage

```
window.plugins.databasepath.getDatabasePath(function (fullDbFilePath) {
  // do something with the database filePath.
}, function (error) {
  console.log(error);
});
```

## Sending sqlite database over network

```
window.plugins.databasepath.getDatabasePath(function (fullDbFilePath) {

  var win = function (r) {
    console.log("Code = " + r.responseCode);
    console.log("Response = " + r.response);
    console.log("Sent = " + r.bytesSent);
  }

  var fail = function (error) {
    alert("An error has occurred: Code = " + error.code);
    console.log("upload error source " + error.source);
    console.log("upload error target " + error.target);
  }

  var options = new FileUploadOptions();
  options.fileKey = "file";
  options.fileName = fullDbFilePath;
  options.mimeType = "application/octet-stream";

  // upload file to url using cordova plugin
  // https://cordova.apache.org/docs/en/6.x/reference/cordova-plugin-file-transfer/index.html
  var ft = new FileTransfer();
  
  // send as multipart message containing only one file
  ft.upload(fullDbFilePath, encodeURI("http://example.com/upload"), win, fail, options);

}, function (error) {
  console.log(error);
});
```
