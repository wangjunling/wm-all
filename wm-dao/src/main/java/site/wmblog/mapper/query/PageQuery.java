package site.wmblog.mapper.query;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by panwang.chengpw on 7/6/15.
 */
public class PageQuery {

    private int  pageNum  = 1;
    private int  pageSize = 10;
    private Sort sort     = new Sort();
    private Date timeStart;
    private Date timeEnd;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        if (pageNum < 1) {
            this.pageNum = 1;
        } else {
            this.pageNum = pageNum;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 100 || pageSize < 1) {
            this.pageSize = 10;
        } else {
            this.pageSize = pageSize;
        }
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }
}
