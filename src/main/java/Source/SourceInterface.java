package Source;

import Article.ArticleLink;

import java.util.List;

public interface SourceInterface {
    List<ArticleLink> nextLinks(int size);
}
