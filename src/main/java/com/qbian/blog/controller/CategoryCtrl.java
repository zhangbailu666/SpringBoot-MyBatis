package com.qbian.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.qbian.blog.service.CategoryService;
import com.qbian.common.util.CheckUtil;
import com.qbian.blog.entity.Category;
import com.qbian.blog.dto.CategoryInfoDto;
import com.qbian.common.dto.ListNode;
import com.qbian.common.dto.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 类别相关操作(curd)
 * Created by Qbian on 2017/3/23.
 */
@RestController
@RequestMapping("/category")
public class CategoryCtrl {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryCtrl.class);

    @Autowired
    CategoryService categoryService;

    /**
     * 添加类别 ========================================== insert
     * @param request HttpServletRequest
     * @return
     */
    @PostMapping
    Node addCategory(HttpServletRequest request) {
        JSONObject params = CheckUtil.checkParamsEmpty(request,
                "token", "name", "introduction", "preview");
        Category category = JSONObject.parseObject(params.toJSONString(), Category.class);
        categoryService.save(category);

        return new Node();
    }

    /**
     * 根据id更新类别 ====================================== update
     * @param id 类别id
     * @param request HttpServletRequest
     * @return
     */
    @PutMapping("/{id}")
    Node updateCategory(@PathVariable("id")String id, HttpServletRequest request) {
        JSONObject params = CheckUtil.checkParamsEmpty(request,
                "token", "name", "introduction", "preview");
        Category category = JSONObject.parseObject(params.toJSONString(), Category.class);
        category.setId(id);
        categoryService.save(category);

        return new Node();
    }

    /**
     * 根据类别 id 删除类别 ==================================== delete
     * @param id 类别id
     * @param request HttpServletRequest
     * @return
     */
    @DeleteMapping("/{id}")
    Node deleteCategory(@PathVariable("id") String id,  HttpServletRequest request) {
        CheckUtil.checkParamsEmpty(request, "token");
        categoryService.deleteByKey(id);

        return new Node();
    }

    /**
     * 获取单个类别详情 ====================================== select one
     * @param id 类别id
     * @return
     */
    @GetMapping("/{id}")
    Node<CategoryInfoDto> getCategory(@PathVariable("id") String id) {

        return categoryService.getOne(id);
    }

    /**
     * 分页获取类别列表 ====================================== select list
     * @param pageNo 页码
     * @param pageSize  每页数量
     * @return
     * TODO 待完成
     */
    @GetMapping
    Node<ListNode> getCategoriesByPage(@RequestParam("pageno") int pageNo
            ,@RequestParam("pagesize")int pageSize) {

        return categoryService.getList(pageNo, pageSize);
    }

}
