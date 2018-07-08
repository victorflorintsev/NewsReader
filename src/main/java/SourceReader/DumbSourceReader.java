package SourceReader;

import Source.SourceInterface;

public class DumbSourceReader extends SourceReader {
    public DumbSourceReader(SourceInterface source, int bufferSize) throws Exception {
        super(source, bufferSize);
        linkReader = new LinkReader();
        linkReader.setWebDriver(LinkReader.driverType.CHROME);
        read();
    }
}
