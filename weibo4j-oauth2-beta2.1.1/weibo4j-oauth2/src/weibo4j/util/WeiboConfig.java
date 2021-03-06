package weibo4j.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class WeiboConfig {
	public WeiboConfig(){}
	private static Properties props = new Properties();
	
	private static Properties oppProps = new Properties();	//候选属性
	private static int currentAppNo = 1;	
	private static int totalCount = 0;
	static{
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
			oppProps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("app_acounts.properties"));
			totalCount = Integer.parseInt(props.getProperty("totalCount"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int switchAcount()
	{
		currentAppNo = currentAppNo % totalCount + 1;
		if(currentAppNo != 1)
		{
			props.setProperty("client_ID", oppProps.getProperty("client_id" + currentAppNo));
			props.setProperty("client_SERCRET", oppProps.getProperty("client_SERCRET" + currentAppNo));
			props.setProperty("redirect_URI", oppProps.getProperty("redirect_URI" + currentAppNo));
		}
		else
		{
			props.setProperty("client_ID", oppProps.getProperty("client_id"));
			props.setProperty("client_SERCRET", oppProps.getProperty("client_SERCRET"));
			props.setProperty("redirect_URI", oppProps.getProperty("redirect_URI"));
		}
		return currentAppNo;
	}
	
	
	public static String getValue(String key){
		return props.getProperty(key);
	}

    public static void updateProperties(String key,String value) {    
            props.setProperty(key, value); 
    } 
}
