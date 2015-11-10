package com.nerbit.nobit.keyrepo.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value="/user/get-by-user-id",method=RequestMethod.POST)
	public Object getByEmail(@RequestParam(value="id", defaultValue="jgf@163.com")String id){
		
		User user = userRepository.findByUserId(id);	
		if(user == null)
		{	
			return new UserError(UserError.ERR_CODE_NO_SUCH_USER, UserError.ERR_DISP_NO_SUCH_USER);
		}
		return user;
	}
	
}
