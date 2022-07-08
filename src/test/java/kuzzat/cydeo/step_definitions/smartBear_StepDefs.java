package kuzzat.cydeo.step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import kuzzat.cydeo.pages.SmartBear;
import kuzzat.cydeo.utilities.ConfigurationReader;
import kuzzat.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class smartBear_StepDefs {

    SmartBear smartBear = new SmartBear();
    Faker faker = new Faker();

    @Given("User is on smartbear link")
    public void user_is_on_smartbear_link() {
        Driver.getDriver().get(ConfigurationReader.getProperty("smartBear.Url"));
    }

    @When("User enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String string, String string2) {
        smartBear.username.sendKeys(string);
        smartBear.password.sendKeys(string2);
    }

    @When("User clicks login button")
    public void user_clicks_login_button() {
        smartBear.loginButton.click();
    }

    @When("User lands on main page")
    public void user_lands_on_main_page() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Web Orders"));
    }

    @Then("User prints each link text on this page and count")
    public void user_prints_each_link_text_on_this_page_and_count() {
        List<WebElement> links = Driver.getDriver().findElements(By.tagName("a"));
        System.out.println(links.size());
        for (WebElement link : links) {
            System.out.println(link.getText());
        }
    }


    @Given("User is on smartBear main page")
    public void user_is_on_smart_bear_main_page() {
        smartBear.loginToSmartBear(ConfigurationReader.getProperty("smartBearUsername"),
                ConfigurationReader.getProperty("smartBearPassword"));
    }

    @Then("User clicks Order")
    public void user_clicks_order() {
        smartBear.order.click();
    }

    @Then("User selects familyAlbum and quantity {int}")
    public void user_selects_family_album_and_quantity(Integer int1) {
        Select select = new Select(smartBear.productDropdown);
        select.selectByVisibleText("FamilyAlbum");
        smartBear.quantity.sendKeys(Keys.BACK_SPACE + "" + int1);

    }

    @Then("User clicks calculate")
    public void user_clicks_calculate() {
        smartBear.calculate.click();
    }

    @Then("User fills the required personal information")
    public void user_fills_the_required_personal_information() {
        smartBear.customerName.sendKeys(faker.name().fullName());
        smartBear.street.sendKeys(faker.address().streetName());
        smartBear.city.sendKeys(faker.address().city());
        smartBear.state.sendKeys(faker.address().state());
        smartBear.zip.sendKeys(faker.number().digits(8));

    }

    @Then("User clicks on visa button")
    public void user_clicks_on_visa_button() {
        smartBear.visa.click();
    }

    @Then("User enters credit card information and clicks process")
    public void user_enters_credit_card_information_and_clicks_process() {
        smartBear.cardNumber.sendKeys(faker.number().digits(16));
        smartBear.expiryDate.sendKeys(faker.number().numberBetween(10, 12) +
                "/" + faker.number().numberBetween(10, 31));
        smartBear.processButton.click();
    }

    @Then("Verify success message")
    public void verify_success_message() {
        String actual = smartBear.successMessage.getText();
        Assert.assertTrue(actual.contains("New order has been successfully added."));
    }


    @When("User clicks view all orders")
    public void user_clicks_view_all_orders() {
        smartBear.viewAllOrders.click();
    }

    @When("User finds {string} s order date as {string}")
    public void user_finds_susan_mc_laren_s_order_date(String name, String date) {
        List<WebElement> names = Driver.getDriver().findElements(By.xpath("//tr//td[2]"));
        int n = 1;
        for (int i = 1; i <= names.size()-1; i++){
            if(names.get(i).getText().contains(name)){
            n = i;
            }
        }
        String actual = Driver.getDriver().findElements(By.xpath("//tr//td[5]")).get(n-1).getText();
        Assert.assertEquals(date,actual);

    }




}
