package com.tutorial.springboot.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("basic")
public class BasicValueConfiguration {
	
	private String message;
	private int number;
	private boolean value;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public boolean isValue() {
		return value;
	}
	public void setValue(boolean value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "BasicValueConfiguration [message=" + message + ", number=" + number + ", value=" + value + "]";
	}
	
			
	

}
