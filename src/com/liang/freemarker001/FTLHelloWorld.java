package com.liang.freemarker001;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liang on 2016/10/8.
 */
public class FTLHelloWorld {

    public static void main(String[] args){
        //FreeMark configuration object
        Configuration cfg = new Configuration();
        try{
            //Load template from source folder
            Template template = cfg.getTemplate("src/helloworld.ftl");

            //Build the data-model
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("message","Hello World");

            //User model
            User user = new User();
            user.setId("2016001");
            user.setName("sanye");
            user.setAge(19);
            user.setGender("girl");

            data.put("user_001",user);

            //List parsing
            List<String> countries = new ArrayList<String>();
            countries.add("India");
            countries.add("United States");
            countries.add("Germany");
            countries.add("France");

            data.put("countries",countries);

            //Console output
            Writer out = new OutputStreamWriter(System.out);
            template.process(data, out);
            out.flush();

            //File output
            Writer file = new FileWriter(new File("D:\\FTL_helloworld.txt"));
            template.process(data, file);
            file.flush();
            file.close();
        } catch (IOException e){
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }


}
