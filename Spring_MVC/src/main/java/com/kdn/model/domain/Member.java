package com.kdn.model.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Member implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private String withdraw;

	public Member() {	}
	public Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	public Member(String id, String pw, String name, String email
                , String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	public Member(String id, String pw, String name, String email
                , String address, String withdraw) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.withdraw = withdraw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpw() {
		return pw;
	}
	public void setpw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(String withdraw) {
		this.withdraw = withdraw;
	}
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id=").append(id).append(", pw=").append(pw).append(", name=").append(name)
				.append(", email=").append(email).append(", address=").append(address).append(", withdraw=")
				.append(withdraw);
		return builder.toString();
	}
}
