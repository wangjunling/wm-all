package site.wmblog.mapper.query.article;

import site.wmblog.mapper.query.PageQuery;

/**
 * Created by Administrator on 2017/8/15.
 */
public class ArticleQuery extends PageQuery
{
    private Long categoryId;

    public Long getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }
}
