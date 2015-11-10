package com.nerbit.nobit.keyrepo.dataKey;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.nerbit.nobit.keyrepo.user.User;

@Entity
@Table(name="data_key")
public class DataKey {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	@NotNull
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="fk_uid",referencedColumnName="uid")
	User user;
	
	@NotNull
	String hexKey;
	
	Date expireDate;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the hexKey
	 */
	public String getHexKey() {
		return hexKey;
	}

	/**
	 * @param hexKey the hexKey to set
	 */
	public void setHexKey(String hexKey) {
		this.hexKey = hexKey;
	}

	/**
	 * @return the expireDate
	 */
	public Date getExpireDate() {
		return expireDate;
	}

	/**
	 * @param expireDate the expireDate to set
	 */
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	public DataKey() {
		// TODO Auto-generated constructor stub
	}

	public DataKey(User user, String hexKey) {
		super();
		this.user = user;
		this.hexKey = hexKey;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DataKey [id=" + id + ", user=" + user + ", keyIdex=" + hexKey + ", expireDate=" + expireDate + "]";
	}
	
	
	
}
