package Readers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CNNReader extends SeleniumReader {
    List<WebElement> articleLinks;

    public CNNReader(URL url) throws Exception {
        super(url);

        // insert code here bub!
        //find article links
        articleLinks = driver.findElements(By.xpath("//div[@itemprop='articleBody']/section/div[@class = 'l-container']"));

        System.out.println(articleLinks.get(0).getText());
    }
}
