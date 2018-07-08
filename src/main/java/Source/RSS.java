package Source;

import Article.ArticleLink;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RSS implements SourceInterface {
    List<SyndEntry> entryList = new ArrayList<SyndEntry>();
    int i = 0;

    public RSS(String URL) throws Exception {
        SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(URL)));
        List list = feed.getEntries();
        entryList.addAll(list);
    }

    public List<ArticleLink> nextLinks(int size) {
        List<ArticleLink> output = new ArrayList<ArticleLink>();
        ArticleLink cur;
        SyndEntry entry;
        for (int j = i; j < size; j++) {
            entry = entryList.get(j);
            cur = new ArticleLink(entry.getTitle(), entry.getLink());
            i++;
        }
        return output;
    }
}
