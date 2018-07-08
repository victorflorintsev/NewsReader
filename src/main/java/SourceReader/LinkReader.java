package SourceReader;

import Article.ArticleLink;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URL;
import java.sql.Driver;

public class LinkReader {
    WebDriver driver;

    public void process(ArticleLink articleLink) throws Exception {
        driver.navigate().to(new URL(articleLink.getURL()));
    }

    public void setWebDriver(driverType type) {
        switch (type){
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
        }
    }

    enum driverType {CHROME, FIREFOX}
}
