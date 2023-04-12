package com.shukream.favorites.vo;

public class Pagination {
	
	private int currentPage; //현재 페이지 번호
	private int pageSize; // 한 페이지 당 보여줄 아이템 수
	private int totalCount; // 전체 아이템 수
	private final int BLOCK_SIZE = 8; // 페이지 네이션 블록의 크기
	
	//생성자
	public Pagination(int currentPage, int pageSize, int totalCount) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}

	// get set
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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
		this.totalCount = totalCount;
	}
	
	//전체 페이지수 계산 메소드
	//총 페이지수 반환, 전체 데이터 수를 페이지 크기로 나눈 몫을 구하고 나머지가 있으면 페이지 수를 1 증가 시킴
	public int getTotalPage() {
		int totalPage = totalCount/pageSize;
		if (totalCount % pageSize> 0) {
			totalPage ++;
		}
		return totalPage;
	}
	
	//시작 인덱스 계산
	//현재 페이지에서 보여줄 데이터의 시작 인덱스를 반환 (현재 페이지 -1) * 페이지 크기 + 1을 계산하여 반환 
	//만약 한페이지에 8개씩 보여주는 경우 현재페이지 번호가 2번일때 2-1 => 1 * 8+1 =>9번부터 보여줌
	public int getStartIndex() {
		return (currentPage -1) * pageSize + 1;
	}
	
	//종료인덱스 계산
	//현재 페이지에서 보여줄 데이터의 끝 인덱스를 반환 현재페이지 * 페이지 크기를 계산하여 반환 
	// 현재 페이지가 2페이지면 16번까지 (2*8)
	public int getEndIndex() {
		return currentPage * pageSize;
	}
	
//	//이전 페이지 여부를 반환
//	public boolean hasPrevPage() {
//		return currentPage> 1;
//	}
//	
//	//다음 페이지 여부를 반환
//	public boolean hasNextPage() {
//		return currentPage < getTotalPage();
//	}
	
	//페이지네이션 블록의 시작 페이지 번호를 반환
	// currentPage-1 / block_size 를 계산해서 현재 페이지가 속한 페이지 네이션 블록의 시작 페이지 번호를 계산
	// 현재페이지 (3페이지라고 가정) - 1 => 2 / 3 -> 0.6666...으로 내림(0이됨) 0*3 +1 => 1
	// 현재페이지가 4페이지라 가정하면 -1 => 3 / 3 -> 1 * 3 + 1 => 4
	public int getStartPage() {
	    int startPage = (int) Math.floor((currentPage - 1) / BLOCK_SIZE) * BLOCK_SIZE + 1;
	    return startPage;
	}

	//페이지네이션 블록의 끝 페이지 번호를 반환
	// getStartPage()에서 계산된 (1,4,7 등등) 페이지 번호에 BLOCK_SIZE를 더해서 끝 페이지 번호를 계산
	//예를 들어 현재페이지가 4이고 전체 페이지가 7까지 있다면
	// startPage는 4가됐을것이고 + 8 - 1 을통해 endPage가 32이됨
	//그래서 25 26 27 28 29 30 31 32  으로 페이지 번호가 나타난다
	//만약 현재 페이지번호가 7이고 전체페이지가 8까지 있다면
	// getStartPage()에선 7을 반환했을거고 7 + 3 - 1 => 9인데
	//getTotalPage()는 7이므로 endPage에 7을 저장해서 7까지만 보여줌
	public int getEndPage() {
	    int endPage = getStartPage() + BLOCK_SIZE - 1;
	    if(endPage > getTotalPage()) {
	        endPage = getTotalPage();
	    }
	    return endPage;
	}
	
	//이전 블록이 있는지 확인하는 메소드
	//StartPage()가 BLOCK_SIZE 보다 크다면
	//즉 현재 페이지가 4인 경우 BLOCK_SIZE 3보다 크므로 이전 페이지가 있다 (true) 
	public boolean hasPrevBlock() {
		return getStartPage() > BLOCK_SIZE;
	}
	//다음 블록이 있는지 확인하는 메소드
	//EndPage()가 9이고 TotalPage()가 7인 경우 false를 반환하므로 다음 블록이없다
	public boolean hasNextBlock() {
		return getEndPage() < getTotalPage();
	}
}
