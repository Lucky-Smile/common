package com.enzo.pbx.res.observer.domain;

import java.util.List;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/14 13:33
 * Company: Zoom
 */
public class PbxResourceObserverModel {

	private String accountId;

	private AccountChangeEntity accountIdChangeEntity;

	private SiteChangeEntity siteChangeEntity;

	private List<ExtensionUpdateEntity> extensionUpdateEntityList;

	private List<UserUpdateEntity> userUpdateEntityList;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public AccountChangeEntity getAccountIdChangeEntity() {
		return accountIdChangeEntity;
	}

	public void setAccountIdChangeEntity(AccountChangeEntity accountIdChangeEntity) {
		this.accountIdChangeEntity = accountIdChangeEntity;
	}

	public SiteChangeEntity getSiteChangeEntity() {
		return siteChangeEntity;
	}

	public void setSiteChangeEntity(SiteChangeEntity siteChangeEntity) {
		this.siteChangeEntity = siteChangeEntity;
	}

	public List<ExtensionUpdateEntity> getExtensionUpdateEntityList() {
		return extensionUpdateEntityList;
	}

	public void setExtensionUpdateEntityList(List<ExtensionUpdateEntity> extensionUpdateEntityList) {
		this.extensionUpdateEntityList = extensionUpdateEntityList;
	}

	public List<UserUpdateEntity> getUserUpdateEntityList() {
		return userUpdateEntityList;
	}

	public void setUserUpdateEntityList(List<UserUpdateEntity> userUpdateEntityList) {
		this.userUpdateEntityList = userUpdateEntityList;
	}

}
