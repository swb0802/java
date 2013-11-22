package swb.tools;

import java.lang.instrument.Instrumentation;

public class MySizeOf {
    private static Instrumentation inst;
    /**
      *�����������д����agent����ʱ�ᱻ����
      */
    public static void premain(String agentArgs, Instrumentation instP) {
        inst = instP;
    }
   
    //��������java����Ĵ�С����������������С����ȷ�ģ����������
    public static long sizeOf(Object o) {
        if(inst == null) {
           throw new IllegalStateException("Can not access instrumentation environment.\n" +
              "Please check if jar file containing SizeOfAgent class is \n" +
              "specified in the java's \"-javaagent\" command line argument.");
         }
         return inst.getObjectSize(o);
     }
    
    public static void main(String []args) {  
        System.out.println(MySizeOf.sizeOf(new Integer(1)));  
        System.out.println(MySizeOf.sizeOf(new String("a")));  
        System.out.println(MySizeOf.sizeOf(new char[1]));  
      }
}