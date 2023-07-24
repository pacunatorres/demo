package com.ibc.backend.negocio.utils;

import lombok.var;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.S3Object;
//import com.amazonaws.services.s3.model.S3ObjectInputStream;
//import com.amazonaws.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ibc.backend.negocio.dto.ExportExcel;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class Utils {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Id", "Title", "Description", "Published" };
    static String SHEET = "Convenios";

//    @Value("${aws.s3.bucket}")
//    private String bucket;

//    @Autowired
//    private AmazonS3 amazonS3;

    public File convertMultipartToFile(MultipartFile file){
        var convertFile = new File(file.getOriginalFilename());
        try (var fos = new FileOutputStream(convertFile)){
            fos.write(file.getBytes());
        }catch (IOException e){
            log.error("error", e);
        }
        return convertFile;
    }

//    public byte[]downloadFile(String fileName){
//
//        var s3Object = amazonS3.getObject(bucket,fileName);
//        S3ObjectInputStream inputStream = s3Object.getObjectContent();
//        byte[] content = null;
//        try {
//            content = IOUtils.toByteArray(inputStream);
//            return content;
//        }catch (IOException e){
//            log.error("Error",e);
//        }
//        return content;
//    }

    public Boolean validation(Integer variable){
        Boolean b = null;
        b = variable == 1;
        return b;
    }

    public static ByteArrayInputStream load(List<ExportExcel>exportExcels) {

        ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(exportExcels);
        return in;
    }
    public static Date stringToDate(String  dateInString) {
        try {
        	if(dateInString==null || dateInString.isBlank() ) {
        		return null;
        	}
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateInString);
            return date;
        } catch (ParseException e) {
             e.printStackTrace();
        }
        return null;
    }
}
