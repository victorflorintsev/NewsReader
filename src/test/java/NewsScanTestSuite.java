import Readers.CNNReader;
import Readers.Reader;
import Sources.ArticleLink;
import Sources.RSS;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

public class NewsScanTestSuite {

    @Test
    public void testRSS() throws Exception {
        RSS cnn = new RSS("http://rss.cnn.com/rss/cnn_topstories.rss");
    }

    @Test
    public void testCNNReader() throws Exception {
        Reader reader = new CNNReader(new URL("https://www.cnn.com/2018/07/10/politics/ustr-new-china-tariffs-trump/index.html"));
    }
}
