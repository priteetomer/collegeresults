<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${sessionScope.loggeduser ne null}">

<jsp:useBean id="ob" class="com.results.beans.StudentBean"/>

<c:if test="${param.txtrollno ne null}">
	<c:set var="rollno" value="${param.txtrollno}"/>
</c:if>

	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Tula's college result section</title>

<link type="text/css" rel="stylesheet" href="css/common.css" />
<link type="text/css" rel="stylesheet" href="css/admin.css" />
<link type="text/css" rel="stylesheet" href="css/viewresult.css" />

<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="scripts/editstudent.js"></script>

</head>
<body>

	<div class="box">

		<jsp:include page="adminheader.jsp" />

		<div class="content">

			<div class="leftpart">
				<jsp:include page="adminmenu.jsp" />
			</div>

			<div class="rightpart">

				<form action="removestudent.jsp" method="post"	onsubmit="return checkform()">
					<div class="row">
						<div class="label">Roll no.</div>
						<div class="control">
							<input type="text" class="txt" name="txtrollno" value="${rollno}"/>
						</div>
						<div class="msg" id="msgrollno">&nbsp;</div>
						<div class="clear"></div>
					</div>

					<div class="row">
						<div class="label">&nbsp;</div>
						<div class="control">
							<input type="submit" value=" Search " class="btn" />
						</div>
						<div class="clear"></div>
					</div>
				</form>

				<c:if test="${param.txtrollno ne null}">
				
					<jsp:setProperty property="rollno" name="ob" param="txtrollno"/>
				
					<c:if test="${ob.studentByRollno ne null}">

						<form action="removestudent.jsp" method="post" onsubmit='return confirm("Are you sure to delete this student?")'>
						<input type="hidden" name="rollnoToDelete" value="${rollno}"/>
						<div class="row">
							<div class="label">Roll no.</div>
							<div class="control">
								${rollno}
							</div>
							<div class="clear"></div>
						</div>
						<div class="row">
							<div class="label">Name</div>
							<div class="control">
								${ob.studentByRollno.name}
							</div>
							<div class="msg" id="msgrollno">&nbsp;</div>
							<div class="clear"></div>
						</div>
						<div class="row">
							<div class="label">Father Name</div>
							<div class="control">
								${ob.studentByRollno.fatherName}
							</div>
							<div class="msg" id="msgrollno">&nbsp;</div>
							<div class="clear"></div>
						</div>
	
						<div class="row">
							<div class="label">&nbsp;</div>
							<div class="control">
								<input type="submit" value=" Delete " class="btn"/>
							</div>
							<div class="clear"></div>
						</div>
						</form>
						
					</c:if>
					<c:if test="${ob.studentByRollno eq null}">
						<div class="msgresult">No student found...</div>
					</c:if>
				
				</c:if>
				
				<c:if test="${param.rollnoToDelete ne null}">
					<jsp:setProperty property="rollnoToDelete" name="ob"/>
					<div class="msgresult">Student deleted...</div>
				</c:if>
				
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