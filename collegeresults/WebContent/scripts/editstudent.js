function checkform(){
	
	var rollno = $("input[name='txtrollno']").val();
	
	var valid = true;
	
	$(".msg").html("");
	
	if(rollno.length==0){
		valid = false;
		$("#msgrollno").html("?");
	}
	
	return valid;
}