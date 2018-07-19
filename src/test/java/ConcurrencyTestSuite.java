import ConcurrentClasses.SourceTestRunnable;
import Sources.RSS;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ConcurrencyTestSuite {
    String cnnRssUrl = "http://rss.cnn.com/rss/cnn_topstories.rss";
    String apTopScienceNewsRssUrl = "http://hosted.ap.org/lineups/SCIENCEHEADS-rss_2.0.xml?SITE=OHLIM&SECTION=HOME";
    String bbcRssUrl = "http://www.bbc.co.uk/news/10628494";
    String fnRssUrl = "http://www.ft.com/rss";
    String natureRssUrl = "http://feeds.nature.com/nature/rss/current";

    String defaultCnnNewsStoryUrl = "https://www.cnn.com/2018/07/10/politics/ustr-new-china-tariffs-trump/index.html";

    @Test
    public void oneSourceTestRunnable() throws Exception {
       List<Thread> threads = new ArrayList<Thread>();

       threads.add(new Thread(new SourceTestRunnable(new RSS(cnnRssUrl))));

       threads.get(0).start();
    }

    @Test
    public void fiveSourceTestRunnables() throws Exception {
        List<Thread> threads = new ArrayList<Thread>();

        threads.add(new Thread(new SourceTestRunnable(new RSS(cnnRssUrl))));
        threads.add(new Thread(new SourceTestRunnable(new RSS(apTopScienceNewsRssUrl))));
        threads.add(new Thread(new SourceTestRunnable(new RSS(bbcRssUrl))));
        threads.add(new Thread(new SourceTestRunnable(new RSS(fnRssUrl))));
        threads.add(new Thread(new SourceTestRunnable(new RSS(natureRssUrl))));


        for (Thread thread : threads) {
            thread.start();
        }
    }

}
