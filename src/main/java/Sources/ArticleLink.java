package Sources;

import java.net.URL;

public class ArticleLink {

    public ArticleLink(String title, URL url) {
        this.title = title;
        this.link = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String title;

    public URL getLink() {
        return link;
    }

    public void setLink(URL link) {
        this.link = link;
    }

    URL link;

}
