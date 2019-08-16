<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>testName</title>
</head>
<body>
<security:authorize access="isAuthenticated()">
    authenticated as <security:authentication property="principal.username"/>
</security:authorize>
</body>
</html>    
     
 