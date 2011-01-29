/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.poll.bo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author hoschi
 */
public class DateFormatter {
	// the desired format

	private static final String pattern = "yyyy-MM-dd'T'HH:mm";

	public static Date parseString(String dateString) throws Exception {
		return new SimpleDateFormat(pattern).parse(dateString);
	}

	public static String dateToString(Date date) {
		return new SimpleDateFormat(pattern).format(date);
	}
}
