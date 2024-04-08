package co.com.litethinking.config;

import co.com.litethinking.api.util.CodeBuilderApi;
import co.com.litethinking.r2dbc.util.CodeBuilderAdapters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public CodeBuilderAdapters codeBuilderAdapters() {return new CodeBuilderAdapters();}

    @Bean
    public CodeBuilderApi codeBuilderApi() {return new CodeBuilderApi();}

}
