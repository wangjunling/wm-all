package site.wmblog.site.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import site.wmblog.common.Page;
import site.wmblog.common.result.AjaxResult;
import site.wmblog.entity.Article;
import site.wmblog.mapper.query.PageQuery;
import site.wmblog.mapper.query.article.ArticleQuery;
import site.wmblog.service.ArticleService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/8/14.
 */
@Controller
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @RequestMapping(value = "/articles/{id}", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult get(@PathVariable Long id)
    {
        Article article = articleService.getById(id);
        return new AjaxResult(article);
    }


    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult get(ArticleQuery query)
    {
        Page<Article> page = articleService.getPage(query);
        return new AjaxResult(page);
    }
}
