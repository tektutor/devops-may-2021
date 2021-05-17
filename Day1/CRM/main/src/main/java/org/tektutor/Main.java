package org.tektutor;

public class Main {

	public String getModuleName() {
		return "Main Module";
	}

	public static void main  ( String[] args ) {

		Frontend fe  = new Frontend();
		BusinessLayer bl  = new BusinessLayer();
		Backend dal = new Backend();

		System.out.println ( fe.getModuleName() );
		System.out.println ( bl.getModuleName() );
		System.out.println ( dal.getModuleName() );

	}

}
