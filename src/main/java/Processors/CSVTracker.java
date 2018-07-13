package Processors;

import java.io.File;

public class CSVTracker {

    File file;

    public CSVTracker(String filepath) {
        file = new File(filepath);
    }
}
