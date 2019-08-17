package com.enzo.pbx.res.observer.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/14 10:56
 * Company: Zoom
 */
public interface ExtensionMapper {

	void changeAccountId(@Param("fromAccountId")String fromAccountId, @Param("toAccountId")String toAccountId, @Param("extensionIdList") List<String> extensionIdList);

	void updateStatus(@Param("accountId")String accountId, @Param("extensionId") String extensionId);
}

