import ConcurrentClasses.CorpusTestRunnable;
import Sources.RSS;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ConcurrencyTestSuite {
    String cnnRssUrl = "http://rss.cnn.com/rss/cnn_topstories.rss";
    String defaultCnnNewsStoryUrl = "https://www.cnn.com/2018/07/10/politics/ustr-new-china-tariffs-trump/index.html";

    @Test
    public void sandbox1Thread() throws Exception {
       List<Thread> threads = new ArrayList<Thread>();

       threads.add(new Thread(new CorpusTestRunnable(new RSS(cnnRssUrl))));

       threads.get(0).start();
    }

}
