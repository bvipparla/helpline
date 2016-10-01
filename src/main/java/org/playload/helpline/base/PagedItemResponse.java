package org.playload.helpline.base;

import org.springframework.data.domain.Page;

import java.util.List;

public class PagedItemResponse<E extends BaseResponseInfo> extends ListItemResponse<E> {

	private Integer pageNumber;
	private Integer pageSize;
	private Integer totalPages;
	private Long totalItems;

	public PagedItemResponse() {
	}

	public PagedItemResponse(List<E> items) {
		super(items);
	}

	public PagedItemResponse(List<E> items, Integer pageNumber, Integer pageSize, Integer totalPages, Long totalItems) {
		super(items);
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalPages = totalPages;
		this.totalItems = totalItems;
	}

	public PagedItemResponse(Page<E> pageItems) {
		super(pageItems.getContent());

		totalItems = pageItems.getTotalElements();

		// convert to 1-based page number
		pageNumber = pageItems.getNumber() + 1;

		pageSize = pageItems.getSize();
		totalPages = pageItems.getTotalPages();
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Long totalItems) {
		this.totalItems = totalItems;
	}

}
