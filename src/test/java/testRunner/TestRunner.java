package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"}, glue = {"stepDifinitions"},

        monochrome = true,
        plugin = {

                "pretty", "html:target/CucumberReport/RestAssuredAPI.html"
//                ,
//                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//                ,
//               "pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7" + "Jvm"

        }
)

public class TestRunner {

}
