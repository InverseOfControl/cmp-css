package com.ipaylinks.cmp.css.config;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AnnotationsConfigurer;
import net.sf.oval.integration.spring.SpringCheckInitializationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * oval参数校验
 */
@Configuration
public class ValidationConfig {

    @Bean
    public Validator initValidator(){
        AnnotationsConfigurer annotationsConfigurer = new AnnotationsConfigurer();
        annotationsConfigurer.addCheckInitializationListener(SpringCheckInitializationListener.INSTANCE);
        Validator validator =  new Validator(annotationsConfigurer);
        return validator;
    }

}
