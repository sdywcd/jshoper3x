package com.jshop.action.backstage.utils;


public class PageIndex
{
    private static final int INDEX_SEARCH = 2;
  
    private long startindex;
    
    
    private long endindex;
    
   
    public PageIndex(long startindex, long endindex)
    {
        this.startindex = startindex;
        this.endindex = endindex;
    }
    
    public long getStartindex()
    {
        return startindex;
    }
    
    public void setStartindex(long startindex)
    {
        this.startindex = startindex;
    }
    
    public long getEndindex()
    {
        return endindex;
    }
    
    public void setEndindex(long endindex)
    {
        this.endindex = endindex;
        
    }
    
    /**
     * 页码算法
     * @param viewpagecount 显示的页码数
     * @param currentPage 当前顿
     * @param totalpage 总页敿
     * @return PageIndex 页码对象
     */
    public static PageIndex getPageIndex(long viewpagecount, int currentPage,
            long totalpage)
    {
        long startpage = currentPage
                - (viewpagecount % INDEX_SEARCH == 0 ? viewpagecount / INDEX_SEARCH
                        - 1 : viewpagecount / INDEX_SEARCH);
        long endpage = currentPage + viewpagecount / INDEX_SEARCH;
        if (startpage < 1)
        {
            startpage = 1;
            if (totalpage >= viewpagecount)
            {
                endpage = viewpagecount;
            }
            else
            {
                endpage = totalpage;
            }
        }
        if (endpage > totalpage)
        {
            endpage = totalpage;
            if ((endpage - viewpagecount) > 0)
            {
                startpage = endpage - viewpagecount + 1;
            }
            else
            {
                startpage = 1;
            }
        }
        return new PageIndex(startpage, endpage);
    }
}
