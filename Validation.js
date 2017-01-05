function formValidation() {  
	var uac = document.myform.accountNumber;

	if(Numbers(uac)){
	return true;
	}
	else{
	return false;
	}
	}

	function Numbers(uac){
	var numbers = /^[0-9]+$/;
	if(uac.value.match(numbers))  
	{  
	return true;  
	}  
	else  
	{  
	alert('"Account Number" must contain digits only');  
	return false;  
	}  
	}