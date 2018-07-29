package club.fsCommunity.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * 云服务
 * @author Administrator
 *
 */
public interface CloudService {

	/**
	 * 上传图片的服务
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String saveImage(MultipartFile file) throws IOException;
	
}
