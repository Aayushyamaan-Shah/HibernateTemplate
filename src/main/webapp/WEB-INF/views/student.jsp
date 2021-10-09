<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Student Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a Student
</h1>

<c:url var="addAction" value="/student/add"/>

<form:form action="${addAction}" commandName="student">
    <table>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="dept_name">
                    <spring:message text="dept_name"/>
                </form:label>
            </td>
            <td>
                <form:input path="dept_name" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="tot_cred">
                    <spring:message text="tot_cred"/>
                </form:label>
            </td>
            <td>
                <form:input path="tot_cred" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty student.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Student"/>" />
                </c:if>
                <c:if test="${empty student.name}">
                    <input type="submit"
                           value="<spring:message text="Add Student"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Students List</h3>
<c:if test="${!empty listStudents}">
    <table class="tg">
        <tr>
            <th width="120">Student Name</th>
            <th width="120">Student Department</th>
            <th width="120">Age</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listStudents}" var="student">
            <tr>
                <td>${student.name}</td>
                <td>${student.dept_name}</td>
                <td>${student.tot_cred}</td>
                <td><a href="<c:url value='/editstudent/${student.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/removestudent/${student.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
