package com.qbian.wechat.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qbian.common.dto.Node;
import com.qbian.common.exception.ServiceException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by Qbian on 2017/3/28.
 */
@RestController
@RequestMapping("/wechat")
public class OffAccCtrl {

    private static final Logger LOG = LoggerFactory.getLogger(OffAccCtrl.class);

    private static final String chuansong_base_url = "http://chuansong.me";

    @GetMapping("/search/{keywords}")
    Node getUserInfo(@PathVariable("keywords")String keywords) {
        String url = chuansong_base_url + "/search?q=" + URLEncoder.encode(keywords);
        LOG.info("请求地址：" + url);
        Document doc = get(url);
        JSONArray users = new JSONArray();
        Elements userDivs = doc.getElementsByClass("user_query_result");

        for(Element userDiv : userDivs) {
            JSONObject user = new JSONObject();

            Elements photoDivs = userDiv.getElementsByClass("photo_col");
            user.put("photo", photoDivs.get(0).getElementsByTag("img").attr("src"));

            Elements hrefDivs = userDiv.getElementsByClass("user");
            String[] accounts = hrefDivs.get(0).attr("href").split("/");
            user.put("account", accounts[accounts.length-1]);
            user.put("title", hrefDivs.get(0).html());

            Elements describeDivs = userDiv.getElementsByClass("search_result_snippet");
            user.put("describe", describeDivs.get(0).getElementsByTag("div").get(0).html());

            users.add(user);
        }

        return new Node(users);
    }

    @GetMapping("/account/{name}/{start}")
    Node articles(@PathVariable("name")String name, @PathVariable("start")int start) {
        // http://chuansong.me/account/guolin_blog?start=0
        String url = chuansong_base_url + "/account/"+URLEncoder.encode(name)+"?start=" + start;
        LOG.info("请求地址：" + url);
        Document doc = get(url);
        JSONObject json = new JSONObject();
        // 查询总条数
        Element element = doc.getElementById("ads_above_pager");
        Element allPageDiv = element.nextElementSibling();
        Elements allPageAs = allPageDiv.getElementsByTag("span").get(0).getElementsByTag("a");
        String allPageHref = allPageAs.get(allPageAs.size() - 1).attr("href");
        String[] strs = allPageHref.split("start=");
        int total = Integer.valueOf(strs[strs.length - 1]);
        json.put("total", total); // 数据总量
        // 查询数据列表
        JSONArray array = new JSONArray();
        Elements elements = doc.getElementsByClass("pagedlist_item");
        for(Element item : elements) {
            JSONObject article = new JSONObject();
            Element titleElm = item.getElementsByClass("question_link").get(0);
            String[] hrefs = titleElm.attr("href").split("/");
            article.put("id", hrefs[hrefs.length - 1]);
            article.put("title", titleElm.html());
            article.put("createTime", item.getElementsByClass("timestamp").get(0).html());
            array.add(article);
        }
        json.put("articles", array);

        return new Node(json);
    }

    @GetMapping("/article/{id}")
    Node articleInfo(@PathVariable("id")String id) {
        // http://chuansong.me/n/355263651523
        String url = chuansong_base_url + "/n/" + id;
        LOG.info("请求地址：" + url);
        Document doc = get(url);
        JSONObject json = new JSONObject();
        json.put("name", doc.getElementById("activity-name").html());
        Element createTimeElm = doc.getElementById("post-date");
        json.put("createTime", createTimeElm.html());
        json.put("nickName", createTimeElm.nextElementSibling().html());
        json.put("author", doc.getElementById("post-user").html());
        json.put("content", doc.getElementById("js_content").html());

        return new Node(json);
    }

    /**
     * 根据url获取document对象
     * @param url 请求地址
     * @return Document
     */
    private Document get(String url) {
        try {
            Document doc = Jsoup.connect(url)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                    .header("Cookie", "Hm_lvt_a60dba8cb25e746640878eb1b20f67eb=1490664478; Hm_lpvt_a60dba8cb25e746640878eb1b20f67eb=1490665115; __utma=240057436.1532990920.1490664480.1490664480.1490664480.1; __utmb=240057436.5.10.1490664480; __utmc=240057436; __utmz=240057436.1490664480.1.1.utmcsr=baidu|utmccn=(organic)|utmcmd=organic")
                    .header("Content-Type", "text/html; charset=UTF-8")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
                    .get();
            return doc;
        } catch (IOException e) {
            throw new ServiceException(new Node(-997));
        }
    }


}