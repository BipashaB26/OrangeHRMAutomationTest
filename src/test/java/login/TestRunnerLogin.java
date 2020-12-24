package login;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/login", glue={"login"}, monochrome=true, 
                   plugin= {"html:target/cucumber-html-report", "json:target/cucumber.json",
                		   "pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json", 
                		   "junit:target/cucumber-results.xml"})

public class TestRunnerLogin extends AbstractTestNGCucumberTests {

}
