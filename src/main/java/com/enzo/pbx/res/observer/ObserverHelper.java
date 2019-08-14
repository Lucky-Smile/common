package com.enzo.pbx.res.observer;

import com.enzo.pbx.res.observer.annotation.PbxResourceSubject;
import com.enzo.pbx.res.observer.domain.ExtensionUpdateEntity;
import com.enzo.pbx.res.observer.domain.PbxResourceObserverModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/14 11:27
 * Company: Zoom
 */
@Component
public class ObserverHelper {
	private static final Logger logger = LoggerFactory.getLogger(ObserverHelper.class);

	@PbxResourceSubject(values = {Constants.UPDATE_EXTENSION, Constants.CHANGE_ACCOUNT_ID, Constants.CHANGE_SITE_ID})
	public PbxResourceObserverModel sendAllEvent(String accountId, String extensionId, String extensionNumber){
		logger.info("Send all subject");
		PbxResourceObserverModel pbxResourceObserverModel = new PbxResourceObserverModel();
		pbxResourceObserverModel.setAccountId(accountId);

		List<ExtensionUpdateEntity> extensionUpdateEntityList = new ArrayList<>();
		ExtensionUpdateEntity extensionUpdateEntity = new ExtensionUpdateEntity();
		extensionUpdateEntity.setExtensionId(extensionId);
		extensionUpdateEntity.setExtensionNumber(extensionNumber);
		extensionUpdateEntityList.add(extensionUpdateEntity);
		pbxResourceObserverModel.setExtensionUpdateEntityList(extensionUpdateEntityList);

		return pbxResourceObserverModel;
	}
}
