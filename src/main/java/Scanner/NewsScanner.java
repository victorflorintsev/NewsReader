package Scanner;

import NewsSources.NewsSource;

import java.io.InputStream;

public class NewsScanner {
    public NewsScanner(NewsSource newsSource, String dataFilepath) throws Exception {
        InputStream in = NewsScanner.class.getResourceAsStream(dataFilepath);
        if ( in == null )
            throw new NewsScannerSetupException("Failed to find data CSV");
    }

    private class NewsScannerSetupException extends NewsScannerException {
        public NewsScannerSetupException(String message) {
            super(message);
        }
    }

    private class NewsScannerException extends Exception {
        public NewsScannerException(String message) {
            super(message);
        }
    }
}
