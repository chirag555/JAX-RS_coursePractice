<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${Devices.brandName} Devices</title>
</head>
<body>
${Devices}

<c:foreach var="device" items="${devices}" >
</c:foreach>



</body>
</html>