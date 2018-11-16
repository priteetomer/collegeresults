function checkform(){
	
	var name = $("input[name='txtname']").val();
	var fathername = $("input[name='txtfathername']").val();
	
	var valid = true;
	
	$(".msg").html("");
	
	if(name.length==0){
		valid = false;
		$("#msgupdatename").html("?");
	}
	if(fathername.length==0){
		valid = false;
		$("#msgupdatefathername").html("?");
	}
	
	return valid;
}