import Readers.BoilerpipeReader;
import Sources.ArticleLink;
import Sources.Source;

import java.io.BufferedReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

public class Feeder {
    Source source;

    public Feeder(Source source) {
        this.source = source;
    }

    public String getAllCorpus(int poolSize) {
        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        Queue<Future<String>> futureQueue = new LinkedBlockingQueue<>();

        int linksProcessed = 0;
        while (source.hasLinks()) {
            try {
                ArticleLink articleLink = source.nextLink();

                URL link = articleLink.getLink();

                BoilerpipeReader task = new BoilerpipeReader(link);

                Future<String> submit = executorService.submit(task);

                futureQueue.add(submit);

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Source still has links");
        }
        executorService.shutdown();
        String out = "hi";
        boolean doneRunning = false;
        while (!doneRunning) {
            if (futureQueue.peek().isDone()) {
                try {
                    System.out.println("Adding to out...");
                    out += futureQueue.remove().get();
                    System.out.println("Success, out: " + out);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            if (futureQueue.isEmpty()) doneRunning = true;
            else {
                System.out.println("not done yet");
            }
        }
        System.out.println("Done, out: " + out);

        return out;
    }
}
