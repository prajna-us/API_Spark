package utilities;

import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJson {

    private JSONObject testData;

    public JSONObject setUpTestData() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("src/test/resources/TestData/Team11-APISpark_TestData.json")));
            testData = new JSONObject(content);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return testData;

    }



}
