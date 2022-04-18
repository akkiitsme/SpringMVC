function validateQueryForm(){
    var status = true ; 
	var checkForSpecialCharacters = /^[a-zA-Z_ ]*$/;
	//var checkForSpecialCharactersWithNumbers = /^[a-zA-Z0-9_ ]*$/;
	//var checkForSpecialCharactersWithNumbersWithBasicSplCharacter = /^[a-zA-Z0-9.,-_ ]*$/;
	//var numberRegex = /^[+-]?\d+(\.\d+)?([eE][+-]?\d+)?$/;

    $('.alert-danger').hide();

	/******* firstname Validation******/
    var firstName = $.trim($('#firstName').val());
    if(firstName=="") {
		$('#firstName').focus();
		status = 'Blank_mandatory_fields';
		$('.'+status).show(500);
		status = false;
		window.scrollTo(0,0);
		return status;
	} else if(!checkForSpecialCharacters.test(firstName)) {
		$('#firstName').focus();
		status = 'special_character';
		$('.'+status).show(500);
		status = false;
		window.scrollTo(0,0);
		return status;
	}

/******* lastname Validation******/
    var lastName = $.trim($('#lastName').val());
    if(lastName=="") {
		$('#lastName').focus();
		status = 'Blank_mandatory_fields';
		$('.'+status).show(500);
		status = false;
		window.scrollTo(0,0);
		return status;
	} else if(!checkForSpecialCharacters.test(lastName)) {
		$('#lastName').focus();
		status = 'special_character_lname';
		$('.'+status).show(500);
		status = false;
		window.scrollTo(0,0);
		return status;
	}

/******* email Validation
    status = checkValidEmailforContactus($('#email').val());
	if(status == false){
		status = 'Invalid_Email';
		$('.'+status).show();
		status =  false;
		window.scrollTo(0,0);
		return status;
	}
******/

	/******* Gender Validation******/
	if ((!($('#gender1').prop('checked'))) && (!($('#gender2').prop('checked')))) {
		$('#gender1').focus();
		status='Blank_mandatory_fields';
		$('.'+status).show(500);
		status = false;
		window.scrollTo(0,0);
		return status;
	}
	else if (!($('#gender1').prop('checked'))) {
		$('#gender2').focus();
		status='Blank_mandatory_fields';
		$('.'+status).show(500);
		status = false;
		window.scrollTo(0,0);
		return status;
	}

/******* DOB with Age Validation******/

	//get input from id
	var day = $('#day').val()
	var month = $('#month').val()
	var year = $('#year').val()

	// get current date
	var d = new Date();
	var ds = d.getDate();
	var ms = d.getMonth();
	var ys = d.getFullYear();

	// convert 18years as days from current date
	var days = ((18 * 12) * 30) + (ms * 30) + ds;
	// convert days from input value
	var age = (((ys - year) * 12) * 30) + ((12 - month) * 30) + parseInt(30 - day);

	if($('#day').val()=='0' ){
		$('#day').focus();
		status='Blank_mandatory_fields';
		$('.'+status).show(500);
		status = false;
		window.scrollTo(0,0);
		return status;
	} else if($('#month').val()=='0' ){
		$('#month').focus();
		status='Blank_mandatory_fields';
		$('.'+status).show(500);
		status = false;
		window.scrollTo(0,0);
		return status;
	} else if($('#year').val()=='0' ){
		$('#year').focus();
		status='Blank_mandatory_fields';
		$('.'+status).show(500);
		status = false;
		window.scrollTo(0,0);
		return status;
	}	else if((days - age) >= '0'){
		$('#year').focus();
		status ='Invalid_age';
		$('.'+status).show(500);
		status = false;
		window.scrollTo(0,0);
		return status;
	}
	
	

/******* empStatus Validation******/
    if($('#empStatus').val()=='0'){
		$('#empStatus').focus();
		status='Blank_mandatory_fields';
		$('.'+status).show(500);
		status = false;
		window.scrollTo(0,0);
		return status;
	}

/******* orgName Validation******/
	var orgName = $.trim($('#orgName').val());
    if(orgName=="") {
		$('#orgName').focus();
		status = 'Blank_mandatory_fields';
		$('.'+status).show(500);
		status = false;
		window.scrollTo(0,0);
		return status;
	} else if(!checkForSpecialCharacters.test(orgName)) {
		$('#orgName').focus();
		status = 'special_character_orgName';
		$('.'+status).show(500);
		status = false;
		window.scrollTo(0,0);
		return status;
	}

/******* education Validation******/
	if($('#edu').val()=='0'){
		$('#edu').focus();
		status='Blank_mandatory_fields';
		$('.'+status).show(500);
		status = false;
		window.scrollTo(0,0);
		return status;
	}

}





/******* Age Validation******/
	

	





/******* email Validation Functions******/
function checkValidEmailforContactus(email){
	var status="";
	$('.alert-danger').hide();
	 if(email==""){
		 status = 'Blank_mandatory_fields';
		 $('.'+status).show();
	  return false;
	 }
	 else if(!checkEmailFormat(email)){
		 status = 'Invalid_email';
		 $('.'+status).show();
	  return false;
	 }
	 return true;
	}

    function checkEmailFormat(email){
        var status = false;
        if(email!='' && typeof(email) != 'undefined'){
            var t=email.indexOf("@");
            var n=email.lastIndexOf(".");
            if(t<1||n<t+2||n+2>=email.length)
            {
                status =  false;
            }
            else{
                status = true;
            }
        }
        return status;
    }