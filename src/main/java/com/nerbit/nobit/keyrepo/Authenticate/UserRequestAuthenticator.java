package com.nerbit.nobit.keyrepo.Authenticate;

import com.nerbit.crypto.SM.ByteUtils;
import com.nerbit.crypto.SM.SM3.SM3DigestStateful;

public class UserRequestAuthenticator implements RequestAuthenticator{

	public boolean requestAuthenticate(String req, String hexKey, String signature) throws Exception {
		if(req == null || hexKey == null || signature == null)
			throw new Exception("null parameter");
		
		String content = req.concat(hexKey);
		byte[] contentBytes = content.getBytes("utf-8");
		byte[] sigBytes2 = SM3DigestStateful.SM3Hash256(contentBytes);
		byte[] sigBytes1 = ByteUtils.hexSequence2ByteSequence(signature.toCharArray());
		int re = ByteUtils.byteSequenceCompare(sigBytes2, sigBytes1);
		
		return re == 0;
	}
	
}
