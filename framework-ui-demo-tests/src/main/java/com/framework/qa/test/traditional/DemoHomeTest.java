package com.framework.qa.test.traditional;

import com.framework.qa.ui.pages.PuppyHomePage;
import com.framework.qa.uicore.test.TestBase;
import com.framework.qa.utils.exception.FrameworkException;
import org.testng.annotations.Test;

public class DemoHomeTest extends TestBase{

    @Test(groups = {"BAT"})
    public void test_Verify_The_Puppy_Home() throws FrameworkException {
        new PuppyHomePage(getDriver()).
                step_Click_Puppy_View().
                step_Return_To_List_Page();
    }
}
