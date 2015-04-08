<%@ page language="java"
	import="java.util.*, bean.pubmed_IDAbstract"
 contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pubmed abstract analysis</title>
</head>
<body>
	<div id="analysisContents">
		<%
			HttpSession hs = request.getSession();
			String result = request.getParameter("result");
			pubmed_IDAbstract pubmed = (pubmed_IDAbstract)hs.getAttribute("pubmedIdAndAbstract");
			String pubmedID = pubmed.getPubmedid();
			String pubmedAbstract = pubmed.getPubmedAbstractText();
		%>
		<label class="pubmedID">
			<a  target="_blank" href="http://www.ncbi.nlm.nih.gov/pubmed/?term=<%=pubmedID %>"><%=pubmedID %></a></label>
		<p class="pubmedAbstractText"> <%=pubmedAbstract %>
		</p>
	</div>
</body>
</html>