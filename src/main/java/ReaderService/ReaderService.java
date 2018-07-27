package ReaderService;

import Database.DatabaseQueryService.DatabaseQueryService;
import Database.LinkModel;
import Readers.BoilerpipeReader;
import Sources.ArticleLink;

import java.net.URL;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReaderService implements Runnable {
    ExecutorService executorService;
    Queue<LinkModel> linkModelQueue;
    Queue<Future<String>> futureQueue;
    int batchSize;
    int poolSize;

    public ReaderService(int poolSize, int batchSize) {
        executorService = Executors.newFixedThreadPool(poolSize);
        futureQueue = new ArrayBlockingQueue<>(poolSize*2, true);
        this.batchSize = batchSize;
        this.poolSize = poolSize;
    }

    @Override
    public void run() {
        for (;;) {
            linkModelQueue = DatabaseQueryService.getInstance().getNextLinks(batchSize);
            for (LinkModel link : linkModelQueue) {
                try {
                    BoilerpipeReader task = new BoilerpipeReader(new URL(link.getLink()));

                    Future<String> submit = executorService.submit(task);

                    futureQueue.add(submit);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}
