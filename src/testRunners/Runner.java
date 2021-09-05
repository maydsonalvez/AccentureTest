package testRunners;

import org.junit.runner.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="MyTest",glue= {"stepdefinitions"})
public class Runner 
{

}
