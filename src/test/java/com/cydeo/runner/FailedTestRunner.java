package com.cydeo.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        // get glue path copy from source, not the content
        glue = "com/cydeo/step_definitions"
)

public class FailedTestRunner {
}
