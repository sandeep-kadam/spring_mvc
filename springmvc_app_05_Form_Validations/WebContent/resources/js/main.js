jQuery(document).ready(function($) {

	//$('#msg').html("Javascript Loaded Successfully");

});

function onLoad(){
	console.log("inside onLoad");
	$("#devOptionsId").hide();
	$("#testerOptionsId").hide();
}


function displayRoleOptions(){
	
	console.log("JobProfile Val : "+$('input[name=jobProfile]:checked').val());
	
	$("#jobRoleLabel").html("Please select job roles you can work in : ");
	if($('input[name=jobProfile]:checked').val() == 0 ){
		$("#devOptionsId").show();	
		$("#testerOptionsId").hide();
	} else {
		$("#testerOptionsId").show();
		$("#devOptionsId").hide();
	}
}
