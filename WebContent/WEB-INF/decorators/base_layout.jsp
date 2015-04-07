<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><dec:title default="Web Page" /></title>
<link rel="stylesheet" type="text/css" href="styles/style.css" />
<dec:head />
</head>
<body text="#000000" leftmargin="0" topmargin="0">
	<div id="main">
		<div id="header"> <h1>Protein Protein Interaction</h1>
		<br>
			<div id="navigation">
				<ul>
					<li> <a href="#">Contact</a> </li>
					<li> <a href="#">News</a> </li>
					<li> <a href="#">About</a> </li>
					<li> <a href="index.jsp">Home</a> </li>
				</ul>
			</div>
		</div>
		<hr />
		<!-- <div id="pageBody"> -->
		<div id="content">
			<dec:body />
		</div>
		<!-- </div> -->
		<div id="footer">
			<div class="foot_text">Copyright @2015 Bioinformatics of Harbin
				institute of technology - All Rights Reserved</div>
		</div>
	</div>
</body>
</html>
