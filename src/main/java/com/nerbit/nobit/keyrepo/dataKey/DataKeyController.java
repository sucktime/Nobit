package com.nerbit.nobit.keyrepo.dataKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nerbit.nobit.keyrepo.user.User;
import com.nerbit.nobit.keyrepo.user.UserError;
import com.nerbit.nobit.keyrepo.user.UserRepository;

@RestController
public class DataKeyController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	DataKeyRepository dataKeyRepository;
	
	@RequestMapping(value="/data-key/get-one",method=RequestMethod.GET)
	public Object getDatakeyByIndex(
			@RequestParam(value="user_id")String userId,
			@RequestParam(value="timestamp")String timestamp,
			@RequestParam(value="key_id")long keyId,
			@RequestParam(value="signature")String signature){
		
		User user = userRepository.findByUserId(userId);
		if(user == null){
			return new UserError(UserError.ERR_CODE_NO_SUCH_USER, UserError.ERR_DISP_NO_SUCH_USER);
		}
		
		/*
		 * verify the timestamp, signature
		 */
		
		
		DataKey dataKey = dataKeyRepository.findOne(keyId);
		
		if(dataKey == null){
			return  new DataKeyError(DataKeyError.ERR_CODE_NO_SUCH_DATAKEY, DataKeyError.ERR_DISP_NO_SUCH_DATEKEY);
		}
		return dataKey;
	}
	
	
	@RequestMapping(value="/data-key/add-one",method=RequestMethod.GET)
	public Object addDataKey(
			@RequestParam(value="user_id")String userId,
			@RequestParam(value="timestamp")String timestamp,
			@RequestParam(value="hex_key")String hexKey,
			@RequestParam(value="signature")String signature){
		
		/*
		 * Future Work:
		 * 将时间戳检查、验签两个操作单独写成一个工具类方法
		 * CryptoUtils.chechTimestamp()
		 * CryptoUtils.verifySignature()
		 */
		
		User user = userRepository.findByUserId(userId);
		if(user == null){
			return new UserError(UserError.ERR_CODE_NO_SUCH_USER, UserError.ERR_DISP_NO_SUCH_USER);
		}
		
		/*
		 * verify the timestamp, signature
		 */
		
		DataKey dataKey = new DataKey(user,hexKey);
		
		dataKey = dataKeyRepository.save(dataKey);
		
		return dataKey;
	}
	
	@RequestMapping(value="/data-key/delete-one",method=RequestMethod.GET)
	public Object deleteDataKey(
			@RequestParam(value="user_id")String userId,
			@RequestParam(value="timestamp")String timestamp,
			@RequestParam(value="key_id")Long keyId,
			@RequestParam(value="signature")String signature){
	
		
		/*
		 * Future Work:
		 * 将时间戳检查、验签两个操作单独写成一个工具类方法
		 * CryptoUtils.chechTimestamp()
		 * CryptoUtils.verifySignature()
		 */
		
		User user = userRepository.findByUserId(userId);
		if(user == null){
			return new UserError(UserError.ERR_CODE_NO_SUCH_USER, UserError.ERR_DISP_NO_SUCH_USER);
		}
		
		/*
		 * verify the timestamp, signature
		 */
		
		if(dataKeyRepository.exists(keyId)){
			dataKeyRepository.delete(keyId);
			return "{deleted:"+keyId+"}";
		}
		else {
			return  new DataKeyError(DataKeyError.ERR_CODE_NO_SUCH_DATAKEY, DataKeyError.ERR_DISP_NO_SUCH_DATEKEY);
		}
	}
	
}
