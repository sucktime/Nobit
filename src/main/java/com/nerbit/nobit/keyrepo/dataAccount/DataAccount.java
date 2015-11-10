package com.nerbit.nobit.keyrepo.dataAccount;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.nerbit.nobit.keyrepo.user.User;

@Entity 
@Table(name="data_account")
public class DataAccount{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="domain",column=@Column(name="domain")),
	@AttributeOverride(name="accountId",column=@Column(name="account_id")),
	@AttributeOverride(name="hexKey",column=@Column(name="hex_key")),
	})
	DataAccountView dataAccountView;
	
	@NotNull
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="fk_uid",referencedColumnName="uid")
	User user;
	
	
	/**
	 * @return the dataAccountView
	 */
	public DataAccountView getDataAccountView() {
		return dataAccountView;
	}

	/**
	 * @param dataAccountView the dataAccountView to set
	 */
	public void setDataAccountView(DataAccountView dataAccountView) {
		this.dataAccountView = dataAccountView;
	}

	
	
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
		this.dataAccountView.setId(id);
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

	public DataAccount(DataAccountView dataAccountView, User user) {
		super();
		this.dataAccountView = dataAccountView;
		this.user = user;
	}
	
	public DataAccount() {
		// TODO Auto-generated constructor stub
	}
}

@Embeddable
class DataAccountView implements Serializable{
	
	/**
	 * version
	 */
	private static final long serialVersionUID = 1L;
	
	@Transient
	long id;
	
	@NotNull
	String domain;
	
	@NotNull
	@Column(unique=true)
	String accountId;
	
	@NotNull
	String hexKey;

	public DataAccountView() {
		// TODO Auto-generated constructor stub
	}

	public DataAccountView(String domain, String accountId, String hexKey) {
		super();
		this.domain = domain;
		this.accountId = accountId;
		this.hexKey = hexKey;
	}
	
	

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
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
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

	
}
