package site.wmblog.service;

import site.wmblog.common.Page;
import site.wmblog.entity.Category;
import site.wmblog.mapper.query.PageQuery;

/**
 * Created by Administrator on 2017/8/15.
 */
public interface CategoryService {
    Page<Category> getPage(PageQuery pageQuery);
}
