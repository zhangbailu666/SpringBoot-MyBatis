package com.qbian.blog.dao;

import com.qbian.blog.entity.Category;
import com.qbian.blog.dto.CategoriesByPageDto;
import com.qbian.blog.dto.CategoryInfoDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Qbian on 2017/3/25.
 */
public interface CategoryDao {

    /**
     * 插入一条记录
     * @param category
     */
    int insert(Category category);

    /**
     * 根据key和是否删除查询详细信息
     * @param id 主键
     * @param delFlag 是否删除
     * @return Category
     */
    CategoryInfoDto findInfoByKey(@Param("id") String id, @Param("delFlag") int delFlag);

    /**
     * 根据key更新一条记录
     * @param category 待更新的对象
     * @return 更新条数
     */
    int updateByKey(Category category);

    /**
     * 根据删除状态查询总数据量
     * @param delFlag 是否删除
     * @return 数据量
     */
    int countAllNumb(@Param("delFlag") int delFlag);

    /**
     * 分页查询
     * @param categoriesByPageDto 分页对象
     * @return List<CategoryInfoDto>
     */
    List<CategoryInfoDto> findWithPage(CategoriesByPageDto categoriesByPageDto);

}
