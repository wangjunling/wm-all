package site.wmblog.common;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Fe on 15/1/23.
 */
public class Page<T> {

    /**
     * 总记录数
     */
    private long    total    = 0;
    /**
     * 每页结果集合
     */
    private List<T> data;
    /**
     * 页数
     */
    private int     pageNum  = 1;
    /**
     * 每页大小, 最大为100
     */
    private int     pageSize = 10;

    public Page() {
    }



    public Page(long total, List<T> orderList) {
        setTotal(total);
        setData(orderList);
    }

    public Page(long total, List<T> orderList, int pageNum, int pageSize) {
        setTotal(total);
        setData(orderList);
        setPageNum(pageNum);
        setPageSize(pageSize);
    }

    /**
     * 总共多少页
     *
     * @return
     */
    public long getTotalPage() {
        long page = (total / pageSize);
        page += total - pageSize * page > 0 ? 1 : 0;
        return page;

    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        if (pageNum < 1) {
            pageNum = 1;
        }
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 100 || pageSize < 1) {
            pageSize = 10;
        }
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * oracle获得起始行
     * @return
     */
    public int getStart() {
        return pageNum * pageSize - pageSize;
    }

    /**
     * oracle获得结行
     * @return
     */
    public int getEnd() {
        return pageNum * pageSize;
    }

}
