package com.itheima.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test02 {
    public static void main(String[] args) throws Exception {

        testFreemarker();

    }

    private static void testFreemarker() {
        // 这里的KEY与模板中占位符需保持一致
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("clientId", "123");
        params.put("benefType", "INDIVIDUAL");
 /*       params.put("name","freemarker名称");
        params.put("clazz","com.itheima.Test.test02");*/




        Map<String, Object> user1 = new HashMap<String, Object>();
        user1.put("benefName", "黄飞鸿");
        user1.put("feedSourceSystem", "AMAZON");
        user1.put("ruleId", "RULE951");


        Map<String, Object> user2 = new HashMap<String, Object>();
        user2.put("benefName", "黄飞鸿的儿子");
        user2.put("feedSourceSystem", "黄小虎");
        user2.put("ruleId", "RULE955");


        List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();
        userList.add(user1);
        userList.add(user2);

        params.put("userList",userList);






        try {
            Configuration config = new Configuration(Configuration.VERSION_2_3_23);
            config.setDefaultEncoding("UTF-8");
            //也可以这样：config.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir") + "/src/main/resources/templates/"));
            config.setClassForTemplateLoading(test02.class, "/templates/");
            Template template = config.getTemplate("test02.ftl");
            String apiRequest = FreeMarkerTemplateUtils.processTemplateIntoString(template, params);
            System.out.println("apiRequest==" + apiRequest);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
