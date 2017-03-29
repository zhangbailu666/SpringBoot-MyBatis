package com.qbian.blog.service;

import com.qbian.common.dto.ListNode;
import com.qbian.common.dto.Node;
import com.qbian.blog.entity.Category;
import com.qbian.blog.dao.CategoryDao;
import com.qbian.blog.dto.CategoriesByPageDto;
import com.qbian.blog.dto.CategoryInfoDto;
import com.qbian.common.exception.ServiceException;
import com.qbian.common.util.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Qbian on 2017/3/25.
 */
@Service
public class CategoryService {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    CategoryDao categoryDao;

    /**
     * 保存或更新
     * @param category 待保存或更新的对象
     * @return
     */
    public void save(Category category) {
        if(null == category.getId()) { // 保存
            category.setId(UUID.randomUUID().toString().replaceAll("-",""));
            category.setCreateTime(new Date());
            category.setUpdateTime(new Date());
            category.setDelFlag(Const.UN_DELETE);
            categoryDao.insert(category);
        } else { // 更新
            CategoryInfoDto categoryInfoDto = categoryDao.findInfoByKey(category.getId(), Const.UN_DELETE);
            if(null != categoryInfoDto) {
                categoryDao.updateByKey(category);
            } else {
                throw new ServiceException(new Node(-907));
            }
        }
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return
     */
    public void deleteByKey(String id) {
        CategoryInfoDto categoryInfoDto = categoryDao.findInfoByKey(id, Const.UN_DELETE);
        if(null != categoryInfoDto) {
            Category category = new Category();
            category.setId(categoryInfoDto.getId());
            category.setDelFlag(Const.DELETE);
            categoryDao.updateByKey(category);
        } else {
            throw new ServiceException(new Node(-907));
        }
    }

    /**
     * 查找单个
     * @param id 查找的id
     * @return
     */
    public Node<CategoryInfoDto> getOne(String id) {
        CategoryInfoDto categoryInfoDto = categoryDao.findInfoByKey(id, Const.UN_DELETE);
        if(null != categoryInfoDto) {
            return new Node(categoryInfoDto);
        } else {
            throw new ServiceException(new Node(-907));
        }
    }

    /**
     * 分页查询
     * @param pageNo 查询页码
     * @param pageSize 每页数量
     * @return
     */
    public Node<ListNode> getList(int pageNo, int pageSize) {
        pageNo = pageNo > 1 ? pageNo : 1;
        CategoriesByPageDto categoriesByPageDto = new CategoriesByPageDto(
                (pageNo - 1) * pageSize, pageSize, Const.UN_DELETE);

        ListNode listNode = new ListNode();
        listNode.setTotal(categoryDao.countAllNumb(Const.UN_DELETE));
        listNode.setNodes(categoryDao.findWithPage(categoriesByPageDto));

        return new Node(listNode);
    }
}
