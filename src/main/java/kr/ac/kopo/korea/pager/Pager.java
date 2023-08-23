package kr.ac.kopo.korea.pager;

import java.util.ArrayList;
import java.util.List;

public class Pager {
	private int page = 1;
	private int perPage = 10;
	private float total;
	private int perGroup = 5;
	
	private int search = 0;
	private String keyword;
	
	public int getOffset() {
		return (page - 1) * perPage;
	}
	
	public String getQuery() {
		String queryString = "";
		
		queryString += "perPage=" + perPage;
		
		if(search > 0)
			queryString += "&search=" + search + "&keyword=" + keyword;
		
		return queryString;
	}
	
	public int getNext() {
		int next = (((page - 1) / perGroup) + 1) * perGroup + 1;
		int last = getLast();
		
		return next < last ? next : last;
	}
	
	public int getPrev() {
		return page <= perGroup ? 1 : (((page - 1) / perGroup) - 1) * perGroup + 1;
	}
	
	public int getLast() {
		return (int) Math.ceil(total / perPage);
	}
	
	public List<Integer> getList() {
		List<Integer> list = new ArrayList<Integer>();
		
		int startPage = (((page - 1) / perGroup)) * perGroup + 1;
		
		for(int index = startPage; index < (startPage + perGroup) && index <= getLast(); index++)
			list.add(index);
		
		if(list.isEmpty())
			list.add(1);
		
		return list;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getPerGroup() {
		return perGroup;
	}

	public void setPerGroup(int perGroup) {
		this.perGroup = perGroup;
	}

	public int getSearch() {
		return search;
	}

	public void setSearch(int search) {
		this.search = search;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
