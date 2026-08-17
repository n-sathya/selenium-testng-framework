package com.example.Framework.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
            features = "src/test/resources/features",
            glue = "com.example.Framework.Steps"
)

public class TestRunner extends AbstractTestNGCucumberTests {
}

