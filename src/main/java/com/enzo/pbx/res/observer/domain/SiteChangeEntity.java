package com.enzo.pbx.res.observer.domain;

import java.util.List;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/14 14:17
 * Company: Zoom
 */
public class SiteChangeEntity {

	private String siteId;

	private List<String> extensionIdList;

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public List<String> getExtensionIdList() {
		return extensionIdList;
	}

	public void setExtensionIdList(List<String> extensionIdList) {
		this.extensionIdList = extensionIdList;
	}
}
