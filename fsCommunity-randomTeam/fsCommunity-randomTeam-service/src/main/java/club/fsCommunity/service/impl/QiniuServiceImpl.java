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


@Service("CloudService")
public class QiniuServiceImpl implements CloudService {
	
	@Autowired
	private CodeKeysService codeKeysService;

	
	@Override
	public String saveImage(MultipartFile file) throws IOException {

        Configuration cfg = new Configuration(Zone.zone2());

        UploadManager uploadManager = new UploadManager(cfg);

        String accessKey = codeKeysService.getQiniuAK();
        String secretKey = codeKeysService.getQiniuSK();
        String bucket = "nowcoder";


        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        try {

            

            int dotPos = file.getOriginalFilename().lastIndexOf(".");

            if(dotPos < 0){
                return null;
            }

            String fileExt = file.getOriginalFilename().substring(dotPos+1).toLowerCase(); 
            if(!GeneralUtils.isFileAllowed(fileExt)){
                return null;
            }

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
                return GeneralUtils.QINIU_DOMAIN_PREFIX + key;
            }else{
                return null;
            }

        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
            }

            return null;
        }

    }
	
	
	
	
	
	
	
	
}
