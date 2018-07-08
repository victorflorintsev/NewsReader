import Source.RSS;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewsScanTestSuite {

    @Test
    public void Test1() throws Exception {
        new RSS("http://rss.cnn.com/rss/cnn_topstories.rss");
    }
}
