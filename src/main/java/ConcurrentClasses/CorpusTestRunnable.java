package ConcurrentClasses;

import Sources.Source;

public class CorpusTestRunnable implements Runnable {

    private final Source source;

    public CorpusTestRunnable(Source source) {this.source = source;}

    public void run() {
        while (source.hasLinks()) {
            try {
                System.out.println(source.nextLinks(1)); // I know this isn't thread safe, just testing
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
