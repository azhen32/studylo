package com.azhen.service;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class PictureService {
    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;
    public static final String PREFIX = "/thum_";

    public String thunbnail(CommonsMultipartFile file,String uploadPath,String realUploadPath) {
        try {
            String des = realUploadPath + PREFIX + file.getOriginalFilename();
            Thumbnails.of(file.getInputStream()).size(WIDTH,HEIGHT).toFile(des);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return uploadPath + PREFIX + file.getOriginalFilename();
    }
}
