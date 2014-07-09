// forked from https://github.com/markeeftb/FileOpener

module.exports = {
    getDatabasePath: function (callback) {
        cordova.exec(callback, function(err){
			alert(err);
		}, "DatabasePath", "getDatabasePath", []);
    }
}
