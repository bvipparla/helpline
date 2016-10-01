package org.playload.helpline.base;

import java.util.List;

public class ListItemResponse<E extends BaseResponseInfo> {

	private List<E> items;

	public ListItemResponse(List<E> items) {
		this.items = items;
	}

	public ListItemResponse() {
	}

	public List<E> getItems() {
		return items;
	}

	public void setItems(List<E> items) {
		this.items = items;
	}
}
