package org.playload.helpline.base;

public class SingleItemResponse<E extends BaseResponseInfo> {
	private E item;

	public SingleItemResponse(E item) {
		this.item = item;
	}

	public SingleItemResponse() {
	}

	public E getItem() {
		return item;
	}

	public void setItem(E item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "SingleItemResponse{" + "item=" + item + '}';
	}
}
