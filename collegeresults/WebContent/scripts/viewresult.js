$(document).ready(init);

function init(){
	$("#sessionaltype").css("display","none");

	$("input[name='exam']").click(function(){
		var value = $(this).val();
		
		if(value=="Sessional")
			$("#sessionaltype").css("display","block");
		else
			$("#sessionaltype").css("display","none");
	});
}

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