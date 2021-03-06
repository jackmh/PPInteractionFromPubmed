<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>protein protein interaction</title>
<meta name="keywords" content="sitemesh" />
</head>
<body>
	<h2>This is the actual page content</h2>
	<p>In this tutorial, we'll create a simple sample application using
		Sitemesh. You'll see that how easy it is to use Sitemesh and what
		tremendous features it provides. Sitemesh removes your burden of
		including layout related files in each and every page of your
		application. We won't explore all the features of Sitemesh in this
		tutorial, we'll only look at basic usage of Sitemesh.</p>
	<br>
	<div class="post">
		<p class="byline">
			please input pubmed abstract text. <i> <font> For Example:
					<a
					onclick="document.getElementById('inputTextArea').value='<ID>17342744</ID> <TEXT> HSP27 and HSP70 interact with CD10 in C4-2 prostate cancer cells. BACKGROUND: CD10 is an approximately 100 kDa transmembrane metallo-endopeptidase. CD10 is strongly expressed by normal prostate epithelium. While only 30% of primary prostate tumors express CD10, it is strongly expressed by most lymph node metastases. The function of CD10 and the interaction between CD10 and other cellular proteins in prostate cancer (CaP) is not well defined. Cellular context  may ultimately determine its biologic function in CaP. In this study, we compared CD10 mRNA and protein expression between benign and malignant prostate cells and  employed proteomic analysis to identify proteins that interact with CD10 in C4-2  prostate cancer cells. METHODS: CD10 mRNA and protein expression was compared using RT-PCR and Western blotting. CD10-protein complexes were isolated by immunoprecipitation using anti-CD10 monoclonal antibodies. Eluted fractions were  combined, trypsinized, and the resulting peptides analyzed by microLC-ESI-MS/MS.  The parent proteins were identified by searching MS/MS spectra against a human protein database using SEQUEST. RESULTS: There were no differences in CD10 mRNA length or CD10 protein molecular weight between normal tissue and CaP. We identified 75 proteins unique to or heavily enriched in the CD10 immunoprecipitates by proteomic analysis. The 27 kDa heat shock protein (HSP27) and HSP70 were identified in three separate precipitations. Protein identification by proteomics was confirmed by Western blotting. Protein complexes immunopurified from C4-2 protein extracts using anti-HSP27 and anti-HSP70 antibodies were found to contain CD10. CONCLUSIONS: The function of CD10 in prostate cancer is largely unknown. In the C4-2 CaP cell line, CD10 was found to  interact with both HSP27 and HSP70. </TEXT>';">Pubmed
						ID: 17342744</a>
			</font>
			</i>
		</p>

		<center>
			<form action="pubmedAnalysisServlet" method="POST">
				<textarea wrap="off" id="inputTextArea" name="pubmedInputData"
					rows="10" cols="100" autofocus=""></textarea>
				<br> <br>
				<input type="submit" value="Submit">
				<input type="reset" value="Clear">
			</form>
		</center>
	</div>
</body>
</html>
