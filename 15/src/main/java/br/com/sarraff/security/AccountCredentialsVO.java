package br.com.sarraff.security;

import java.io.Serializable;

public class AccountCredentialsVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	String username;
	String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
