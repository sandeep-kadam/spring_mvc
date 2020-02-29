jQuery(document).ready(function($) {

	$('#msg').html("Javascript Loaded Successfully");

});

function submitForm() {
	alert("inside submitForm");
    //form id = multiCheckBox/
          //SpringMultiCheckbox is context path of project
    $('#submitBtn').attr('action', "displayForm").submit();
}
