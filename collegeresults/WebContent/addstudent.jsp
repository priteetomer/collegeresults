<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${sessionScope.loggeduser ne null}">

	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Tula's college result section</title>

<link type="text/css" rel="stylesheet" href="css/common.css" />
<link type="text/css" rel="stylesheet" href="css/admin.css" />

<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="scripts/addstudent.js"></script>

</head>
<body>

	<div class="box">

		<jsp:include page="adminheader.jsp" />

		<div class="content">

			<div class="leftpart">
				<jsp:include page="adminmenu.jsp" />
			</div>

			<div class="rightpart">

				<form action="addstudent" method="post" onsubmit="return checkform()">
					<div class="row">
						<div class="label">Roll no.</div>
						<div class="control">
							<input type="text" class="txt" name="txtrollno" />
						</div>
						<div class="msg" id="msgrollno">&nbsp;</div>
						<div class="clear"></div>
					</div>

					<div class="row">
						<div class="label">Name</div>
						<div class="control">
							<input type="text" class="txt" name="txtname" />
						</div>
						<div class="msg" id="msgname">&nbsp;</div>
						<div class="clear"></div>
					</div>

					<div class="row">
						<div class="label">Father name</div>
						<div class="control">
							<input type="text" class="txt" name="txtfathername" />
						</div>
						<div class="msg" id="msgfathername">&nbsp;</div>
						<div class="clear"></div>
					</div>

					<div class="row">
						<div class="label">&nbsp;</div>
						<div class="control">
							<input type="submit" value=" Add Student " class="btn" />
						</div>
						<div class="clear"></div>
					</div>

					<div class="row" id="msgresult">${param.msg eq null ? "" : param.msg}</div>
				</form>

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
