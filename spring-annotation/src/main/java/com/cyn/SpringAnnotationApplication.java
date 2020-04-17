package com.cyn;

import com.cyn.config.ConfigurationPropertiesDemo;
import com.cyn.config.ImportFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @author chenyn
 *
 */
@Import(ImportFeature.class)
@SpringBootApplication(scanBasePackages = {"com.cyn.config"})
public class SpringAnnotationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringAnnotationApplication.class, args);
    }

}
