package com.spartaglobal.finalweek.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        plugin = {
                "pretty", "html:target/testReports.html",
                "json:target/jsonReport/json"
        },
        tags = "not @ignore"
)
public class TestRunner {
}
