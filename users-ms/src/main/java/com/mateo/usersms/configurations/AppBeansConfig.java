package com.mateo.usersms.configurations;

import com.mateo.usersms.utils.WordReaderUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeansConfig {

    @Bean
    public static WordReaderUtil wordReaderUtil(){
        return WordReaderUtil.getInstance();
    }


}
