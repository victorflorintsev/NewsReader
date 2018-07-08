package SourceReader;

import Article.ArticleLink;
import Source.SourceInterface;

import java.util.List;

public class SourceReader {

    protected LinkReader linkReader;
    protected SourceInterface source;
    protected int bufferSize;

    SourceReader(SourceInterface source, int bufferSize) {
        this.source = source;
        this.bufferSize = bufferSize;
    }

    public void read() throws Exception {
        if (linkReader == null) throw new LinkReaderNotInitializedException();
        while (source.hasLinks()) {
            List<ArticleLink> list = source.nextLinks(bufferSize);
            for (int i = 0; i < list.size(); i++) {
                linkReader.process(list.get(i));
                wait(10000);
            }
        }
    }

    private class LinkReaderNotInitializedException extends SourceReaderExceptions {
    }

    private class SourceReaderExceptions extends Exception{
    }
}
