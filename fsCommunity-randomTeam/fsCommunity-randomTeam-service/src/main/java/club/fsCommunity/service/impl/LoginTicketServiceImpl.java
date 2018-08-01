package club.fsCommunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.fsCommunity.mapper.LoginTicketMapper;
import club.fsCommunity.pojo.LoginTicket;
import club.fsCommunity.service.LoginTicketService;

@Service
public class LoginTicketServiceImpl implements LoginTicketService {

	@Autowired
	private LoginTicketMapper loginTicketMapper;
	
	@Override
	public LoginTicket selectLoginTicketByTicket() {
		return null;
	}


}
