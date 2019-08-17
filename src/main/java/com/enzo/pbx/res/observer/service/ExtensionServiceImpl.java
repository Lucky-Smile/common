package com.enzo.pbx.res.observer.service;

import com.enzo.pbx.res.observer.Constants;
import com.enzo.pbx.res.observer.annotation.PbxResourceObserver;
import com.enzo.pbx.res.observer.domain.ExtensionUpdateEntity;
import com.enzo.pbx.res.observer.domain.PbxResourceObserverModel;
import com.enzo.pbx.res.observer.mapper.ExtensionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/14 10:56
 * Company: Zoom
 */
@Service
public class ExtensionServiceImpl implements ExtensionService {

	private static final Logger logger = LoggerFactory.getLogger(ExtensionServiceImpl.class);

	@Autowired
	private ExtensionMapper extensionMapper;

	@Override
	@PbxResourceObserver(Constants.UPDATE_EXTENSION)
	public void updateExtensionNumber(PbxResourceObserverModel pbxResourceObserverModel) {
		logger.info("Receive update extension number notification: {}", pbxResourceObserverModel);

		if (ObjectUtils.isEmpty(pbxResourceObserverModel) || CollectionUtils.isEmpty(pbxResourceObserverModel.getExtensionUpdateEntityList())){
			return;
		}

		List<ExtensionUpdateEntity> extensionUpdateEntityList = pbxResourceObserverModel.getExtensionUpdateEntityList();
		for (ExtensionUpdateEntity extensionUpdateEntity : extensionUpdateEntityList){
			logger.info("accountId: {}, extensionId: {}, extensionNumber: {}", pbxResourceObserverModel.getAccountId(), extensionUpdateEntity.getExtensionId(), extensionUpdateEntity.getExtensionNumber());
			extensionMapper.updateStatus("bM-ScE28SCm7LKUo32quig", "-0UzUpiiQ8Wbrt5XnzFSxQ");
		}
	}
}
