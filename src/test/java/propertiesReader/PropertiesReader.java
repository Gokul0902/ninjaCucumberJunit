package propertiesReader;


import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
	public static Properties prop;
	public static String url ;
	//-------------------------------------------------------
	private static PropertiesReader propertiesReader_inst=null;
	public static String browser ;
	private PropertiesReader() {
		
	}
	public static PropertiesReader inst() {
		
		if(propertiesReader_inst==null)
			propertiesReader_inst=new PropertiesReader();
		return propertiesReader_inst;
	}
	//----------------------------------------------------------------
	public  void dataReader() {
		
		/*
		 * prop=new Properties(); File file =new File(System.getProperty("user.dir")+
		 * "src\\test\\resource\\globalData.properties"); try { FileInputStream
		 * inputfile = new FileInputStream(file); prop.load(inputfile); } catch
		 * (Throwable e) { e.printStackTrace(); }
		 */
		
		prop=new Properties();
		try {
			prop.load(getClass().getResourceAsStream("/globalData.properties"));
			url = prop.getProperty("url");
			browser = prop.getProperty("browser");
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
