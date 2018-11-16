<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    
    
<c:if test="${sessionScope.loggeduser ne null}">    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Tula's college result section</title>

<link type="text/css" rel="stylesheet" href="css/common.css"/>
<link type="text/css" rel="stylesheet" href="css/admin.css"/>

<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="scripts/admin.js"></script>

</head>
<body>

	<div class="box">

		<jsp:include page="adminheader.jsp"/>			
		
		<div class="content">
		
			<div class="leftpart">
				<jsp:include page="adminmenu.jsp"/>
			</div>
			
			<div class="rightpart">
				
				<div class="row">
					<b>Welcome to Administrator Section</b>
				</div>
				
				<div class="row">
					&nbsp;&nbsp;You can manage following here...<br/>
					
					<ul class="options">
						<li>Add Student</li>
						<li>Edit Student Information</li>
						<li>Remove Student</li>
						<li>Add Student Result</li>
						<li>Add Student</li>
						<li>Add Student</li>
					</ul>
				</div>

			</div>			
		
			<div class="clear"></div>
		</div>
	
	</div>

</body>
</html>

</c:if>
<c:if test="${sessionScope.loggeduser eq null}">
	<c:redirect url="index.jsp"></c:redirect>
</c:if>