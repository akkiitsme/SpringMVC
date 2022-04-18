function validateQueForm(){
	var status =true;
	$('.alert-danger').hide();
	
	var questionName = $.trim($('#question').val());
	var answer1 = $.trim($('#ansList0.answer').val());
	if(questionName==""){
		$('#question').focus();
		status = 'Blank_mandatory_fields';
		$('.'+status).show(500);
		status = false;
		window.scrollTo(0,0);
		return status;	
	}
	
}