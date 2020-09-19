package entity;

import java.util.List;

public class Page {
	private int currPageNo = 1; // ��ǰҳ��
    private int pageSize = 10;    // ҳ���С����ÿҳ��ʾ��¼��
    private int totalCount;          // ��¼����
    private int totalPageCount; // ��ҳ��
    List<Book> bookList;         // ÿҳ��ļ���
	public int getCurrPageNo() {
		return currPageNo;
	}
	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		if(totalCount>0) {
			this.totalCount = totalCount;
			this.totalPageCount=totalCount%pageSize==0?(totalCount/pageSize):(totalCount/pageSize+1);
		}
		
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	@Override
	public String toString() {
		return "Page [currPageNo=" + currPageNo + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalPageCount=" + totalPageCount + ", bookList=" + bookList + "]";
	}
	
}