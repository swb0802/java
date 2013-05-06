 
 import java.io.StringReader;
 
 import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;
 
 
 /**
  * IKAnalyzer 分词器测试
  * @author Luxh
  */
 public class IKAnalyzerTest {
     
     public void testIKAnalyzer() throws Exception {
         
         String keyWord = "IKAnalyzer是一个开源的，基于java语言开发的轻量级的中文分词工具包。从2006年12月推出1.0版开始， IKAnalyzer已经推出了3个大版本。";
         
         IKAnalyzer analyzer = new IKAnalyzer();
         
         //使用智能分词
         analyzer.setUseSmart(true);
         
         //打印分词结果
         printAnalysisResult(analyzer,keyWord);
         
     }
     
     /**
      * 打印出给定分词器的分词结果
      * @param analyzer 分词器
      * @param keyWord 关键词
      * @throws Exception
      */
     private void printAnalysisResult(Analyzer analyzer, String keyWord) throws Exception {
         System.out.println("当前使用的分词器：" + analyzer.getClass().getSimpleName());
         TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(keyWord));
         tokenStream.addAttribute(CharTermAttribute.class);
         while (tokenStream.incrementToken()) {
             CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
             System.out.println(new String(charTermAttribute.toString()));
         }
     }
     public static void main(String args[])
     {
    	IKAnalyzerTest it = new IKAnalyzerTest();
    	try {
			it.testIKAnalyzer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
 }