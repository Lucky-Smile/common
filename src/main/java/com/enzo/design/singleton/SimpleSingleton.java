package com.enzo.design.singleton;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/3 19:53
 * Company: Zoom
 */
public class SimpleSingleton {

	private final Logger logger = LoggerFactory.getLogger(SimpleSingleton.class);

	private static SimpleSingleton instance = new SimpleSingleton();

	private SimpleSingleton(){
		init();
	}

	private void init(){
		// do nothing ...
	}

	public static SimpleSingleton getInstance(){
		return instance;
	}

	public void operate(){
		logger.debug("Doing something...");
		logger.debug("Done");
	}
}
