package RSS.tests;

import RSS.Feed;
import RSS.FeedMessage;
import RSS.RSSFeedParser;
import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;

public class GPUSniper {
    public TrayIcon displayTray() throws AWTException, MalformedURLException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "GPU Sniper");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        tray.add(trayIcon);
        return trayIcon;
    }

    public void displayNotif(TrayIcon trayIcon,FeedMessage message){
        trayIcon.displayMessage( "$"+Double.toString(message.getPrice()), message.getTitle(), MessageType.INFO);
    }
    public static void main(String[] args) throws InterruptedException, MalformedURLException, AWTException {
        GPUSniper td = new GPUSniper();
        TrayIcon tray = td.displayTray();
        while(true) {
            // creating feed for 1060 on newegg
            RSSFeedParser parser1060 = new RSSFeedParser(
                    "https://www.newegg.com/Product/RSS.aspx?Submit=ENE&N=100007709%20601205646&IsNodeId=1&ShowDeactivatedMark=False");
            Feed feed1060 = parser1060.readFeed();

            if (feed1060 != null) {
                System.out.println("scanned 1060");
                for (FeedMessage message : feed1060.getMessages(150)) {
                    td.displayNotif(tray,message);
                    System.out.println(message.toString());
                }
            }
            else{
                System.out.println("failed 1060");
            }
            Thread.sleep(60000);
            // creating feed for 1070 on newegg
            RSSFeedParser parser1070 = new RSSFeedParser(
                    "https://www.newegg.com/Product/RSS.aspx?Submit=ENE&N=100007709%20601201888&IsNodeId=1&ShowDeactivatedMark=False");
            Feed feed1070 = parser1070.readFeed();

            if (feed1070 != null) {
                System.out.println("scanned 1070");
                for (FeedMessage message : feed1070.getMessages(300)) {
                    td.displayNotif(tray,message);
                    System.out.println(message.toString());
                }
            }
            else{
                System.out.println("failed 1070");
            }
            Thread.sleep(60000);
            // creating feed for 1080 on newegg
            RSSFeedParser parser1080 = new RSSFeedParser(
                    "https://www.newegg.com/Product/RSS.aspx?Submit=ENE&N=100007709%20601201888&IsNodeId=1&ShowDeactivatedMark=False");
            Feed feed1080 = parser1080.readFeed();
            if (feed1080 != null) {
                System.out.println("scanned 1080");
                for (FeedMessage message : feed1080.getMessages(400)) {
                    td.displayNotif(tray,message);
                    System.out.println(message.toString());
                }
            }
            else {
                System.out.println("failed 1080");
            }
            Thread.sleep(60000);
        }
    }
}
