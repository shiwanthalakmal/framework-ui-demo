package com.framework.qa.ui.pages;

import com.framework.qa.utils.exception.ApplicationException;
import com.framework.qa.utils.exception.FrameworkException;
import com.framework.qa.utils.exception.ScriptException;
import com.framework.qa.webelementcore.element.Button;
import com.framework.qa.webelementcore.element.Label;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.framework.qa.uicore.page.BasicPage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * PuppyHomePage.java - PuppyHomePage page related elements and behaviours
 *
 * @author Shiwantha Lakmal
 * @version 1.0-SNAPSHOT Last modified 04_23_2016
 * @since 04/23/2016.
 */
public class PuppyHomePage extends BasicPage{

    final static Logger log = Logger.getLogger(PuppyHomePage.class);
    protected ExtentReports extent;
    protected ExtentTest test;

    private Label pageHeader;
    private Button viewButton;

    /**
     * Initiate - Page components
     *
     * @param driver driver instance
     */
    public PuppyHomePage(RemoteWebDriver driver) throws FrameworkException {
        super(driver);
        initializeElements(this);
        log.info("Initiate " + this.getClass().getName());
    }

    /**
     * Validate - Page header message
     *
     * @param expected page header title
     */
    public void validate_Page_Header_Title(String expected) throws ScriptException, ApplicationException {
        test_step_initiation();
        verifyEquals(pageHeader.getText(),expected, "Home Page is not valid !");
        checkForVerificationErrors();
        log.info("Validate ! Page Header Title Successfully.");
    }

    /**
     * Step - Click puppy view button
     *
     * @return PuppyViewPage
     */
    public PuppyViewPage step_Click_Puppy_View() throws FrameworkException {
        test_step_initiation();
        viewButton.click();
        log.info("Click On Pully View Button.");
        return new PuppyViewPage(this.driver);
    }
}
