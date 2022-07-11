package kuzzat.cydeo.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import kuzzat.cydeo.utilities.ConfigurationReader;
import kuzzat.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OpenXcell_StepDefs {

    @Given("User is on openXcell page")
    public void user_is_on_open_xcell_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("openxcell.url"));
    }

    @Then("User counts number of links as {int}")
    public void user_counts_number_of_links_as(Integer int1) {
        int linkCount = Driver.getDriver().findElements(By.partialLinkText("")).size();
        Assert.assertEquals(linkCount+"",int1+"");
    }


    @Then("User prints all link texts")
    public void userPrintsAllLinkTexts() {
        for (WebElement each :
                Driver.getDriver().findElements(By.partialLinkText(""))) {
            System.out.println(each.getText());
        }

    }

    @Then("User finds the difference between the number of links that does not have text")
    public void userFindsTheDifferenceBetweenTheNumberOfLinksThatDoesNotHaveText() {
        int linksWithoutText = Driver.getDriver().findElements(By.linkText("")).size();
        System.out.println(linksWithoutText);


    }
}
