package club.fsCommunity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.fsCommunity.common.utils.EncryptionUtil;
import club.fsCommunity.mapper.CodekeysMapper;
import club.fsCommunity.pojo.Codekeys;
import club.fsCommunity.pojo.CodekeysExample;
import club.fsCommunity.pojo.CodekeysExample.Criteria;
import club.fsCommunity.service.CodeKeysService;


@Service
public class CodeKeysServiceImpl implements CodeKeysService {
	
	@Autowired
	private CodekeysMapper codekeysMapper;

	@Override
	public String getQiniuAK(){
		CodekeysExample example = new CodekeysExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo("qiniuAK");
		List<Codekeys> list = codekeysMapper.selectByExample(example);
		String result = EncryptionUtil.AESDncode(list.get(0).getRules(), list.get(0).getValue());
		
		
		return result;
		
	}
	
	@Override
	public String getQiniuSK(){
		CodekeysExample example = new CodekeysExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo("qiniuSK");
		List<Codekeys> list = codekeysMapper.selectByExample(example);
		String result = EncryptionUtil.AESDncode(list.get(0).getRules(), list.get(0).getValue());
		
		
		return result;
		
	}
	
	@Override
	public String getSystemEmail(){
		CodekeysExample example = new CodekeysExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo("systemEmail");
		List<Codekeys> list = codekeysMapper.selectByExample(example);
		String result = EncryptionUtil.AESDncode(list.get(0).getRules(), list.get(0).getValue());
		
		
		return result;
		
	}

	@Override
	public String getSystemEmailPwd(){
		CodekeysExample example = new CodekeysExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo("systemEmailPwd");
		List<Codekeys> list = codekeysMapper.selectByExample(example);
		String result = EncryptionUtil.AESDncode(list.get(0).getRules(), list.get(0).getValue());
		
		
		return result;
		
	}
	
	
	
	
	
	
	
	
}
