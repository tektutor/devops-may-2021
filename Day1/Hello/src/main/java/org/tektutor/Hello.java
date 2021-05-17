package org.tektutor;

public  class Hello {

	public String sayHello() {
		return "Java - Hello World using Maven !";	
	}

	public static void main(String[] args) {
		Hello hello = new Hello();
		System.out.println ( hello.sayHello() ); 
	}

}
