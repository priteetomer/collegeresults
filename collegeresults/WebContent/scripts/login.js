$(document).ready(init);

function init(){
	$("input[name='btn']").click(checkLogin);
}

function checkLogin(){
	
	var id = $("input[name='txtid']").val();
	var password = $("input[name='txtpassword']").val();
	
	var valid = true;
	
	$(".msg").html("");
	
	if(id.length==0){
		valid = false;
		$("#msgid").html("?");
	}

	if(password.length==0){
		valid = false;
		$("#msgpassword").html("?");
	}
		
	if(valid){
		
		var frm = $("#frm").serialize();
		
		$.ajax({
			url: 'login',
			type: 'POST',
			data: frm,
			success: function(res){
				if(res.indexOf("logged")>-1){
					window.location.replace("adminsection.jsp");
				}
				else
					$("#msgresult").html("Invalid id or password...");
			}
		});
	}
}