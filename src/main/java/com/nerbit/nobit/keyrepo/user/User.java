package com.nerbit.nobit.keyrepo.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long uid;
	
	@NotNull
	@Column(unique=true)
	private String userId;
	
	@NotNull
	private String hexkey;
	
	public User() {}
	
	User(long id){
		this.uid = id;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return uid;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.uid = id;
	}

	
	/**
	 * @return the accountId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setUserId(String accountId) {
		this.userId = accountId;
	}

	/**
	 * @return the hexkey
	 */
	public String getHexkey() {
		return hexkey;
	}

	/**
	 * @param hexkey the hexkey to set
	 */
	public void setHexkey(String hexkey) {
		this.hexkey = hexkey;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + uid + ", accountId=" + userId + ", hexkey="
				+ hexkey + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	
}
