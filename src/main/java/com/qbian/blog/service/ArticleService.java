package com.qbian.blog.service;

import com.qbian.common.dto.ListNode;
import com.qbian.common.dto.Node;
import com.qbian.blog.dto.ArticlesByPageDto;
import com.qbian.blog.entity.Article;
import com.qbian.blog.dao.ArticleDao;
import com.qbian.blog.dao.CategoryDao;
import com.qbian.blog.dto.ArticleInfoDto;
import com.qbian.common.exception.ServiceException;
import com.qbian.common.util.Const;
import com.qbian.common.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Qbian on 2017/3/27.
 */
@Service
public class ArticleService {

    private static final Logger LOG = LoggerFactory.getLogger(ArticleService.class);

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    ArticleDao articleDao;

    /**
     * 保存或更新
     * @param article
     */
    public void save(Article article) {
        // 保存
        if(null == article.getId()
                && null != categoryDao.findInfoByKey(article.getCategoryId(), Const.UN_DELETE)) {

            article.setId(StringUtil.getUUIDString());
            article.setCreateTime(new Date());
            article.setUpdateTime(new Date());
            article.setDelFlag(Const.UN_DELETE);
            articleDao.insert(article);
        }
        // 更新
        else if(null != article.getId()
                && null != articleDao.findInfoByKey(article.getId(), Const.UN_DELETE)) {

            articleDao.updateByKey(article);
        }
        // 操作数据不存在
        else {
            throw new ServiceException(new Node(-907));
        }
    }

    /**
     * 根据 key 删除一条记录
     * @param id key
     */
    public void deleteByKey(String id) {
        ArticleInfoDto articleInfoDto = articleDao.findInfoByKey(id, Const.UN_DELETE);
        if(null != articleInfoDto) {
            Article article = new Article();
            article.setId(articleInfoDto.getId());
            article.setDelFlag(Const.DELETE);
            articleDao.updateByKey(article);
        } else {
            throw new ServiceException(new Node(-907));
        }
    }

    /**
     * 根据key获取详细信息
     * @param id key
     * @return  ArticleInfoDto
     */
    public Node<ArticleInfoDto> getOne(String id) {
        ArticleInfoDto articleInfoDto = articleDao.findInfoByKey(id, Const.UN_DELETE);
        if(null != articleInfoDto) {
            // 更新查看次数
            Article article = new Article();
            article.setId(articleInfoDto.getId());
            article.setViewNum(articleInfoDto.getViewNum() + 1);

            articleDao.updateByKey(article);

            Node<ArticleInfoDto> node = new Node();
            node.setResult(articleInfoDto);

            return node;
        }
        throw new ServiceException(new Node(-907));
    }

    /**
     * 分页获取列表
     * @param pageNo 页码
     * @param pageSize 单页数量
     * @param categoryId 类别id
     * @return
     */
    public Node<ListNode> getList(int pageNo, int pageSize, String categoryId) {
        pageNo = pageNo > 1 ? pageNo : 1;
        categoryId = "all".equals(categoryId) ? null : categoryId;
        ArticlesByPageDto articlesByPageDto = new ArticlesByPageDto(
                (pageNo - 1) * pageSize, pageSize, Const.UN_DELETE, categoryId);

        ListNode listNode = new ListNode();
        listNode.setTotal(articleDao.countAllNumb(Const.UN_DELETE, categoryId));
        listNode.setNodes(articleDao.findWithPage(articlesByPageDto));

        return new Node(listNode);
    }
}
