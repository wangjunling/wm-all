package site.wmblog.service.impl;

import org.springframework.stereotype.Service;
import site.wmblog.common.Page;
import site.wmblog.entity.Category;
import site.wmblog.mapper.CategoryMapper;
import site.wmblog.mapper.query.PageQuery;
import site.wmblog.service.CategoryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/8/15.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public Page<Category> getPage(PageQuery pageQuery) {
        List<Category> categoryList = categoryMapper.listPage(pageQuery);
        long total = categoryMapper.countAll();
        return new Page<>(total,categoryList);
    }
}
