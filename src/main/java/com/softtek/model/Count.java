package com.softtek.model;

public class Count {
	public final static int CANT_PAGE = 10;
	private Long count;
	private Long cantPaginas;
	
	public Count(Long count) {
		this.count = count;
	}
	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	public Long getCantPaginas() {
		return cantPaginas;
	}
	public void setCantPaginas(long l) {
		this.cantPaginas = l;
	}
	
}
