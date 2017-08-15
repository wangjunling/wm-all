package site.wmblog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import site.wmblog.common.Page;
import site.wmblog.entity.Article;
import site.wmblog.mapper.ArticleMapper;
import site.wmblog.mapper.query.article.ArticleQuery;
import site.wmblog.service.ArticleService;

/**
 * Created by Administrator on 2017/8/15.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Override
    public Article getById(Long id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<Article> getPage(ArticleQuery query)
    {
        List<Article> articleList = articleMapper.listByCategoryId(query);
        long total = articleMapper.countByCategoryId(query);
        return new Page<>(total, articleList);
    }
}
