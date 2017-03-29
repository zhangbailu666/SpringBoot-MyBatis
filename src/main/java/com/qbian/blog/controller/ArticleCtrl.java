package com.qbian.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.qbian.blog.service.ArticleService;
import com.qbian.common.util.CheckUtil;
import com.qbian.blog.entity.Article;
import com.qbian.blog.dto.ArticleInfoDto;
import com.qbian.common.dto.ListNode;
import com.qbian.common.dto.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Qbian on 2017/3/24.
 */
@RestController
@RequestMapping("/article")
public class ArticleCtrl {

    private static final Logger LOG = LoggerFactory.getLogger(ArticleCtrl.class);

    @Autowired
    ArticleService articleService;

    /**
     * 添加文章 ============================================== insert one
     * @param request HttpServletRequest
     * @return
     */
    @PostMapping
    Node addArticle(HttpServletRequest request) {
        JSONObject params = CheckUtil.checkParamsEmpty(request,
                "token", "categoryId", "name", "preview", "content");
        Article article = JSONObject.parseObject(params.toJSONString(), Article.class);
        articleService.save(article);

        return new Node();
    }

    /**
     * 根据id更新文章 ====================================== update one
     * @param id 文章id
     * @param request HttpServletRequest
     * @return
     */
    @PutMapping("/{id}")
    Node updateArticle(@PathVariable("id")String id, HttpServletRequest request) {
        JSONObject params = CheckUtil.checkParamsEmpty(request,
                "token", "categoryId", "name", "preview", "content");
        Article article = JSONObject.parseObject(params.toJSONString(), Article.class);
        articleService.save(article);

        return new Node();
    }

    /**
     * 根据id删除文章 ====================================== delete one
     * @param id 文章id
     * @param request HttpServletRequest
     * @return
     */
    @DeleteMapping("/{id}")
    Node delArticle(@PathVariable("id") String id,  HttpServletRequest request) {
        JSONObject params = CheckUtil.checkParamsEmpty(request, "token");
        articleService.deleteByKey(id);

        return new Node();
    }

    /**
     * 根据id查询单个文章详情 ====================================== select one
     * @param id 文章id
     * @return
     */
    @GetMapping("/{id}")
    Node<ArticleInfoDto> getArticle(@PathVariable("id") String id) {

        return articleService.getOne(id);
    }

    /**
     * 分页获取文章列表 ====================================== select list
     * @param pageNo 页码
     * @param pageSize 单页请求数量
     * @return
     */
    @GetMapping
    Node<ListNode> getArticlesByPage(@RequestParam("pageno") int pageNo
            ,@RequestParam("pagesize")int pageSize
            ,@RequestParam(value = "categoryid", defaultValue = "all") String categoryId) {

        return articleService.getList(pageNo, pageSize, categoryId);
    }


}
