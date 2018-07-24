package Sources;

import com.sun.syndication.feed.synd.SyndEntry;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public interface Source {
    public ArticleLink nextLink() throws Exception;

    public boolean hasLinks();
}
