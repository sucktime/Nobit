package com.nerbit.nobit.keyrepo.Authenticate;

@Deprecated
public class AuthenticateResult {
	int statusCode;
	String resultDiscription;
	public AuthenticateResult(int statusCode, String resultDiscription) {
		super();
		this.statusCode = statusCode;
		this.resultDiscription = resultDiscription;
	}
}
