import Readers.BoilerpipeReader;
import Readers.CNNReader;
import Readers.Reader;
import Sources.ArticleLink;
import Sources.RSS;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

public class NewsScanTestSuite {
    String cnnRssUrl = "http://rss.cnn.com/rss/cnn_topstories.rss";
    String defaultCnnNewsStoryUrl = "https://www.cnn.com/2018/07/10/politics/ustr-new-china-tariffs-trump/index.html";

    @Test
    public void routeRssToBoilerpipeReaders() throws Exception {
        int sizeToTest = 10;
        RSS cnn = new RSS(cnnRssUrl);

        List<ArticleLink> articleLinkList = cnn.nextLinks(sizeToTest);

        String totalCorpus = "";
        for (ArticleLink articleLink : articleLinkList) {
            System.out.println("Opening ArticleLink: " + articleLink); // toDo: implement new logger
            Reader reader = new BoilerpipeReader(articleLink.getLink()); // fails because the xpath handling of CNNReader is super primitive. Need to add exception handling to it another day.
            totalCorpus += reader.getCorpus();
        }
        System.out.println(totalCorpus);
        assert !totalCorpus.equals("");
    }

    @Test
    public void routeRssToCnnReaders() throws Exception {
        int sizeToTest = 10;
        RSS cnn = new RSS(cnnRssUrl);

        List<ArticleLink> articleLinkList = cnn.nextLinks(sizeToTest);

        String totalCorpus = "";
        for (ArticleLink articleLink : articleLinkList) {
            System.out.println("Opening ArticleLink: " + articleLink); // toDo: implement new logger
            Reader reader = new CNNReader(articleLink.getLink()); // fails because the xpath handling of CNNReader is super primitive. Need to add exception handling to it another day.
            totalCorpus += reader.getCorpus();
        }
        System.out.println(totalCorpus);
        assert !totalCorpus.equals("");
    }

    @Test
    public void testCNNReader() throws Exception {
        Reader reader = new CNNReader(new URL(defaultCnnNewsStoryUrl));
    }

    @Test
    public void rssHasLinks() throws Exception {
        RSS cnn = new RSS(cnnRssUrl);

        assert cnn.hasLinks() : "CNN RSS has no links";
    }

    @Test
    public void rssReturnsList() throws Exception {
        RSS cnn = new RSS(cnnRssUrl);

        List<ArticleLink> articleLinkList = cnn.nextLinks(10);

        assert !articleLinkList.isEmpty() : "ArticleLink list is empty";
    }

    @Test (dependsOnMethods = "rssReturnsList")
    public void rssReturnsCorrectLengthList() throws Exception {
        int sizeToTest = 10;
        RSS cnn = new RSS(cnnRssUrl);

        List<ArticleLink> articleLinkList = cnn.nextLinks(sizeToTest);

        assert articleLinkList.size() == sizeToTest;
        }

}
