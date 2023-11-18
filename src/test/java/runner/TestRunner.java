//package runner;
//
//
//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
//
//@RunWith(Cucumber.class) //Junit execution
//
//@CucumberOptions(
//		plugin = {"pretty", "html:target/ShoppingCart_Cucumber.html"}, //reporting purpose
//		monochrome=true,  //console output
//		tags = "@tag", //tags from feature file
//		features = {"src/test/resources/features"}, //location of feature files
//		glue= "stepDefinition") //location of step definition files
//
//
//public class TestRunner {
//
//}

package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "stepDefinition",
		plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {
	// This will run the feature file(s) using Cucumber
}

