package com.cydeo.step_definitions;

/*
    In this class we will be able to create "pre" and "post" conditions for ALL the SCENARIOS and even STEPS.
     */

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //import the @Before coming from io.cucumber.java
   // @Before

    public void setupMethod(){
        System.out.println("-----> @Before : RUNNING BEFORE EACH SCENARIO");
    }

    /*
    After will be executed after each scenario in the project.
     */

    @After
    public void teardownMethod(Scenario scenario){

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }


        System.out.println("-----> @After : RUNNING AFTER EACH SCENARIO");
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }

   // @BeforeStep
    public void beforeStepMethod(){
        System.out.println("-----> @BeforeStep : RUNNING BEFORE EACH STEP");
    }

   // @AfterStep
    public void afterStepMethod(){
        System.out.println("-----> @AfterStep : RUNNING AFTER EACH STEP");
    }
}
