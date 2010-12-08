/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.util;

/**
 * Wildcardsuche. Unterstützt '*' und '?'.
 * @author http://javawiki.sowas.com/doku.php?id=java:wildcard-suche
 */
public class Wildcard {

	private final String wildcardString;

	/**
	 * Der Konstruktor für die WildcardSuche.
	 *
	 * @param wildcardString Der WildcardString
	 */
	public Wildcard(String wildcardString) {
		this.wildcardString = wildcardString;
	}

	/**
	 * Die Methode, welche den Vergleich durchführt.
	 *
	 * @param str Der String, welcher darauf überprüft werden soll, ob er dem WildcardString entspricht.
	 * @return true Wenn der String dem wildcardString entspricht.
	 */
	public boolean match(String str, boolean fCasesensitive) {
		if (str == null || wildcardString == null) {
			return false;
		}
		return recursiveMatch(wildcardString, str, fCasesensitive);
	}

	/**
	 * Hier wird der eigentliche Vergleich durchgeführt
	 *
	 * @param strWildcard Der Wildcardstring, z.B.: "Test*"
	 * @param str Der zu überprüfende String, z.B. "Testlauf"
	 * @return true, wenn eine Übereinstimmung vorhanden ist, sonst false
	 */
	private boolean recursiveMatch(String strWildcard, String str, boolean fCasesensitive) {
		while (true) {
			if (strWildcard.length() == 0) {
				return str.length() == 0;
			}
			char ch = strWildcard.charAt(0);
			switch (ch) {
				case '?':
					if (str.length() == 0) {
						return false;
					}
					break;
				case '*':
					strWildcard = strWildcard.substring(1);
					while (true) {
						if (recursiveMatch(strWildcard, str, fCasesensitive)) {
							return true;
						}
						if (str.length() == 0) {
							return false;
						}
						str = str.substring(1);
					}
				default:
					if (str.length() == 0) {
						return false;
					}
					if (fCasesensitive) {
						if (ch != str.charAt(0)) {
							return false;
						}
					} else if (Character.toLowerCase(ch) != Character.toLowerCase(str.charAt(0))) {
						return false;
					}
					break;
			}
			strWildcard = strWildcard.substring(1);
			str = str.substring(1);
		}
	}
}
