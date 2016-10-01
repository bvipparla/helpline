package org.playload.helpline.dto;

import javax.validation.constraints.Size;

public class CreateGrievanceRequest {

	@Size(min = 0, max = 20, message = "Grievance Id")
	private String gid;

	@Size(min = 0, max = 20, message = "Grievance Name")
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
