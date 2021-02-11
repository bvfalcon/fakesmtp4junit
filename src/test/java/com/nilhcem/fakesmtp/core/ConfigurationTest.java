package com.nilhcem.fakesmtp.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ConfigurationTest {
	@Test
	public void uniqueInstance() {
		Configuration a = Configuration.INSTANCE;
		Configuration b = Configuration.INSTANCE;
		assertSame(a, b);
	}

	@Test
	public void getEmptyValueWhenKeyIsNotFound() {
		assertTrue(Configuration.INSTANCE.get("this.key.doesnt.exist").isEmpty());
	}

	@Test
	public void getValueWhenKeyIsFound() {
		assertTrue(!Configuration.INSTANCE.get("application.name").isEmpty());
	}
}
