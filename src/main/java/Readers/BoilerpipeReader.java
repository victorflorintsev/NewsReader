package Readers;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.document.TextDocument;
import de.l3s.boilerpipe.extractors.CommonExtractors;
import de.l3s.boilerpipe.sax.BoilerpipeSAXInput;
import de.l3s.boilerpipe.sax.HTMLDocument;
import de.l3s.boilerpipe.sax.HTMLFetcher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;

import javax.swing.text.AbstractDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.concurrent.Callable;

public class BoilerpipeReader extends Reader implements Callable<String> {
    public BoilerpipeReader(URL url) {
        super(url);
    }

    @Override
    public String call() throws Exception {
        String content = "";

        HTMLDocument htmlDoc = null;
        TextDocument doc = null;
        try {
            htmlDoc = HTMLFetcher.fetch(url);
            doc = new BoilerpipeSAXInput(htmlDoc.toInputSource()).getTextDocument();
            content = CommonExtractors.ARTICLE_EXTRACTOR.getText(doc);

            if (content.equals("")) {

                String content1 = new String(htmlDoc.getData());
                if (content1.contains("http"))
                {
                    int httpIndex = content1.indexOf("http");
                    String url2 = content1.substring(httpIndex,content1.indexOf('"',httpIndex));
                    htmlDoc = HTMLFetcher.fetch(new URL(url2));
                    doc = new BoilerpipeSAXInput(htmlDoc.toInputSource()).getTextDocument();
                    content = CommonExtractors.ARTICLE_EXTRACTOR.getText(doc);
                }
            }

            corpus = content;

        } catch (IOException e) {
            corpus = e.toString();
            e.printStackTrace();
        } catch (BoilerpipeProcessingException e) {
            corpus = e.toString();
            e.printStackTrace();
        } catch (SAXException e) {
            corpus = e.toString();
            e.printStackTrace();
        }

        return corpus;
    }
}
