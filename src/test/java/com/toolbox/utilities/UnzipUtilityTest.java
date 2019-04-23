/**
 * 
 */
package com.toolbox.utilities;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author faisa
 *
 */
public class UnzipUtilityTest {

	private static final Logger log = LoggerFactory.getLogger(UnzipUtilityTest.class);

	/**
	 * Test method for
	 * {@link com.toolbox.utilities.UnzipUtility#unzip(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnzip() {
		String zipFilePath = "c:/Test/MyPics.zip";
		String destDirectory = "f:/Pics                                  ";
		UnzipUtility unzipper = new UnzipUtility();
		try {
			unzipper.unzip(zipFilePath, destDirectory);
		} catch (Exception ex) {
			// some errors occurred
			log.error("Error Occured While unzippeing", ex);
		}
	}

}
