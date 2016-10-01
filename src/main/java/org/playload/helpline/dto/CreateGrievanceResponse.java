package org.playload.helpline.dto;

import org.playload.helpline.base.BaseResponseInfo;

public class CreateGrievanceResponse extends BaseResponseInfo {

	private String gid;

	private String name;

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
