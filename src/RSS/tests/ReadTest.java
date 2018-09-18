package RSS.tests;

import RSS.Feed;
import RSS.FeedMessage;
import RSS.RSSFeedParser;

public class ReadTest {
    public static void main(String[] args) {
        RSSFeedParser parser = new RSSFeedParser(
                "https://www.newegg.com/Product/RSS.aspx?Submit=ENE&N=100007709%20601205646&IsNodeId=1&ShowDeactivatedMark=False");
        Feed feed = parser.readFeed();
        System.out.println(feed);
        for(FeedMessage message : feed.getMessages()) {
            System.out.println(message);
        }

    }
}