package api.test.demo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        tags = "@TestsAll",
        features = {"src/test/resources/features/"},
        glue = {"classpath:api/test/demo"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        })
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
