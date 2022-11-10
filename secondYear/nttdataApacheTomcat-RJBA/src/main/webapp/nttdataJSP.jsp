<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.nttdata.tomcat.*"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>nttdataJSP</title>
</head>
<body>

<p> Bienvenido a NTT Data - Primer JSP</p>

<%

for (int i=0;i<10;i++){
	out.print("A la de... " + i);
}

%>

<p><%=NTTDataJSP.helloNTTData("Rafa") %></p>

</body>
</html>