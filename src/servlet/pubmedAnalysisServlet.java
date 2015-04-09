package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PubmedNERDao;
import dao.pubmedIDAbstractDao;
import banner.Sentence;
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
		
		pubmedIDAbstractDao pubmedIDAbstractDao = new pubmedIDAbstractDao();
		String pubmedID = pubmedIDAbstractDao.getPubmedData(query, "<ID>", "</ID>");
		String pubmedAbstract = pubmedIDAbstractDao.getPubmedData(query, "<TEXT>", "</TEXT>");

		pubmed_IDAbstract pubmed = new pubmed_IDAbstract(pubmedID,
				pubmedAbstract);
		HttpSession hs = request.getSession();
		
		List<Sentence> geneTagSentenceList = PubmedNERDao.GeneTagger("/home/jack/workspace/PPInteractionFromPubmed/banner.properties",
				"/home/jack/workspace/PPInteractionFromPubmed/model_BC2GM.bin", pubmedAbstract);
		hs.setAttribute("pubmedIdAndAbstract", pubmed);
		hs.setAttribute("proteinNERSentenceList", geneTagSentenceList);
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
}
