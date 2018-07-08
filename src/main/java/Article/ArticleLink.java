package Article;

public class ArticleLink {
    String url;
    String title;

    public ArticleLink(String title, String link) {
        this.title = title;
        this.url = link;
    }

    public String getURL() {
        return url;
    }
}
