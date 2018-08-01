package club.fsCommunity.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;


public interface CloudService {

	
	public String saveImage(MultipartFile file) throws IOException;
	
}
