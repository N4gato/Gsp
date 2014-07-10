<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.beans.beans.Positions" %>
<%@ page import="java.io.PrintWriter" %>

<% 

ArrayList<Positions> list =new ArrayList<Positions>();
PrintWriter o = response.getWriter();
list = (ArrayList<Positions>) request.getAttribute("positionListe");

for(Positions p : list){
	o.println(p.getId());
	o.println(p.getLongitude());
}

%>
</body>
</html>