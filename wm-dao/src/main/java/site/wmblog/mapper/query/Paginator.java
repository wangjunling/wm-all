package site.wmblog.mapper.query;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Collections;
import java.util.List;

/**
 * Created by panwang.chengpw on 1/22/15.
 */
public class Paginator<T> {

    /**
     * 当前页，从1开始
     */
    private int pageNum;

    /**
     * 每页大小
     */
    private int pageSize;

    /**
     * results
     */
    private List<T> data;

    private int totalCount;

    @SuppressWarnings({ "rawtypes", "unchecked" }) private final static Paginator EMPTY = new Paginator(0, 0, Collections.emptyList());

    @SuppressWarnings("unchecked") public static <T> Paginator<T> emptyPaginator() {
        return EMPTY;
    }

    public final static int TotalCountNotSupported = -1;

    public Paginator(int pageSize, int pageNum, List<T> data) {
        this.setPageSize(pageSize);
        this.setPageNum(pageNum);
        this.setData(data);
        this.setTotalCount(TotalCountNotSupported);
    }

    public Paginator(PageQuery pageQuery, List<T> data, Integer totalCount) {
        this(pageQuery.getPageSize(), pageQuery.getPageNum(), data, totalCount);
    }

    public Paginator(int pageSize, int pageNum, List<T> data, Integer totalCount) {
        this.setPageSize(pageSize);
        this.setPageNum(pageNum);
        this.setData(data);
        if (totalCount == null) {
            totalCount = 0;
        }
        this.setTotalCount(totalCount);
      
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }


    public int getPageNum() {
        return pageNum;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 总共多少页
     *
     * @return
     */
    public int getTotalPage() {
        int totalCount = this.getTotalCount();
        if (totalCount != TotalCountNotSupported) {
            int page = totalCount / this.getPageSize();
            page += totalCount - this.getPageSize() * page > 0 ? 1 : 0;
            return page;
        } else {
            return TotalCountNotSupported;
        }

    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
