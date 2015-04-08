package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.pubmed_IDAbstract;

/**
 * Servlet implementation class pubmedAnalysisServlet
 */
public class pubmedAnalysisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public pubmedAnalysisServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=gbk");
		response.setCharacterEncoding("utf-8");
		String query = request.getParameter("pubmedInputData").trim();
		if (query == null)
			return;

		String pubmedID = getPubmedData(query, "<ID>", "</ID>");
		String pubmedAbstract = getPubmedData(query, "<TEXT>", "</TEXT>");

		pubmed_IDAbstract pubmed = new pubmed_IDAbstract(pubmedID,
				pubmedAbstract);
		// System.out.println("test example.");
		// List<Sentence> geneTagSentenceList = GeneTagger("banner.properties",
		// "/home/jack/Workspaces/tarDIR/model_BC2GM.bin",
		// pubmedAbstract);
		// for (Sentence sent : geneTagSentenceList) {
		// System.out.println("-----------------------");
		// System.out.println(sent.getText());
		// System.out.println(sent.getSGML());
		// }
		 HttpSession hs = request.getSession();
		 hs.setAttribute("pubmedIdAndAbstract", pubmed);
		 response.sendRedirect("pubmedAnalysis.jsp?result=true");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private String getPubmedData(String pubmedText, String splitBegin,
			String splitEnd) {
		String pubmedDataStr = "";
		int beginIndex = pubmedText.indexOf(splitBegin);
		int endIndex = pubmedText.indexOf(splitEnd);
		if (beginIndex > endIndex)
			return null;
		pubmedDataStr = pubmedText.substring(beginIndex + splitBegin.length(),
				endIndex);
		return pubmedDataStr.trim();
	}

	/**
	 * 函数作用: 识别出自然文本句子中的基因
	 */
//	public List<Sentence> GeneTagger(String propertiesFilename,
//			String modelFilename, String pubmedAbstractText) throws IOException {
//		// Get the properties and create the tagger
//		BannerProperties properties = BannerProperties.load(propertiesFilename);
//		Tokenizer tokenizer = properties.getTokenizer();
//		CRFTagger tagger = CRFTagger.load(new File(modelFilename),
//				properties.getLemmatiser(), properties.getPosTagger());
//		PostProcessor postProcessor = properties.getPostProcessor();
//
//		// // Get the input text
//		// BufferedReader inputReader = new BufferedReader(pubmedAbstractText);
//		// String text = "";
//		// String line = inputReader.readLine();
//		// while (line != null) {
//		// text += line.trim() + " ";
//		// line = inputReader.readLine();
//		// }
//		// inputReader.close();
//
//		String text = pubmedAbstractText;
//		// Break the input into sentences, tag
//		List<Sentence> geneTagSentenceList = new ArrayList<Sentence>();
//		BreakIterator breaker = BreakIterator.getSentenceInstance();
//		breaker.setText(text);
//		int start = breaker.first();
//		for (int end = breaker.next(); end != BreakIterator.DONE; start = end, end = breaker
//				.next()) {
//			String sentenceText = text.substring(start, end).trim();
//			if (sentenceText.length() > 0) {
//				Sentence sentence = new Sentence(null, sentenceText);
//				tokenizer.tokenize(sentence);
//				tagger.tag(sentence);
//				if (postProcessor != null)
//					postProcessor.postProcess(sentence);
//				geneTagSentenceList.add(sentence);
//			}
//		}
//		return geneTagSentenceList;
//	}
}
