package com.enzo.pbx.res.observer.domain;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/14 14:08
 * Company: Zoom
 */
public class UserUpdateEntity {

	private String extensionId;

	private int type;

	private int status;

	public String getExtensionId() {
		return extensionId;
	}

	public void setExtensionId(String extensionId) {
		this.extensionId = extensionId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
