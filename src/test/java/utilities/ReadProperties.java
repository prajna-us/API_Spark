package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;




public class ReadProperties {


    private static final String CONFIG_FILE_PATH = "src/test/resources/pathAll.properties";
    private static final Properties properties;

    static {
        properties = new Properties();
        try {

            LoggerLoad.info("Reading properties file from: " + CONFIG_FILE_PATH);

            FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH);
            properties.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }


}
