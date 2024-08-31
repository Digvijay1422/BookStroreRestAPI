package com.api.book.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileUploadHelper {

//	public final String UPLOAD_DIR="C:\\Users\\omkar\\eclipse-workspace\\NewSpringBoot\\BooRest2\\src\\main\\resources\\static\\image";
	public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();

	public FileUploadHelper() throws IOException
	{
		
	}
	public boolean uploadFile(MultipartFile multiPartFile)
	{
		boolean f =false;
		try {
//			InputStream is = multiPartFile.getInputStream();
//			byte data[] = new byte[is.available()];
//			is.read(data);
//			
//			//write
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+multiPartFile.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			fos.close();
			
			Files.copy(multiPartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multiPartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			f = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
