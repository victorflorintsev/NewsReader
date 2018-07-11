package Readers;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.net.URL;

public class Reader {

    protected URL url;
    protected String corpus; // the output string of the reader
    protected boolean doneProcessing = false;

    public Reader(URL url) {
        this.url = url;
    }

    public boolean process() throws Exception {
        throw new NotImplementedException();
        // toDo: implement
    }

    public boolean isDoneProcessing() {
        return doneProcessing;
    }

    public String getCorpus() {
        return corpus;
    }
}
