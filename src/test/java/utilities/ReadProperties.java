package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;




public class ReadProperties {

    private static final String CONFIG_FILE_PATH = "src/test/resources/pathAll.properties";
    private static Properties properties;

    public static void loadConfig() {
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


    public static void storeInConfig(String key, String val) throws IOException {

        try {
            // Load the existing properties file
            FileInputStream fileInput = new FileInputStream(CONFIG_FILE_PATH);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

            // Set the new key-value pair
            properties.setProperty(key, val);

            // Save the updated properties to the file
            FileOutputStream fileOutput = new FileOutputStream(CONFIG_FILE_PATH);
            properties.store(fileOutput, "Updated " + key + " value");
            fileOutput.close();
            System.out.println("Property added successfully!");

        } catch (IOException ex) {
            System.err.println("Error occurred while adding property: " + ex.getMessage());
            ex.printStackTrace();
        }

    }

    public static void reload() {
        loadConfig();
    }



}
