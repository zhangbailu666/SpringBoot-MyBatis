package com.qbian.common.task;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Qbian on 2017/3/23.
 */
@Component
public class MyJobs {

    private static final String BASE_URL = "http://chuansong.me";

    private String csm = "http://chuansong.me/search?q=%E9%83%AD%E9%9C%96";
    private String wx = "http://mp.weixin.qq.com/mp/getmasssendmsg?__biz=MjM5MDMyMzg2MA==#wechat_webview_type=1&wechat_redirect";

    private String wxb = "http://mp.weixin.qq.com/s/ClVo7MBlK5gZoAKgUGRA0g";
//    http://mp.weixin.qq.com/s/ClVo7MBlK5gZoAKgUGRA0g
//    http://mp.weixin.qq.com/s/sHLtKiTkQMfgq0WaO1KAwA
    private static final long Execution_frequency = 6 * 1000;

    @Scheduled(fixedDelay = Execution_frequency)
    void testJobs() {
//        System.out.println("定时任务。。");
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(csm)
//                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
//                    .header("Cookie", "Hm_lvt_a60dba8cb25e746640878eb1b20f67eb=1490664478; Hm_lpvt_a60dba8cb25e746640878eb1b20f67eb=1490665115; __utma=240057436.1532990920.1490664480.1490664480.1490664480.1; __utmb=240057436.5.10.1490664480; __utmc=240057436; __utmz=240057436.1490664480.1.1.utmcsr=baidu|utmccn=(organic)|utmcmd=organic")
//                    .header("Content-Type", "text/html; charset=UTF-8")
//                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
//                    .get();
////            System.out.println(doc);
//            Elements personDivs = doc.getElementsByClass("user");
//
//            for(Element personDiv : personDivs) {
//                String personUrl = personDiv.attr("href");
//                Elements nameDivs = personDiv.getElementsByClass("matched_term");
//                for(Element nameDiv : nameDivs) {
//                    String uname = nameDiv.html();
//                    System.out.println(BASE_URL + personUrl + "============" + uname);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
