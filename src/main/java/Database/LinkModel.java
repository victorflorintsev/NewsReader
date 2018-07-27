package Database;

/*
Immutable LinkUpdate class
 */

import java.time.Instant;

public final class LinkModel {
    int Data_Source;
    String url;
    String title;
    String author;
    Instant published; // Instant is basically a timestamp
    Instant collected;

    public String getLink() {
        return url;
    }
}
