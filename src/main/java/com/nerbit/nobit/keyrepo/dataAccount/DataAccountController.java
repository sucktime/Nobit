package com.nerbit.nobit.keyrepo.dataAccount;

import com.nerbit.nobit.keyrepo.user.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataAccountController {

	@Autowired
	DataAccountRepository dataAccountRepository;

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/data-account/get-list", method = RequestMethod.GET)
	public Object getDataAccounts(
			@RequestParam(value = "user_id") String userID,
			@RequestParam(value = "timestamp") String timestamp,
			@RequestParam(value = "signature") String signature) {

		/*
		 * verify the signature and timestamp
		 * 
		 * Errors: singnature_error, timestamp_error
		 */

		List<DataAccount> accounts = new ArrayList<DataAccount>();

		User user = userRepository.findByUserId(userID);
		if (user == null)
			return new UserError(UserError.ERR_CODE_NO_SUCH_USER,
					UserError.ERR_DISP_NO_SUCH_USER);

		accounts = dataAccountRepository.findByUser(user);

		if (accounts == null)
			return new DataAccountError(
					DataAccountError.ERR_CODE_NO_SUCH_DATAACCOUNT,
					DataAccountError.ERR_DISP_NO_SUCH_DATAACCOUNT);

		List<DataAccountView> views = new ArrayList<DataAccountView>();
		for (DataAccount da : accounts) {
			da.dataAccountView.setId(da.getId());
			views.add(da.getDataAccountView());
		}

		return views;
	}

	@RequestMapping(value = "/data-account/add-one")
	public Object setDataAccount(
			@RequestParam(value = "user_id") String userId,
			@RequestParam(value = "timestamp") String timestamp,
			@RequestParam(value = "domain") String domain,
			@RequestParam(value = "account_id") String accountId,
			@RequestParam(value = "account_key") String accountKey,
			@RequestParam(value = "signature") String signature) {

		/*
		 * verify signature and timestamp
		 * 
		 * Errors: signature_error, timestamp_error
		 */

		User user = userRepository.findByUserId(userId);
		if (user == null)
			return new UserError(UserError.ERR_CODE_NO_SUCH_USER,
					UserError.ERR_DISP_NO_SUCH_USER);

		/*
		 * verify if the domain,acccountId,accountKey is valid
		 */

		DataAccount dataAccount = dataAccountRepository.save(new DataAccount(
				new DataAccountView(domain,accountId, accountKey),user));

		if (dataAccount == null)
			return new DataAccountError("202", "storging error");
		
		dataAccount.dataAccountView.setId(dataAccount.getId());
		return dataAccount.getDataAccountView();
	}

	@RequestMapping("/data-account/delete-one")
	public Object deleteDataAccount(
			@RequestParam(value = "user_id") String userId,
			@RequestParam(value = "timestamp") String timetamp,
			@RequestParam(value="id") long id,
			@RequestParam(value = "signature") String signature) {
		
		User user = userRepository.findByUserId(userId);
		if(user == null)
			return new UserError(UserError.ERR_CODE_NO_SUCH_USER,
					UserError.ERR_DISP_NO_SUCH_USER);
		/*
		 * verify signature and timestamp
		 * 
		 * Errors: signature_error, timestamp_error
		 */
		
		dataAccountRepository.deleteOne(id);
		//if(re<1){
			//return new DataAccountError("203", "delete error");
		//}
		//else {
			//return re+" items deleted";
		//}
		return "{status: request committed}";
	}
}
