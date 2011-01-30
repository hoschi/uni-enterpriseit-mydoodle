package de.uniluebeck.itm.ep5.client;

public class ClientLog {
	
	public static native void log(String arg) /*-{
    	eval("console.log('" + arg + "');");
	}-*/;

}
