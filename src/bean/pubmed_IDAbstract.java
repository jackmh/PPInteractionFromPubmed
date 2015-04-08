package bean;

public class pubmed_IDAbstract {
	private String pubmedid;
	private String pubmedAbstractText;

	public pubmed_IDAbstract() {

	}

	public pubmed_IDAbstract(String pubmedID) {
		this.pubmedid = pubmedID;
	}

	public pubmed_IDAbstract(String pubmedID, String pubmedAbstract) {
		this.pubmedid = pubmedID;
		this.pubmedAbstractText = pubmedAbstract;
	}

	public String getPubmedid() {
		return pubmedid;
	}

	public void setPubmedid(String pubmedid) {
		this.pubmedid = pubmedid;
	}

	public String getPubmedAbstractText() {
		return pubmedAbstractText;
	}

	public void setPubmedAbstractText(String pubmedAbstractText) {
		this.pubmedAbstractText = pubmedAbstractText;
	}
}
