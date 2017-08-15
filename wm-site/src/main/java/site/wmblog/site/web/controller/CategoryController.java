package site.wmblog.site.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import site.wmblog.common.Page;
import site.wmblog.common.result.AjaxResult;
import site.wmblog.entity.Category;
import site.wmblog.mapper.query.PageQuery;
import site.wmblog.service.CategoryService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/8/14.
 */
@Controller
public class CategoryController
{
    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult get(PageQuery pageQuery)
    {
        Page<Category> categoryPage = categoryService.getPage(pageQuery);
        return new AjaxResult(categoryPage);
    }
}
