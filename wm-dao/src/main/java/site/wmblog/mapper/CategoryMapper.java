package site.wmblog.mapper;

import site.wmblog.entity.Category;
import site.wmblog.mapper.query.PageQuery;

import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {

    List<Category> listPage(PageQuery pageQuery);

    long countAll();
}