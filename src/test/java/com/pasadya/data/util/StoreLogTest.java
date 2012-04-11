package com.pasadya.data.util;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class StoreLogTest {

	@Test
	public void canCreateAndWriteToLog() throws IOException {
		StoreLog LOG = StoreLog.getInstance();
		LOG.writeToLog("This is a tesasdfasdft");
		LOG.close();
	}
}
