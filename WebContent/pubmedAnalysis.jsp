<%@ page language="java"
	import="java.util.*, java.text.BreakIterator, bean.pubmed_IDAbstract, banner.Sentence"
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
		<!-- 
			蛋白质识别
	 	-->
		<%
			HttpSession hs = request.getSession();
			String result = request.getParameter("result");
			pubmed_IDAbstract pubmed = (pubmed_IDAbstract)hs.getAttribute("pubmedIdAndAbstract");
			String pubmedID = pubmed.getPubmedid();
			String pubmedAbstract = pubmed.getPubmedAbstractText();
			List<Sentence> proteinNERSentenceList = (List<Sentence>) hs.getAttribute("proteinNERSentenceList");
		%>
		<div class="pubmedID">
			<a  target="_blank" href="http://www.ncbi.nlm.nih.gov/pubmed/?term=<%=pubmedID %>"><%=pubmedID %></a>
		</div>
		<p class="pubmedNERText">
			<%
				for (Sentence sent : proteinNERSentenceList) {
					String text = sent.getSGML();
			%>
					<%=text %> &nbsp;
			<%
				}
			%>
		</p>
		<br>
	</div>
</body>
</html>