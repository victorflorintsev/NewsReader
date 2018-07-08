import Source.RSS;
import Source.SourceInterface;
import SourceReader.*;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewsScanTestSuite {

    @Test
    public void Test1() throws Exception {
        RSS cnn = new RSS("http://rss.cnn.com/rss/cnn_topstories.rss");
        SourceReader sourceReader = new DumbSourceReader(cnn, 10);
    }
}
