package com.campus.myapp.vo;

public class PagingVO {
	private int nowPage = 1; // ���� ������
	private int onePageRecord=10; // ���������� ����� ���ڵ��
	private int totalRecord; // �ѷ��ڵ��
	private int totalPage;// ����������
	private int offsetPoint; // ������ ���ڵ� ������ ��ġ
	
	//������ ��ȣ
	private int startPage = 1;
	private int onePageCount = 5;
	
	//�˻�
	private String searchKey;
	private String searchWord; //boardList�� searchword�� ���ƾ���.
	
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getOnePageCount() {
		return onePageCount;
	}
	public void setOnePageCount(int onePageCount) {
		this.onePageCount = onePageCount;
	}

	
	
	@Override
	public String toString() {
		return "PagingVO [nowPage=" + nowPage + ", onePageRecord=" + onePageRecord + ", totalRecord=" + totalRecord
				+ ", totalPage=" + totalPage + ", offsetPoint=" + offsetPoint + ", startPage=" + startPage
				+ ", onePageCount=" + onePageCount + ", searchKey=" + searchKey + ", searchWord=" + searchWord + "]";
	}
	
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
		//���� ���ڵ� ���� ��ġ
		offsetPoint = (nowPage-1)*onePageRecord;
		//ǥ���� �������� ���۹�ȣ
		startPage = (nowPage-1)/onePageCount*onePageCount+1;
	}
	public int getOnePageRecord() {
		return onePageRecord;
	}
	public void setOnePageRecord(int onePageRecord) {
		this.onePageRecord = onePageRecord;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		//���������� ���ϱ�
		totalPage = totalRecord/onePageRecord;
		if(totalRecord%onePageRecord!=0) {
			totalPage++;
		}
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
		
	}
	public int getOffsetPoint() {
		return offsetPoint;
	}
	public void setOffsetPoint(int offsetPoint) {
		this.offsetPoint = offsetPoint;
	}
	
	//�˻�
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	
	
	
}