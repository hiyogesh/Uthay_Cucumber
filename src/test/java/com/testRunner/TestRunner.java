package com.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		features= {"src/test/java/Feature/"},
		glue= {"com.Page","com.hooks"},
		dryRun=!true,
		snippets=SnippetType.CAMELCASE,
		plugin= {
				"pretty",
				"html:HtmlReport.html"
		},
		tags="@smoke or @sanity"

		
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
