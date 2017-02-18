package com.bigadataguide.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cloudera on 2/18/17.
 */
@Configuration
public class AutoConfigure {
    public AutoConfigure() {

    }

    @Bean(
            name = {"hadoopAuthManager"}
    )
    @Qualifier("hadoopAuthManager")
    static  HadoopAuthenticationInitializer hadoopAuthenticationInitializer() {
        return new HadoopAuthenticationInitializer();
    }
}
