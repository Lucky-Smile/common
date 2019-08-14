package com.enzo.pbx.res.observer;

import com.enzo.pbx.res.observer.enums.PbxResourceOperationEnum;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/14 15:49
 * Company: Zoom
 */
public class EnumFunctionTest {

	@Test
	public void test(){
		List<String> eventNames = Arrays.asList(new String[]{Constants.CHANGE_SITE_ID, Constants.CHANGE_ACCOUNT_ID});
		PbxResourceOperationEnum.sortProcessingOrder(eventNames);
	}
}
