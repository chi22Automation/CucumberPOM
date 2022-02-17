package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"simple.feature"}, glue= {"Steps"})

public class TestRunner extends AbstractTestNGCucumberTests {

}
