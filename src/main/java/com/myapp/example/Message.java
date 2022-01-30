package com.myapp.example;

public class Message {

	public String hello(String message) {
		if (message == null && message.trim().length() == 0) {
			message = message.concat("please provide a message");
		} else {
			message = message + " Hello";
		}
		return message;
	}

}
