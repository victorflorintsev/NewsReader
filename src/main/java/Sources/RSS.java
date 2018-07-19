package Sources;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RSS implements Source {
    List<SyndEntry> entryList = new ArrayList<SyndEntry>();
    int i = 0;

    public RSS(String URL) throws Exception {
        SyndFeed feed;
        try {feed = new SyndFeedInput().build(new XmlReader(new URL(URL)));}
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
        List list = feed.getEntries();
        entryList.addAll(list);
    }

    public List<ArticleLink> nextLinks(int size) throws Exception {
        List<ArticleLink> output = new ArrayList<ArticleLink>();
        ArticleLink cur;
        SyndEntry entry;
        for (int j = i; j < size; j++) {
            entry = entryList.get(j);
            cur = new ArticleLink(entry.getTitle(), new URL(entry.getLink()));
            output.add(cur);
            i++;
        }
        return output;
    }

    public boolean hasLinks() {
        return i < entryList.size();
    }
}
