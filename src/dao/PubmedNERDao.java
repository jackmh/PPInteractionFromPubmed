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

public class PubmedNERDao {	
	/**
	 * 函数作用: 识别出自然文本句子中的基因
	 */
	public static List<Sentence> GeneTagger(String propertiesFilename,
			String modelFilename, String pubmedAbstractText) throws IOException {
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
		return geneTagSentenceList;
	}
}
