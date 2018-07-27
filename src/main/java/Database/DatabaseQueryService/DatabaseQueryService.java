package Database.DatabaseQueryService;

import Database.LinkModel;

import java.util.Queue;

public class DatabaseQueryService {
    private static DatabaseQueryService ourInstance = null;
    public static DatabaseQueryService getInstance() {
        if (ourInstance == null) {
            ourInstance = new DatabaseQueryService();
        }
        return ourInstance;
    }

    public DatabaseQueryService() {

    }

    public Queue<LinkModel> getNextLinks(int batchSize) {
        return null;
    }
}
