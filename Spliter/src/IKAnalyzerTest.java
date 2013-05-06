 
 import java.io.StringReader;
 
 import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;
 
 
 /**
  * IKAnalyzer �ִ�������
  * @author Luxh
  */
 public class IKAnalyzerTest {
     
     public void testIKAnalyzer() throws Exception {
         
         String keyWord = "IKAnalyzer��һ����Դ�ģ�����java���Կ����������������ķִʹ��߰�����2006��12���Ƴ�1.0�濪ʼ�� IKAnalyzer�Ѿ��Ƴ���3����汾��";
         
         IKAnalyzer analyzer = new IKAnalyzer();
         
         //ʹ�����ִܷ�
         analyzer.setUseSmart(true);
         
         //��ӡ�ִʽ��
         printAnalysisResult(analyzer,keyWord);
         
     }
     
     /**
      * ��ӡ�������ִ����ķִʽ��
      * @param analyzer �ִ���
      * @param keyWord �ؼ���
      * @throws Exception
      */
     private void printAnalysisResult(Analyzer analyzer, String keyWord) throws Exception {
         System.out.println("��ǰʹ�õķִ�����" + analyzer.getClass().getSimpleName());
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