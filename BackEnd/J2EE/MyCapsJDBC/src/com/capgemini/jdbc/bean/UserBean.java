package com.capgemini.jdbc.bean;

import java.io.Serializable;

import lombok.Data;
@Data
public class UserBean implements Serializable
{
	private int userid;
	private String username;
	private String email;
	private String password;
}
