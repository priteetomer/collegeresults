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
	var subject = $("input[name='txtsubject']").val();
	var maximum = $("input[name='txtmaximum']").val();
	var minimum = $("input[name='txtminimum']").val();
	var obtained = $("input[name='txtobtained']").val();
	
	var valid = true;
	
	$(".msg").html("");
	
	if(rollno.length==0){
		valid = false;
		$("#msgrollno").html("?");
	}
	
	if(subject.length==0){
		valid = false;
		$("#msgsubject").html("?");
	}
	
	if(maximum.length==0 || isNaN(maximum)){
		valid = false;
		$("#msgmarks").html("Invalid maximum marks!");
	}
	else if(minimum.length==0 || isNaN(minimum)){
		valid = false;
		$("#msgmarks").html("Invalid minimum marks!");
	}	
	else if(obtained.length==0 || isNaN(obtained)){
		valid = false;
		$("#msgmarks").html("Invalid obtained marks!");
	}
	
	return valid;
}