package com.itheima.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;


import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws Exception {

        testFreemarker();

    }

    private static void testFreemarker() {
        // 这里的KEY与模板中占位符需保持一致
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("clientId", "123");
        params.put("benefType", "INDIVIDUAL");
        params.put("benefName", "黄飞鸿");
        params.put("feedSourceSystem", "AMAZON");
        params.put("ruleId", "RULE951");
        try {
            Configuration config = new Configuration(Configuration.VERSION_2_3_23);
            config.setDefaultEncoding("UTF-8");
            //也可以这样：config.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir") + "/src/main/resources/templates/"));
            config.setClassForTemplateLoading(Test.class, "/templates/");
            Template template = config.getTemplate("twapi_without_birthday_gender.ftl");
            String apiRequest = FreeMarkerTemplateUtils.processTemplateIntoString(template, params);
            System.out.println("apiRequest==" + apiRequest);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

}
