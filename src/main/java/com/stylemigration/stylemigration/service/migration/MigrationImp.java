package com.stylemigration.stylemigration.service.migration;

import com.stylemigration.stylemigration.service.webservice.Application;
import com.stylemigration.stylemigration.service.webservice.TransFormService;
import org.springframework.stereotype.Component;

@Component
public class MigrationImp implements Migration {
    @Override
    public String transForm(String base64Code) {
        String base64CodeNoHead=delHead(base64Code);
        if(base64CodeNoHead==null){return null;}
        /**
         * 调用webservice
         */
        TransFormService transService=new TransFormService();
        Application application=transService.getApplication();
        String ans=application.trans(base64CodeNoHead);
        return ans;
    }
    String delHead(String base64Code){
        for(int i=0;i<base64Code.length();i++){
            if(base64Code.charAt(i)==','){
                return base64Code.substring(i+1);
            }
        }
        return base64Code;
    }
}
