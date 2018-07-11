package Readers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class SeleniumReader extends Reader {
    WebDriver driver;
    WebDriverWait wait;

    By defaultBodyXpath;

    SeleniumReader(URL url) throws Exception {
        super(url);

        driver = new ChromeDriver();
        // toDo: code to instantiate the webdriver needs to be done

        driver.navigate().to(url);
    }

    @Override
    public boolean process() throws Exception {
        WebElement defaultWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(defaultBodyXpath));

        corpus = defaultWebElement.getText();

        doneProcessing = true;
        return true;
    }
}
