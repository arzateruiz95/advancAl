package com.advance.app;

import com.advance.al.crawletBfs.BFS;

public class CrawletBfsMain {


    public static void main(String[] args) {

        BFS bfs = new BFS();
        bfs.discoverWeb("https://www.theguardian.com/us-news/live/2019/jun/21/trump-iran-news-us-latest-tehran-strike-washington-2020");

    }
}
