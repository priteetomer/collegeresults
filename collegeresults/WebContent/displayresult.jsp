<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${param.txtrollno ne null}">

	<jsp:useBean id="ob" class="com.results.beans.MarksBean" />
	<jsp:useBean id="st" class="com.results.beans.StudentBean" />

	<jsp:setProperty property="rollno" name="st" value="${param.txtrollno}" />

	<jsp:setProperty property="rollno" name="ob" value="${param.txtrollno}" />
	<jsp:setProperty property="year" name="ob" value="${param.year}" />
	<jsp:setProperty property="semester" name="ob" value="${param.semester}" />
	<jsp:setProperty property="exam" name="ob" value="${param.exam}" />

	<c:if test='${param.exam eq  sessional}'>
		<jsp:setProperty property="sessionalType" name="ob"
			value="${parm.sessionaltype}" />
	</c:if>

	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Tula's college result section</title>

<link type="text/css" rel="stylesheet" href="css/common.css" />
<link type="text/css" rel="stylesheet" href="css/admin.css" />
<link type="text/css" rel="stylesheet" href="css/displayresult.css" />

<script type="text/javascript" src="scripts/jquery.js"></script>

</head>
<body>

	<div class="box">

		<jsp:include page="resultheader.jsp" />

		<div class="content">

			<div class="leftpart">
				<jsp:include page="normalmenu.jsp" />
			</div>

			<div class="rightpart">

				<c:if test="${ob.marks ne null}">

					<div class="row">
						<div class="control">Name</div>
						<div class="control">${st.studentByRollno.name}</div>
						<div class="clear"></div>
					</div>

					<div class="row">
						<div class="control">Father's Name</div>
						<div class="control">${st.studentByRollno.fatherName}</div>
						<div class="clear"></div>
					</div>
			
					<hr/>

					<div class="row">
						<b>Semester =</b> ${param.semester} <br/><br/>  
						
						<c:if test='${param.exam eq "external"}'>
							External
						</c:if>

						<c:if test='${param.exam ne "external"}'>
							<b>Sessional =</b> ${param.sessionaltype}
						</c:if>
					</div>
					
					<hr/>

					<div class="row">
						<div class="labelsub resultheader">Subject</div>
						<div class="labeladd resultheader">Max</div>
						<div class="labeladd resultheader">Min</div>
						<div class="labeladd resultheader">Obtained</div>
						<div class="clear"></div>
					</div>
					
					<c:forEach items="${ob.marks}" var="marks">
					<div class="row">
						<div class="labelsub">${marks.subject}</div>
						<div class="labeladd">${marks.maximum}</div>
						<div class="labeladd">${marks.minimum}</div>
						<div class="labeladd">${marks.obtained}</div>
						<div class="clear"></div>
					</div>
					</c:forEach>

				</c:if>
				<c:if test="${ob.marks eq null}">
					<div class="msgresult">No data found...</div>
				</c:if>

			</div>

			<div class="clear"></div>
		</div>

	</div>

</body>
</html>

</c:if>
<c:if test="${param.txtrollno eq null}">
	<c:redirect url="viewresult.jsp"></c:redirect>
</c:if>
