package com.framework.qa.test.behaviour.stepDefinition;

import com.framework.qa.uicore.driver.DriverConnection;
import com.framework.qa.utils.exception.FrameworkException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Hooks.java - Suite initializer and terminator class
 *
 * @author Shiwantha Lakmal
 * @version 1.0-SNAPSHOT Last modified 04_23_2016
 * @since 04/23/2016.
 */
public class Hooks {

    final static Logger log = Logger.getLogger(Hooks.class);
    public static RemoteWebDriver driver;

    @BeforeClass
    public void suiteInitiate(){
    }

    @Before
    public void testInitiate(Scenario scenario) throws FrameworkException {
        driver = DriverConnection.getDeriverInstance();
        log.info("***********************************************");
        log.info("** STARTS: "+scenario.getName()+"");
        log.info("***********************************************");
    }

    @After
    public void testTerminate(Scenario scenario) throws FrameworkException {
        if (scenario.isFailed()){
            try {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }catch (WebDriverException ex) {
                log.error("[NOTE]: Error Occurred ! "+ex.getMessage());
            }
        }
        DriverConnection.closeDriver();
        log.info("***********************************************");
        if (scenario.getStatus().equals("passed")){
            log.info("** FINISH: "+scenario.getName()+" - STATUS: "+scenario.getStatus().toUpperCase());
        }else{
            log.error("** FINISH: "+scenario.getName()+" - STATUS: "+scenario.getStatus().toUpperCase());
        }
        log.info("***********************************************");
        log.info("[NOTE]: Terminate Driver Connection...");
    }

    @AfterClass
    public void suiteTerminate(){
    }
}
