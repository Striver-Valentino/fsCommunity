package club.fsCommunity.service.impl;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import club.fsCommunity.common.utils.GeneralUtils;
import club.fsCommunity.service.CloudService;
import club.fsCommunity.service.CodeKeysService;

/**
 * 七牛云的服务，是一个通用的 Service
 * 如果以后要换成 其它的云服务，只需要换一个类即可。
 * 
 * @author Administrator
 *
 */
@Service("CloudService")
public class QiniuServiceImpl implements CloudService {
	
	@Autowired
	private CodeKeysService codeKeysService;

	/**
	 * 七牛云上传图片
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@Override
	public String saveImage(MultipartFile file) throws IOException {

        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2()); // Zone.zone2() 华南

        //创建上传对象
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);

        //...生成上传凭证，然后准备上传
        //设置好账号的ACCESS_KEY和SECRET_KEY
        String accessKey = codeKeysService.getQiniuAK();
        String secretKey = codeKeysService.getQiniuSK();
        //要上传的空间
        String bucket = "nowcoder";

        //如果是Windows情况下，格式是 D:\\qiniu\\test.png
        // 一般情况下，uploadManager的put 方法 的 第一个参数 用 文件的二进制流数组，而不用 文件 在本地 的路径
        //String localFilePath = "/home/qiniu/test.png";

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        // 文件 使用 UUID 自定义
        //String key = null;

        //密钥配置
        Auth auth = Auth.create(accessKey, secretKey);
        //简单上传，使用默认策略，只需要设置上传的空间名就可以了；生成 Token
        String upToken = auth.uploadToken(bucket);

        try {

            /**
             * 一般的图片上传 ，第一步 是 要判断，这是不是 一张 图片，
             * 要判断是不是一张图片，是需要 一些 图片解析库的，但为了方便，
             * 判断 文件 后缀名 也是可以的。
             */

            // 先找到 最后 一个 点 的位置，因为 文件名 可能是 xxx._=adfa.jpg ，有多个 点 的。
            int dotPos = file.getOriginalFilename().lastIndexOf(".");

            if(dotPos < 0){ // 找不到 最后 一个 点 的位置，说明 文件不符合规范
                return null;
            }

            // 得到 文件的 扩展名（后缀名）
            String fileExt = file.getOriginalFilename().substring(dotPos+1).toLowerCase(); // 转成 小写 ，因为 ToutiaoUtil.isFileAllowed() 方法 里 只 比对 小写。
            if(!GeneralUtils.isFileAllowed(fileExt)){
                return null;
            }

            // 后缀名 符合要求后，可以正式 开始 上传

            // 重新定义 文件名
            String fileName = UUID.randomUUID().toString().replaceAll("-","") + "." + fileExt;





            Response response = uploadManager.put(file.getBytes(), fileName, upToken);

            System.out.println("Qiniu response:" + response);
            System.out.println("response.bodyString():" + response.bodyString());
            System.out.println("response.toString():" + response.toString());

            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println("putRet.key:" + putRet.key);
            System.out.println("putRet.hash:" + putRet.hash);

            if(response.isOK() && response.isJson()){
                String key = putRet.key;
                return GeneralUtils.QINIU_DOMAIN_PREFIX + key; // 返回 图片 在 七牛云上的 访问地址
            }else{
                return null;
            }

        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }

            return null;
        }

    }
	
	
	
	
	
	
	
	
}
