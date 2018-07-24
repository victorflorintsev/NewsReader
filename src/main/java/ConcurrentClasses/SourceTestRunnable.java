package ConcurrentClasses;

import Sources.Source;

public class SourceTestRunnable implements Runnable {

    private final Source source;

    public SourceTestRunnable(Source source) {this.source = source;}

    public void run() {
        while (source.hasLinks()) {
            try {
                System.out.println(source.nextLink()); // I know this isn't thread safe, just testing
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
