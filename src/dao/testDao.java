package dao;

import java.io.File;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import banner.BannerProperties;
import banner.Sentence;
import banner.processing.PostProcessor;
import banner.tagging.CRFTagger;
import banner.tokenization.Tokenizer;
import bean.pubmed_IDAbstract;
import bean.pubmed_NERMention;

public class testDao {
	private pubmed_IDAbstract pubmed;
	
	public testDao(String pubmedID, String pubmedAbstract)
	{
		pubmed = new pubmed_IDAbstract();
		pubmed.setPubmedid(pubmedID);
		pubmed.setPubmedAbstractText(pubmedAbstract);
	}
	
	public static void main(String[] args) throws IOException {
		
		String propertiesFilename = "libs/banner.properties";
		String modelFilename = "libs/model_BC2GM.bin";
		String pubmedAbstractText = "HSP27 and HSP70 interact with CD10 in C4-2 prostate cancer cells. BACKGROUND: CD10 is an approximately 100 kDa transmembrane metallo-endopeptidase. CD10 is strongly expressed by normal prostate epithelium. While only 30% of primary prostate tumors express CD10, it is strongly expressed by most lymph node metastases. The function of CD10 and the interaction between CD10 and other cellular proteins in prostate cancer (CaP) is not well defined. Cellular context  may ultimately determine its biologic function in CaP. In this study, we compared CD10 mRNA and protein expression between benign and malignant prostate cells and  employed proteomic analysis to identify proteins that interact with CD10 in C4-2  prostate cancer cells. METHODS: CD10 mRNA and protein expression was compared using RT-PCR and Western blotting. CD10-protein complexes were isolated by immunoprecipitation using anti-CD10 monoclonal antibodies. Eluted fractions were  combined, trypsinized, and the resulting peptides analyzed by microLC-ESI-MS/MS.  The parent proteins were identified by searching MS/MS spectra against a human protein database using SEQUEST. RESULTS: There were no differences in CD10 mRNA length or CD10 protein molecular weight between normal tissue and CaP. We identified 75 proteins unique to or heavily enriched in the CD10 immunoprecipitates by proteomic analysis. The 27 kDa heat shock protein (HSP27) and HSP70 were identified in three separate precipitations. Protein identification by proteomics was confirmed by Western blotting. Protein complexes immunopurified from C4-2 protein extracts using anti-HSP27 and anti-HSP70 antibodies were found to contain CD10. CONCLUSIONS: The function of CD10 in prostate cancer is largely unknown. In the C4-2 CaP cell line, CD10 was found to  interact with both HSP27 and HSP70.";
		
		pubmed_NERMention pubmedNER = new pubmed_NERMention();
		// Get the properties and create the tagger
		BannerProperties properties = BannerProperties.load(propertiesFilename);
		Tokenizer tokenizer = properties.getTokenizer();
		CRFTagger tagger = CRFTagger.load(new File(modelFilename),
				properties.getLemmatiser(), properties.getPosTagger());
		PostProcessor postProcessor = properties.getPostProcessor();
		
		String text = pubmedAbstractText;
		// Break the input into sentences, tag
		List<Sentence> geneTagSentenceList = new ArrayList<Sentence>();
		BreakIterator breaker = BreakIterator.getSentenceInstance();
		breaker.setText(text);
		int start = breaker.first();
		for (int end = breaker.next(); end != BreakIterator.DONE; start = end, end = breaker
				.next()) {
			String sentenceText = text.substring(start, end).trim();
			if (sentenceText.length() > 0) {
				Sentence sentence = new Sentence(null, sentenceText);
				tokenizer.tokenize(sentence);
				tagger.tag(sentence);
				if (postProcessor != null)
					postProcessor.postProcess(sentence);
				geneTagSentenceList.add(sentence);
			}
		}
		
		for (Sentence sent : geneTagSentenceList) {
			System.out.println("-----------------------");
			System.out.println(sent.getText());
			System.out.println(sent.getSGML());
		}
		
		pubmedNER.setGeneTagSentenceList(geneTagSentenceList);
	}

}
