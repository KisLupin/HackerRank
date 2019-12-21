import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import crawl.ObjectCrawl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) throws IOException {
        String sURL = "https://www.googleapis.com/youtube/v3/commentThreads?part=snippet%2Creplies&allThreadsRelatedToChannelId=UC_x5XG1OV2P6uZZ5FSM9Ttw&key=AIzaSyCBZibQeqvVwkBkfEprmfHBOHNU-4QSn70&fbclid=IwAR3CJb4HApTcqV1BptqDyl48LA0_FTCUtcz0aMq4XogAMCGT-j_jWLmcK_w"; //just a string
        // Connect to the URL using java's native library
        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.connect();
        // Convert to a JSON object to print data
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        Gson gson = new Gson();
        ObjectCrawl objectCrawl = gson.fromJson(root, ObjectCrawl.class);
        System.out.println(objectCrawl);
    }
}
