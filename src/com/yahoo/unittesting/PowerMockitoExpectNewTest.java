package com.yahoo.unittesting;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ A.class })
public class PowerMockitoExpectNewTest {
	private MyQueryClass query;

	@Before
	public void setUp() {
		query = PowerMockito.mock(MyQueryClass.class);
	}

	@Test
	public void testMyMethod() throws Exception {
		PowerMockito.whenNew(MyQueryClass.class).withNoArguments().thenReturn(query);
		PowerMockito.when(query.getNextId()).thenReturn(1000000L);

		System.out.println(new A().myMethod());
	}
}

class A {

	public Long myMethod() {
		MyQueryClass query = new MyQueryClass();
		Long id = query.getNextId();
		// some more code
		return id;
	}
}

class MyQueryClass {

	public Long getNextId() {
		//lot of DB code, execute some DB query
		return 100l;
	}
}