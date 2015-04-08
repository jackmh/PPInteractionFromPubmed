package dao;

import bean.pubmed_IDAbstract;

public class testDao {
	private pubmed_IDAbstract pubmed;
	
	public testDao(String pubmedID, String pubmedAbstract)
	{
		pubmed = new pubmed_IDAbstract();
		pubmed.setPubmedid(pubmedID);
		pubmed.setPubmedAbstractText(pubmedAbstract);
	}

}
