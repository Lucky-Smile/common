package com.enzo.pbx.res.observer.enums;

import com.enzo.pbx.res.observer.Constants;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/13 16:36
 * Company: Zoom
 */
public enum PbxResourceOperationEnum {
	CHANGE_ACCOUNT_ID(Constants.CHANGE_ACCOUNT_ID, Constants.ACCOUNT_PRIORITY),
	CHANGE_SITE_ID(Constants.CHANGE_SITE_ID, Constants.SITE_PRIORITY),
	UPDATE_USER(Constants.UPDATE_PBX_USER, Constants.USER_PRIORITY),
	UPDATE_EXTENSION(Constants.UPDATE_EXTENSION, Constants.EXTENSION_PRIORITY);

	private String operation;

	private int priority;

	PbxResourceOperationEnum(String operation) {
		this(operation, Integer.MAX_VALUE);
	}

	PbxResourceOperationEnum(String operation, int priority) {
		this.operation = operation;
		this.priority = priority;
	}

	public String getOperation() {
		return operation;
	}

	public int getPriority() {
		return priority;
	}

	public static List<String> sortProcessingOrder(List<String> operationNames){
		if (CollectionUtils.isEmpty(operationNames) || operationNames.size() == 1){
			return operationNames;
		}

		List<String> sortedEventList = new ArrayList<>();
		List<PbxResourceOperationEnum> sortedEnums = getSortedEnums();
		for (PbxResourceOperationEnum operationEnum : sortedEnums){
			String operation = operationEnum.getOperation();
			if (operationNames.contains(operation)){
				sortedEventList.add(operation);
			}
		}
		return sortedEventList;
	}

	private static List<PbxResourceOperationEnum> getSortedEnums(){
		List<PbxResourceOperationEnum> enumList = Arrays.asList(PbxResourceOperationEnum.values());
		Collections.sort(enumList, (o1, o2) -> {
			Integer o1Priority = o1.getPriority();
			Integer o2Priority = o2.getPriority();
			return o1Priority.compareTo(o2Priority);
		});

		return enumList;
	}
}
