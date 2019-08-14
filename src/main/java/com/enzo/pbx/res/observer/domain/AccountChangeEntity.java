package com.enzo.pbx.res.observer.domain;

import org.springframework.lang.Nullable;

import java.util.List;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/14 13:36
 * Company: Zoom
 */
public class AccountChangeEntity {

	private String fromAccountId;

	private String toAccountId;

	@Nullable
	private List<String> extensionIdList;

	public String getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public String getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}

	public List<String> getExtensionIdList() {
		return extensionIdList;
	}

	public void setExtensionIdList(List<String> extensionIdList) {
		this.extensionIdList = extensionIdList;
	}
}
