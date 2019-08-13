package com.enzo.pbx.extension.setting;

import com.enzo.pbx.extension.setting.annotation.SettingProperties;
import com.enzo.pbx.extension.setting.handler.AbstractExtensionSettingHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/4 16:45
 * Company: Zoom
 */
@Component
@SuppressWarnings("unchecked")
public class ExtensionSettingHandlerProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
		Map<String, AbstractExtensionSettingHandler> settingHandlerMap = new HashMap<>(32);

		// register handlers with SettingProperties annotation
		Map<String, Object> handlerMap = configurableListableBeanFactory.getBeansWithAnnotation(SettingProperties.class);
		handlerMap.forEach((k, v) -> {
			if (v instanceof AbstractExtensionSettingHandler){
				AbstractExtensionSettingHandler handler = (AbstractExtensionSettingHandler) v;
				SettingProperties settingProperties = handler.getClass().getAnnotation(SettingProperties.class);
				settingHandlerMap.put(settingProperties.operateLevel(), handler);
			}
		});

		ExtensionSettingHandlerContext extensionSettingHandlerContext = new ExtensionSettingHandlerContext(settingHandlerMap);
		configurableListableBeanFactory.registerSingleton(ExtensionSettingHandlerContext.class.getName(), extensionSettingHandlerContext);
	}
}
