package utilities;

import java.util.ResourceBundle;


public class ReadProperties {
	
	
	public static ResourceBundle readProp=ResourceBundle.getBundle("pathAll");
	public static ReadXLUtils readXLUtils= new ReadXLUtils(readProp.getString("XLPath"));
	
	
}
