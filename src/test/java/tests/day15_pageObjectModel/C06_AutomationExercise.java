package tests.day15_pageObjectModel;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercisePage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_AutomationExercise {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on ‘Signup / Login’ button
    //5. Verify ‘Login to your account’ is visible
    //6. Enter correct email address and password
    //7. Click ‘login’ button
    //8. Verify that ‘Logged in as username’ is visible
    //9. Click ‘Delete Account’ button
    //10. Verify that ‘ACCOUNT DELETED!’ is visible

    public class AutomationExerciseTest03 {

        // aurora1@gmail.com //123456
        //aurora11@gmail.com //123456
        //aurora111@gmail.com //123456

        @Test
        public void test01(){
            //1. Launch browser
            //2. Navigate to url 'http://automationexercise.com'
            Driver.getDriver().get("http://automationexercise.com");
            //3. Verify that home page is visible successfully
            SoftAssert softAssert=new SoftAssert();
            String expectedUrl="https://automationexercise.com/";
            String actualUrl=Driver.getDriver().getCurrentUrl();
            softAssert.assertEquals(actualUrl,expectedUrl,"homepage'de degilsiniz");
            //4. Click on 'Signup / Login' button
            AutomationExercisePage automationExercisePage=new AutomationExercisePage();
            ReusableMethods.wait(2);
            automationExercisePage.signUpLinki.click();
            //5. Verify 'Login to your account' is visible
            softAssert.assertTrue(automationExercisePage.loginAccountElementi.isDisplayed());
            //6. Enter correct email address and password
            automationExercisePage.emailKutusu.sendKeys("aurora1@gmail.com");
            automationExercisePage.passwordKutusu.sendKeys("123456");
            //7. Click 'login' button
            automationExercisePage.loginButonu.click();
            //8. Verify that 'Logged in as username' is visible
            softAssert.assertTrue(automationExercisePage.loggedinAs.isDisplayed());
            //9. Click 'Delete Account' button
            automationExercisePage.deleteAccountButton.click();
            //10. Verify that 'ACCOUNT DELETED!' is visible
            softAssert.assertTrue(automationExercisePage.accountDeletedlocation.isDisplayed());


            softAssert.assertAll();
            ReusableMethods.wait(5);
            Driver.closeDriver();
        }
    }

}
