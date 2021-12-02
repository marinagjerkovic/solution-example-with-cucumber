package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {
                "src/test/resources/api-features"
                ,"src/test/resources/ui-features"
        }
        ,glue = {
                "api/steps"
                ,"ui/steps"
        }
        ,plugin = {
                "pretty"
                ,"html:target/cucumber-reports.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
//        @Override
//        @DataProvider(parallel = true)
//        public Object[][] scenarios() {
//                return super.scenarios();
//        }  
}
