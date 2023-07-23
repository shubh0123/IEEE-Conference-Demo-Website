/*package com.IEEE.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.IEEE.entity.User;

@Service
public class FileUploadService {

	public String fileUpload(MultipartFile file,User user) {
        try {
            if (file.isEmpty()) {
                return "No file is received";
            } else {

                user.setImgName(file.getOriginalFilename());
                user.setType(file.getContentType());
                File saveFile = new ClassPathResource("static/researchPaper").getFile();
                Path fullPath = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
                user.setImagePath(String.valueOf(fullPath));

                Files.copy(file.getInputStream(), fullPath, StandardCopyOption.REPLACE_EXISTING);
                System.gc();
                return "File Uploaded SuccessFully";
            }


        }
        catch (Exception e){
           
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
	}
}
*/