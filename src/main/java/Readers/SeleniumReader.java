package Readers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public class SeleniumReader extends Reader {
    WebDriver driver;

    SeleniumReader(URL url) {
        super(url);

        driver = new ChromeDriver();
    }

}
