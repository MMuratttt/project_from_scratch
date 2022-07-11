package kuzzat.cydeo.pages;

import kuzzat.cydeo.utilities.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GasMileageCalculatorTest {

    @Test
    public void test() {
        Driver.getDriver().get("https://www.calculator.net ");

        WebElement calcSearch = Driver.getDriver().findElement(By.id("calcSearchTerm"));
        calcSearch.sendKeys("gas");

        Driver.getDriver().findElement(By.xpath("//a[.='Gas Mileage Calculator']")).click();

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Gas Mileage Calculator";
        Assert.assertEquals(expectedTitle,actualTitle);

        String expectedLabel = "gas mileage calculator";
        String actualLabel = Driver.getDriver().findElement(By.xpath("//span[.='gas mileage calculator']")).getText();
        Assert.assertEquals(expectedLabel,actualLabel);

        WebElement currentOdometer = Driver.getDriver().findElement(By.id("mucodreading"));
        WebElement previousOdometer = Driver.getDriver().findElement(By.id("mupodreading"));
        WebElement gasAdded = Driver.getDriver().findElement(By.id("mugasputin"));
        WebElement gasPrice = Driver.getDriver().findElement(By.id("mugasprice"));


        currentOdometer.clear();
        currentOdometer.sendKeys("7925");
        previousOdometer.clear();
        previousOdometer.sendKeys("7550");
        gasAdded.clear();
        gasAdded.sendKeys("16");
        gasPrice.clear();
        gasPrice.sendKeys("3.55");

        Driver.getDriver().findElement(By.xpath("//*[@id=\"metric\"]/tbody/tr[5]/td/input")).click();

        String expectedValue = "23.44";
       String initialValue = Driver.getDriver().findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b"))
               .getText();
       String actualValue = initialValue.substring(0,initialValue.indexOf(" "));

       Assert.assertEquals(expectedValue,actualValue);


    }


}




