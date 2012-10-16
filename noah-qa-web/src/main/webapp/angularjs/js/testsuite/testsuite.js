'use strict';

function ImportTestSuiteCtrl($scope) {
	resetErrors();
	var fileInput = $('#import-xls-file-input').change(function() {
		resetErrors();
		if(this.files.length <= 0) {
			$scope.errors.empty = true;
			$scope.$digest();
			return;
		}
		var file = this.files[0];
		var ext = file.name.split('.').pop();
		if(ext != 'xls') {
			$scope.errors.invalidExtension = true;
			$scope.$digest();
			return;
		}
		$scope.errors.empty = false;
		$scope.$digest();
	});
	function resetErrors() {
		$scope.errors = {
			invalidExtension: false,
			hideInvalidExtensionMsg: false,
			empty: true
		};
	}
	$scope.hideInvalidExtensionMsg = function() {
		$scope.errors.hideInvalidExtensionMsg = true;
	};
	$scope.uploadXls = function() {
		var input = fileInput.get(0);
		var file = input.files[0];
		
		var xhr = new XMLHttpRequest();
		xhr.open('POST', 'suite/import', true);
		xhr.send(file);
		
		xhr.onload = function(e) {
			$scope.suite = JSON.parse(e.target.responseText);
			$scope.$digest();
		};
	};
}
ImportTestSuiteCtrl.$inject = ['$scope'];