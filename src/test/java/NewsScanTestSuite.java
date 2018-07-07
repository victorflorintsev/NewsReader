import NewsSources.NewsSource;
import Scanner.NewsScanner;
import Scanner.PageArticleScanner;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewsScanTestSuite {

    @Test
    public void Test1() {
        NewsScanner newsScanner = new PageArticleScanner(new NewsSource(), "data.csv");
    }
}
