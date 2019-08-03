package com.enzo.design.singleton;

import org.junit.Test;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/3 20:14
 * Company: Zoom
 */
public class SingletonTest {

	@Test
	public void SimpleSingletonTest(){
		SimpleSingleton simpleSingleton = SimpleSingleton.getInstance();
		simpleSingleton.operate();
	}
}
