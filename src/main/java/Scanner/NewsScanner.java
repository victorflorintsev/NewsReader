package Scanner;

import NewsSources.NewsSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.InputStream;
import java.net.URL;

public class NewsScanner {
    protected WebDriver webDriver;
    protected NewsSource newsSource;

    public NewsScanner(NewsSource nSource, String dataFilepath) throws Exception {
        newsSource = nSource;
        InputStream in = NewsScanner.class.getResourceAsStream(dataFilepath);
        if ( in == null )
            throw new NewsScannerSetupException("Failed to find data CSV");

        webDriver = new ChromeDriver();

        webDriver.navigate().to(new URL(newsSource.getHomePage()));
    }

    private class NewsScannerSetupException extends NewsScannerException {
        public NewsScannerSetupException(String message) {
            super(message);
        }
    }

    private class NewsScannerException extends Exception {
        public NewsScannerException(String message) {
            super(message);
        }
    }
}
