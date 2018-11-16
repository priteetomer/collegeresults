
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Tula's college result section</title>

<link type="text/css" rel="stylesheet" href="css/common.css" />
<link type="text/css" rel="stylesheet" href="css/admin.css" />
<link type="text/css" rel="stylesheet" href="css/viewresult.css" />

<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="scripts/viewresult.js"></script>

</head>
<body>

	<div class="box">

		<jsp:include page="adminheader.jsp" />

		<div class="content">

			<div class="leftpart">
				<jsp:include page="normalmenu.jsp" />
			</div>

			<div class="rightpart">

				<form action="displayresult.jsp" method="post"	onsubmit="return checkform()">
					<div class="row">
						<div class="label">Roll no.</div>
						<div class="control">
							<input type="text" class="txt" name="txtrollno" />
						</div>
						<div class="msg" id="msgrollno">&nbsp;</div>
						<div class="clear"></div>
					</div>

					<div class="row">
						<div class="label">Year</div>
						<div class="control">
							<select name="year">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
							</select>
						</div>
						<div class="clear"></div>
					</div>

					<div class="row">
						<div class="label">Semester</div>
						<div class="control">
							<select name="semester">
								<option value="Even">Even</option>
								<option value="Odd">Odd</option>
							</select>
						</div>
						<div class="clear"></div>
					</div>

					<div class="row">
						<div class="label">Exam</div>
						<div class="controlnomsg">
							<label for="rdsessional">Sessional</label> &nbsp; <input
								type="radio" name="exam" id="rdsessional"
								value="Sessional" /> &nbsp;&nbsp; <label for="rdexternal">External</label>
							&nbsp; <input type="radio" name="exam" id="rdexternal"
								value="External" checked="checked" />
						</div>
						<div class="clear"></div>
					</div>

					<div class="row" id="sessionaltype">
						<div class="label">Type</div>
						<div class="controlnomsg">
							<label for="rdsessionaltype1">I<sup>rst</sup> sessional
							</label> &nbsp; <input type="radio" name="sessionaltype"
								id="rdsessionaltype1" value="1" checked="checked" />
							&nbsp;&nbsp; <label for="rdsessionaltype2">II<sup>nd</sup>
								sessional
							</label> &nbsp; <input type="radio" name="sessionaltype"
								id="rdsessionaltype2" value="2" />
						</div>
						<div class="clear"></div>
					</div>

					<div class="row">
						<div class="label">&nbsp;</div>
						<div class="control">
							<input type="submit" value=" Show Result " class="btn" />
						</div>
						<div class="clear"></div>
					</div>
				</form>

			</div>

			<div class="clear"></div>
		</div>

	</div>

</body>
</html>
