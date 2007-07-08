
function uploadFiles() {
  var image = dwr.util.getValue('uploadImage');
  var file = dwr.util.getValue('uploadFile');
  var color = dwr.util.getValue('color');

  FileUploader.uploadFiles(image, file, color, function(data) {
    dwr.util.setValue('image', data);
  });
}
