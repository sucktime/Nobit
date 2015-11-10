package com.nerbit.nobit.keyrepo.Authenticate;

public interface RequestAuthenticator {
	
	public boolean requestAuthenticate(String req, String hexKey, String signature) throws Exception;
}