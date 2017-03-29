package com.qbian.blog.dao;

import com.qbian.blog.dto.ArticlesByPageDto;
import com.qbian.blog.entity.Article;
import com.qbian.blog.dto.ArticleInfoDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Qbian on 2017/3/24.
 */
public interface ArticleDao {
    /**
     * 插入一条记录
     * @param article
     * @return
     */
    int insert(Article article);

    /**
     * 根据key和是否删除查询详细信息
     * @param id 主键
     * @param delFlag 是否删除
     * @return ArticleInfoDto
     */
    ArticleInfoDto findInfoByKey(@Param("id") String id, @Param("delFlag") int delFlag);

    /**
     * 根据key更新一条记录
     * @param article 待更新的对象
     * @return 更新条数
     */
    int updateByKey(Article article);

    /**
     * 根据删除状态查询总数据量
     * @param delFlag 是否删除
     * @param categoryId 类别id
     * @return 数据量
     */
    int countAllNumb(@Param("delFlag") int delFlag, @Param("categoryId") String categoryId);

    /**
     * 分页查询
     * @param articlesByPageDto 分页对象
     * @return List<ArticleInfoDto>
     */
    List<ArticleInfoDto> findWithPage(ArticlesByPageDto articlesByPageDto);


}
