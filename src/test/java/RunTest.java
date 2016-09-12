import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Yogesh on 12-09-2016.
 */


@RunWith(Cucumber.class)
@CucumberOptions(format="html:target/CucumberReports",
                    features="src/test/feature/",
                        tags="@smoke")
public class RunTest {
}
