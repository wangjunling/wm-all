package site.wmblog.mapper;

import site.wmblog.entity.Article;
import site.wmblog.mapper.query.article.ArticleQuery;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article>{

    List<Article> listByCategoryId(ArticleQuery query);

    long countByCategoryId(ArticleQuery query);
}