package com.framework.qa.ui.pages;

import com.framework.qa.uicore.page.BasicPage;
import com.framework.qa.utils.exception.ApplicationException;
import com.framework.qa.utils.exception.FrameworkException;
import com.framework.qa.utils.exception.ScriptException;
import com.framework.qa.webelementcore.element.Button;
import com.framework.qa.webelementcore.element.DropdownList;
import com.framework.qa.webelementcore.element.TextField;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * PuppyCompletePage.java - PuppyCompletePage page related elements and behaviours
 *
 * @author Shiwantha Lakmal
 * @version 1.0-SNAPSHOT Last modified 04_25_2016
 * @since 04/25/2016.
 */
public class PuppyCompletePage extends BasicPage {

    final static Logger log = Logger.getLogger(PuppyCompletePage.class);

    private Button placeOrder;
    private TextField orderName;
    private TextField orderAddress;
    private TextField orderEmail;
    private DropdownList paymentType;

    /**
     * Initiate - Page components
     *
     * @param driver driver instance
     */
    public PuppyCompletePage(RemoteWebDriver driver) throws FrameworkException {
        super(driver);
        initializeElements(this);
        log.info("Initiate " + this.getClass().getName());
    }

    public PuppyCompletePage step_Fill_Registration_Details(String name,String address,String email,String pay) throws ScriptException, ApplicationException {
        orderName.enterText(name);
        orderAddress.enterText(address);
        orderEmail.enterText(email);
        paymentType.selectByOption(pay);
        log.info("Fill all necessary registration details");
        return this;
    }

    /**
     * Make place order
     * @return PuppyCompletePage
     */
    public PuppyCompletePage step_Submit_Order() throws ScriptException, ApplicationException {
        placeOrder.click();
        log.info("Press place order");
        return this;
    }
}
