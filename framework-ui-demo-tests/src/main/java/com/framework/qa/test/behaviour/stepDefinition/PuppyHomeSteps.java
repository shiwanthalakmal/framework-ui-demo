package com.framework.qa.test.behaviour.stepDefinition;

import com.framework.qa.ui.pages.PuppyAdoptPage;
import com.framework.qa.ui.pages.PuppyCompletePage;
import com.framework.qa.ui.pages.PuppyHomePage;
import com.framework.qa.ui.pages.PuppyViewPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * PuppyHomeSteps.java - PuppyHomePage page related steps definition class
 *
 * @author Shiwantha Lakmal
 * @version 1.0-SNAPSHOT Last modified 04_25_2016
 * @since 04/25/2016.
 */
public class PuppyHomeSteps {

    private PuppyHomePage homePage;
    private PuppyViewPage viewPage;
    private PuppyAdoptPage adoptPage;
    private PuppyCompletePage completePage;

    @Given("^I am on the puppy adoption home page$")
    public void I_am_on_the_puppy_adoption_home_page() throws Throwable {
        homePage = new PuppyHomePage(Hooks.driver);
    }

    @Then("^I should see page header title$")
    public void I_should_see_page_header_title() throws Throwable {
        homePage.validate_Page_Header_Title("Puppy List");
    }

    @And("^I should see puppy view page button$")
    public void I_should_see_puppy_view_page_button() throws Throwable {
        viewPage = homePage.step_Click_Puppy_View();
    }

    @And("^I adopt selected puppy$")
    public void iAdoptSelectedPuppy() throws Throwable {
        adoptPage = viewPage.step_Click_AdoptMe_Button();
    }

    @Then("^I continue adoption completion flow$")
    public void iContinueAdoptionCompletionFlow() throws Throwable {
        adoptPage.step_Check_Price_Option();
        completePage = adoptPage.step_Click_Complete_Flow_Button();
    }

    @And("^I fill all necessary registration details$")
    public void iFillAllNecessaryRegistrationDetails() throws Throwable {
        completePage.step_Fill_Registration_Details("Shiwantha", "141 Pitipana", "Shiwantha@gmail.com", "Check");
    }

    @Then("^I submit the place order$")
    public void iSubmitThePlaceOrder() throws Throwable {
        completePage.step_Submit_Order();
    }
}
