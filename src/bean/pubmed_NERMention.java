package bean;

import java.util.List;

import banner.Sentence;

public class pubmed_NERMention {
	
	private pubmed_IDAbstract pubmed_IDAbstract;
	private List<Sentence> geneTagSentenceList;
	

	public pubmed_IDAbstract getPubmed_IDAbstract() {
		return pubmed_IDAbstract;
	}

	public void setPubmed_IDAbstract(pubmed_IDAbstract pubmed_IDAbstract) {
		this.pubmed_IDAbstract = pubmed_IDAbstract;
	}

	public List<Sentence> getGeneTagSentenceList() {
		return geneTagSentenceList;
	}

	public void setGeneTagSentenceList(List<Sentence> geneTagSentenceList) {
		this.geneTagSentenceList = geneTagSentenceList;
	}
}
