package Sources;

import com.sun.syndication.feed.synd.SyndEntry;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public interface Source {
    public List<ArticleLink> nextLinks(int size) throws Exception;

    public boolean hasLinks();
}
