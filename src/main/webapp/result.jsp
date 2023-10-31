<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ page import="com.scanner.*" %>
<%@ page import="java.util.*" %>

<%@ page import="com.dao.*" %>
<%@ page import="com.model.*" %>
<%@ page import="java.io.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Malware Scanner Home</title>
<link rel="stylesheet" href="css/styles.css">
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;400&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Anton&family=Poppins:wght@100;400&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/166366233a.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="navbar">
		<a href="#" class="logo">ZenRADAR</a>
		<nav>
			<ul class="links">
				<li><a href="index.jsp">HOME </a></li>
				<li><a href="#">RECENT SCANS</a></li>
				<li><a href="#">VENDOR LIST</a></li>
				<li><a href="#">YOUR SCANS</a></li>
				<li><a href="login.jsp">SIGN IN</a></li>
				<label class="icons"> <i class="fa-solid fa-bars"></i>
				</label>
			</ul>
		</nav>
	</div>
	<h1>Result Page here</h1>
	<div class="langto-pigga">
	<%
	

		try {
			String val = null;
			val = (String)request.getParameter("val");
			if(val == null){
			response.sendRedirect("index.jsp");
		}
			else{
			ScanUtils scan = new ScanUtils();
			ScanDAO db = new ScanDAO();
			List<ScanResultStruct> st = scan.scanResultParser(db.DbJsonFetch(val));
			
			for (ScanResultStruct struct: st){
		out.println(struct.getEngineName());
		out.println(struct.getCategory());
			}
			}
		}
		finally {}
	%>
	
	</div>

</body>
</html>