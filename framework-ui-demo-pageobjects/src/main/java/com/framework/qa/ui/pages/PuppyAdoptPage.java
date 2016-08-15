package com.framework.qa.ui.pages;

import com.framework.qa.uicore.page.BasicPage;
import com.framework.qa.utils.exception.ApplicationException;
import com.framework.qa.utils.exception.FrameworkException;
import com.framework.qa.utils.exception.ScriptException;
import com.framework.qa.webelementcore.element.Button;
import com.framework.qa.webelementcore.element.CheckBox;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * PuppyAdoptPage.java - PuppyAdoptPage page related elements and behaviours
 *
 * @author Shiwantha Lakmal
 * @version 1.0-SNAPSHOT Last modified 04_25_2016
 * @since 04/25/2016.
 */
public class PuppyAdoptPage extends BasicPage {

    final static Logger log = Logger.getLogger(PuppyAdoptPage.class);

    private CheckBox chkOption;
    private Button btnCompletion;

    /**
     * Initiate - Page components
     *
     * @param driver driver instance
     */
    public PuppyAdoptPage(RemoteWebDriver driver) throws FrameworkException {
        super(driver);
        initializeElements(this);
        log.info("Initiate " + this.getClass().getName());
    }

    public PuppyAdoptPage step_Check_Price_Option() throws ScriptException, ApplicationException {
        test_step_initiation();
        chkOption.check();
        log.info("Checked Puppy Category");
        return this;
    }

    public PuppyCompletePage step_Click_Complete_Flow_Button() throws FrameworkException {
        test_step_initiation();
        btnCompletion.click();
        log.info("Move To Adoption Completion Flow");
        return new PuppyCompletePage(driver);
    }
}
