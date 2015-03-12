package com.jshop.action.backstage.utils;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class PageModel<T>
{
    
    /** 总记录数 **/
    private long totalRecord;
    
    /** 分页数据 **/
    private List<T> list;
    
    /** 当前页 **/
    private int pageNo;
    
    /** 每页大小 **/
    private int pageSize;
    
    /** 首页 **/
    private int topPages;
    
    /** 上一页 **/
    private long previousPageNo;
    
    /** 下一页 **/
    private long nextPageNo;
    
    /** 总页数 **/
    private long totalPage = 1;
    
    /** 页码开始索引和结束索引 **/
    private PageIndex pageIndex;
    
    /** 页码数量 **/
    private int pageCode = 10;
    
    /**
     * 默认构造方法
     */
    public PageModel()
    {
    }
    
    /**
     * 构造方法
     * @param pageNo 当前页
     * @param pageSize 每页大小
     * @param list 结果集
     * @param totalRecord 总记录数
     */
    public PageModel(int pageNo, int pageSize, List<T> list, long totalRecord)
    {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.list = list;
        this.totalRecord = totalRecord;
        this.totalPage = getTotalpage();
        this.pageIndex = PageIndex.getPageIndex(pageCode, pageNo, totalPage);
        nextPageNo = getNextPageNo();
        previousPageNo = getPreviousPageNo();
        topPages = 1;
    }
    
    /**
     * 总页数
     * @return long 总页数
     */
    public long getTotalpage()
    {
        long l = this.totalRecord % this.pageSize == 0 ? this.totalRecord
                / this.pageSize : this.totalRecord / this.pageSize + 1;
        return l;
    }
    
    /**
     * 首页
     * @return int 首页
     */
    public int getTopPages()
    {
        return 1;
    }
    
    /**
     * 尾页
     * @return long 尾页
     */
    public long getBottomPages()
    {
        return getTotalpage() == 0 ? 1 : getTotalpage();
    }
    
    /**
     * 上一页
     * @return long 上一页
     */
    public long getPreviousPageNo()
    {
        if (pageNo <= 1)
        {
            return 1;
        }
        return pageNo - 1;
    }
    
    /**
     * 下一页
     * @return long 下一页
     */
    public long getNextPageNo()
    {
        if (pageNo >= getTotalpage())
        {
            return getTotalpage() == 0 ? 1 : getTotalpage();
        }
        return pageNo + 1;
    }
    
    public long getTotalRecord()
    {
        return totalRecord;
    }
    
    public void setTotalRecord(long totalRecord)
    {
        this.totalRecord = totalRecord;
    }
    
    public List<T> getList()
    {
        return list;
    }
    
    public void setList(List<T> list)
    {
        this.list = list;
    }
    
    public int getPageNo()
    {
        return pageNo;
    }
    
    public void setPageNo(int pageNo)
    {
        this.pageNo = pageNo;
    }
    
    public int getPageSize()
    {
        return pageSize;
    }
    
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }
    
    public PageIndex getPageIndex()
    {
        return pageIndex;
    }
    
    public void setPageIndex(PageIndex pageIndex)
    {
        this.pageIndex = pageIndex;
    }

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
