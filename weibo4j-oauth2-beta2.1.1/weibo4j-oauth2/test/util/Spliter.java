package util;

 
 import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
 
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;
 
 
 public class Spliter {
     
        
     /**
      * 打印出给定分词器的分词结果
      * @param analyzer 分词器
      * @param text 文本
      * @throws Exception
      */
	 
//	 private static Analyzer analyzer;
//	 
//	 static
//	 {
//		 analyzer = new IKAnalyzer();
//	 }
	 
     public List<String> split(String text)  {
    	 LinkedList<String> list = null;
		try {
//			System.out.println("当前使用的分词器：" + analyzer.getClass().getSimpleName());
			Analyzer analyzer = new IKAnalyzer();
			 TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(text));
			 tokenStream.addAttribute(CharTermAttribute.class);
			 list = new LinkedList<String>();
			 while (tokenStream.incrementToken()) {
			     CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
			     list.add(charTermAttribute.toString());
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
         return list;
     }
     public static void main(String args[])
     {

     }
 }