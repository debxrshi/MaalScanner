<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Scans</title>
<link rel="stylesheet" 
	href="css/recen.css">
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
	<script src="js/rescan.js" type="text/javascript"></script>
</head>
<body>
	<div class="navbar">
		<a href="#" class="logo">ZenRADAR</a>
		<nav>
			<ul class="links">
				<li><a href="index.jsp">HOME </a></li>
				<li><a href="recent.jsp">RECENT SCANS</a></li>
				<li><a href="#">VENDOR LIST</a></li>
				<li><a href="myscans.jsp">YOUR SCANS</a></li>
				<label class="icons"> <i class="fa-solid fa-bars"></i>
				</label>
			</ul>
		</nav>
	</div>
	<main class="table">
		<table>
			<thead>
				<tr>
					<th>File Name</th>
					<th>SHA-256</th>
					<th>Analysis</th>
					<th>Date</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>gita.exe</td>
					<td>3b9009532a3f25be4e44eb12b4fae53247e38c49e3a3d652dd0901e020d8a909</td>
					<td style="color: rgb(1, 154, 1);">Valid</td>
					<td>31 October, 2023</td>
					<td><a href="#" class="rescan-link" style="color: blue;"><i class="fa-solid fa-up-right-from-square"></i> Rescan</a>
				</td>
				</tr>
				<tr>
					<td>bhagavadgita.pdf</td>
					<td>f7afc70de35d849d7c7c7da704fecbc2dde688562a70fc7efdab2e26a9b1585b</td>
					<td style="color: rgb(1, 154, 1);">Valid</td>
					<td>31 October, 2023</td>
					<td><a href="#" class="rescan-link" style="color: blue;"><i class="fa-solid fa-up-right-from-square"></i> Rescan</a></td>
				</tr>
				<tr>
					<td>gg.zip</td>
					<td>98d44e13f455d916674d38424d39e1cb01b2a9132aacbb7b97a6f8bb7feb2544</td>
					<td style="color: rgb(1, 154, 1);">Valid</td>
					<td>31 October, 2023</td>
					<td><a href="#" class="rescan-link" style="color: blue;"><i class="fa-solid fa-up-right-from-square"></i> Rescan</a></td>
				</tr>
				<tr>
					<td>ez.exe</td>
					<td>98d44e13f455d916674d38424d39e1cb01b2a9132aacbb7b97a6f8bb7feb2544</td>
					<td style="color: red;"><i class="fas fa-exclamation-triangle"></i> Malicious</td>
					<td>31 October, 2023</td>
					<td><a href="#" class="rescan-link" style="color: blue;"><i class="fa-solid fa-up-right-from-square"></i> Rescan</a></td>
				</tr><tr>
					<td>bc.exe</td>
					<td>98d44e13f455d916674d38424d39e1cb01b2a9132aacbb7b97a6f8bb7feb2544</td>
					<td style="color: rgb(1, 154, 1);">Valid</td>
					<td>31 October, 2023</td>
					<td><a href="#" class="rescan-link" style="color: blue;"><i class="fa-solid fa-up-right-from-square"></i> Rescan</a></td>
				</tr>
				<tr>
					<td>nayn.cat</td>
					<td>98d44e13f455d916674d38424d39e1cb01b2a9132aacbb7b97a6f8bb7feb2544</td>
					<td style="color: red;"><i class="fas fa-exclamation-triangle"></i> Malicious</td>					
					<td>31 October, 2023</td>
					<td><a href="#" class="rescan-link" style="color: blue;"><i class="fa-solid fa-up-right-from-square"></i> Rescan</a></td>
				</tr>
				<tr>
					<td>sintia.apk</td>
					<td>98d44e13f455d916674d38424d39e1cb01b2a9132aacbb7b97a6f8bb7feb2544</td>
					<td style="color: red;"><i class="fas fa-exclamation-triangle"></i> Malicious</td>					
					<td>31 October, 2023</td>
					<td><a href="#" class="rescan-link" style="color: blue;"><i class="fa-solid fa-up-right-from-square"></i> Rescan</a></td>
				</tr>
				<tr>
					<td>gn.ppt</td>
					<td>98d44e13f455d916674d38424d39e1cb01b2a9132aacbb7b97a6f8bb7feb2544</td>
					<td style="color: red;"><i class="fas fa-exclamation-triangle"></i> Malicious</td>					
					<td>31 October, 2023</td>
					<td><a href="#" class="rescan-link" style="color: blue;"><i class="fa-solid fa-up-right-from-square"></i> Rescan</a></td>
				</tr>
				<tr>
					<td>puneet.exe</td>
					<td>98d44e13f455d916674d38424d39e1cb01b2a9132aacbb7b97a6f8bb7feb2544</td>
					<td style="color: red;"><i class="fas fa-exclamation-triangle"></i> Malicious</td>					
					<td>31 October, 2023</td>
					<td><a href="#" class="rescan-link" style="color: blue;"><i class="fa-solid fa-up-right-from-square"></i> Rescan</a></td>
				</tr>
			</tbody>
		</table>
	</main>
</body>
</html>