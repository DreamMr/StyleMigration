package com.stylemigration.stylemigration.controller.home;

import com.stylemigration.stylemigration.service.migration.Migration;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Controller
@RequestMapping(value = "/home")
public class MainController {
    @Autowired
    Migration migration;
    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    String uploadImg(MultipartHttpServletRequest request){
        System.out.println("uploadImg");
        Iterator<String> it = request.getFileNames();
        System.out.println("test");
        MultipartFile file = null;
        JSONArray jsonArray = new JSONArray();
        while(it.hasNext()){
            JSONObject jsonObject = new JSONObject();
            file = request.getFile(it.next());
            System.out.println(file.getName());
            System.out.println(file.getOriginalFilename()+"       "+file.getSize());
            try{
                String imageBase64 = Base64.encodeBase64String(file.getBytes());
                System.out.println(imageBase64);
                String transform = migration.transForm(imageBase64);
                System.out.println(transform);

//                jsonObject.put("before","data:image/jpg;base64,"+imageBase64);
                jsonObject.put("after","data:image/jpg;base64,"+transform);
                jsonArray.put(jsonObject);
            }catch (IOException e){
                e.printStackTrace();
            }

//            File newFile = new File("D:\\image\\"+file.getOriginalFilename());
//            try{
//                file.transferTo(newFile);
//            }catch (IOException e){
//                e.printStackTrace();
//            }
        }
        return jsonArray.toString();
    }

}
