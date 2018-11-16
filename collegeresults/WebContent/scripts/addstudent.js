function checkform(){
	
	var rollno = $("input[name='txtrollno']").val();
	var name = $("input[name='txtname']").val();
	var fathername = $("input[name='txtfathername']").val();
	
	var valid = true;
	
	$(".msg").html("");
	
	if(rollno.length==0){
		valid = false;
		$("#msgrollno").html("?");
	}
	if(name.length==0){
		valid = false;
		$("#msgname").html("?");
	}
	if(fathername.length==0){
		valid = false;
		$("#msgfathername").html("?");
	}
	
	return valid;
}