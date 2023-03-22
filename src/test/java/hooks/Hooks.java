package hooks;




import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import propertiesReader.PropertiesReader;

public class Hooks {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		PropertiesReader.inst().dataReader();
		driver=DriverFactory.inst().driverInstallation(PropertiesReader.browser);
		driver.get(PropertiesReader.url);
		
	}
	@After
	public void tearDown(Scenario scenarios){
		String ScenarioName = scenarios.getName().replace(" ","_");
		if(scenarios.isFailed()) {
		byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenarios.attach(screenshotAs,"report/png", ScenarioName);
		}
		driver.quit();
	}
}
