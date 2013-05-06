import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class TestAnalyzer02 {
	private static String chinese = "Luceneȫ�����������ѧϰ";
	private Analyzer analyzer = null;
	
	public void testStandarAnalyzer() throws Exception{
		analyzer = new StandardAnalyzer(Version.LUCENE_42);
		testAnalyzer(analyzer, chinese);
	}
	
	public void testSimpleAnalyzer() throws Exception{
		analyzer = new SimpleAnalyzer(Version.LUCENE_42);
		testAnalyzer(analyzer, chinese);
	}
	
	public void testCJKAnalyzer() throws Exception{
		analyzer = new CJKAnalyzer(Version.LUCENE_42);
		testAnalyzer(analyzer, chinese);
	}
	
	public void testIKAnalyzer() throws Exception{
		analyzer = new IKAnalyzer();
		
		testAnalyzer(analyzer, chinese);
	}
	/**
	 * ʹ��ָ���ķִ�����ָ�����ı����зִʣ�����ӡ���ֳ��Ĵ�
	 * 
	 * @param analyzer
	 * @param text
	 * @throws Exception
	 */
	private void testAnalyzer(Analyzer analyzer, String text) throws Exception {
		System.out.println("�ִ�����" + analyzer.getClass().getSimpleName());
		TokenStream tokenStream = analyzer.tokenStream("content",
				new StringReader(text));
		tokenStream.addAttribute(TypeAttribute.class);
		while (tokenStream.incrementToken()) {
			TypeAttribute termAttribute = tokenStream
					.getAttribute(TypeAttribute.class);
			System.out.println(termAttribute.type());
		}
		System.out.println();
	}

	public static void main(String args[])
	{
		TestAnalyzer02 ta = new TestAnalyzer02();
		try {
			ta.testIKAnalyzer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


