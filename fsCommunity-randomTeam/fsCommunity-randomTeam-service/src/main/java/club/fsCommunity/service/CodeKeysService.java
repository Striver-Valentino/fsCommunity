package club.fsCommunity.service;

public interface CodeKeysService {
	
	// 从数据库获取  七牛云 accessKey
	public String getQiniuAK();
	
	// 从数据库获取  七牛云 secretKey
	public String getQiniuSK();
	
	// 从数据库获取  系统邮箱账号
	public String getSystemEmail();
	
	// 从数据库获取  系统邮箱密码
	public String getSystemEmailPwd();

}
