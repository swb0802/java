import java.io.Reader;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.cn.ChineseAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
//import org.mira.lucene.analysis.IK_CAnalyzer;

public class TestJeAnalyzer {
    private static String testString1 = "�߳��Ĵ��볣���Ǹ����Եı�־���ᵼ�´������Բ��Ժ�ά��.";
    public static void testStandard(String testString) throws Exception{
        Analyzer analyzer = new StandardAnalyzer(org.apache.lucene.util.Version.LUCENE_30);      
        Reader r = new StringReader(testString);      
        StopFilter sf = (StopFilter) analyzer.tokenStream("", r);
        System.err.println("=====standard analyzer====");
        System.err.println("����������Ĭ��û�д�ֻ����");
        Token t;
        System.out.println(sf.toString());
//        while ((t = sf.next()) != null) {      
//            System.out.println(t.termText());      
//        }     
    }
    public static void testCJK(String testString) throws Exception{
        Analyzer analyzer = new CJKAnalyzer(org.apache.lucene.util.Version.LUCENE_30);      
        Reader r = new StringReader(testString);      
        StopFilter sf = (StopFilter) analyzer.tokenStream("", r);
        System.err.println("=====cjk analyzer====");
        System.err.println("��������:����˫�ַָ�");
        Token t;   
        System.out.println(sf.toString());
//        while ((t = sf.next()) != null) {      
//            System.out.println(t.termText());      
//        }     
    }
    public static void testChiniese(String testString) throws Exception{
        Analyzer analyzer = new ChineseAnalyzer();      
        Reader r = new StringReader(testString);      
        TokenFilter tf = (TokenFilter) analyzer.tokenStream("", r);
        System.err.println("=====chinese analyzer====");
        System.err.println("��������:������ͬStandardAnalyzer");
        Token t;   
        System.out.println(tf.toString());
//        while ((t = tf.next()) != null) {      
//            System.out.println(t.termText());      
//        }     
    }

//    public static void testJe(String testString) throws Exception{
////        Analyzer analyzer = new MIK_CAnalyzer();
//        Analyzer analyzer = new IK_CAnalyzer();
//        Reader r = new StringReader(testString); 
//        TokenStream ts = (TokenStream)analyzer.tokenStream("", r);
//        System.err.println("=====je analyzer====");
//        System.err.println("��������:�ֵ�ִ�,����˫�����������岻��");
//        Token t;   
//        System.out.println(ts.toString());
////        while ((t = ts.next()) != null) {   
////           System.out.println(t.termText());   
//////        }   
//    }
    public static void main(String[] args) throws Exception{
//        String testString = testString1;
        String testString = testString1;
        System.out.println(testString);
        
        testStandard(testString);
        testCJK(testString);
     //   testPaoding(testString);
        
         testChiniese(testString);
//         testJe(testString);
    }

}