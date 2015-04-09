package dao;

public class pubmedIDAbstractDao {
	public String getPubmedData(String pubmedText, String splitBegin,
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
	 * 判断数据输入是否合法
	 */
	
	/**
	 * 标准化输入数据
	 */
}
