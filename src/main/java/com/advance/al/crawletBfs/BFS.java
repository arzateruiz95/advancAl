package com.advance.al.crawletBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BFS {

    private Queue<String> queue;
    private List<String> discoveredWebsiteList;

    private  static final String HTTP_REGEX = "http://(\\w+\\.)*(\\w+)";
    private  static final String WORD_TO_FIND = "oracle";

    public BFS() {
        queue = new LinkedList<>();
        this.discoveredWebsiteList = new ArrayList<>();
    }

    public void discoverWeb(String root) {

        this.queue.add(root);
        this.discoveredWebsiteList.add(root);

        while (!queue.isEmpty()) {

            String v = this.queue.remove();
            String rowHtml = readURL(v);


            Pattern pattern = Pattern.compile(HTTP_REGEX);
            Matcher matcher = pattern.matcher(rowHtml);
            Pattern patternM = Pattern.compile(WORD_TO_FIND);
            Matcher matcherM = patternM.matcher(rowHtml);
            while( matcher.find() ){
                String w = matcher.group();
                if( !discoveredWebsiteList.contains(w) && matcherM.find()){
                    discoveredWebsiteList.add(w);
                    System.err.println("Website found "+ WORD_TO_FIND +" with URL: "+w);
                    queue.add(w);
                }else if (!discoveredWebsiteList.contains(w)) {
                    discoveredWebsiteList.add(w);
                    System.out.println("Website not found "+ WORD_TO_FIND +" with URL: "+w);
                    queue.add(w);
                }
            }
        }
    }

    private String readURL(String v) {

        String rawHtml = "";

        try {
            URL url = new URL(v);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine = "";
            while ((inputLine = in.readLine()) != null) {
                rawHtml += inputLine;
            }

            in.close();
        } catch (Exception e) {
            System.err.println(" No se accedio a :" + v );
        }

        return rawHtml;
    }
}
