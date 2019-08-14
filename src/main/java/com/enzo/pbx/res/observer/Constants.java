package com.enzo.pbx.res.observer;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/14 11:10
 * Company: Zoom
 */
public class Constants {

	/** Pbx resource operation name */
	public static final String CHANGE_ACCOUNT_ID = "changeAccountId";
	public static final String CHANGE_SITE_ID = "changeSiteId";
	public static final String UPDATE_EXTENSION = "updateExtension";
	public static final String UPDATE_PBX_USER = "updatePbxUser";

	public static final int ACCOUNT_PRIORITY = 0x1;
	public static final int SITE_PRIORITY = 0x10;
	public static final int USER_PRIORITY = 0x100;
	public static final int EXTENSION_PRIORITY = 0x1000;
	/** end */
}
