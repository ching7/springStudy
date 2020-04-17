package com.cyn.springannotation;

import com.cyn.config.ConfigurationPropertiesDemo;
import com.cyn.config.ImportFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAnnotationApplicationTests {

    @Autowired
    ConfigurationPropertiesDemo configurationPropertiesDemo;

    @Autowired
    ImportFeature importFeature;
    @Test
    void contextLoads() {
    }

    @Test
    void getCongfig() {
        System.out.println(configurationPropertiesDemo.getTest1());
        System.out.println(configurationPropertiesDemo.getTest2());
    }

    @Test
    void getImport() {
        System.out.println(importFeature.getVar1());
        System.out.println(importFeature.getVar2());
    }
}
