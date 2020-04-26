package com.web;

import java.io.Serializable;

public class User implements Serializable {
	private String username;
	private String pass;
	private String regpwd ;
	private String autologin;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRegpwd() {
		return regpwd;
	}

	public void setRegpwd(String regpwd) {
		this.regpwd = regpwd;
	}

	public String getAutologin() {
		return autologin;
	}

	public void setAutologin(String autologin) {
		this.autologin = autologin;
	}

}
