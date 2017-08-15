package site.wmblog.service;

import site.wmblog.common.Page;
import site.wmblog.entity.Article;
import site.wmblog.mapper.query.article.ArticleQuery;

/**
 * Created by Administrator on 2017/8/15.
 */
public interface ArticleService {
    Article getById(Long id);

    Page<Article> getPage(ArticleQuery query);
}
