package co.com.liteThinking.config;

import co.com.liteThinking.api.util.CodeBuilderApi;
import co.com.liteThinking.r2dbc.util.CodeBuilderAdapters;
import org.reactivecommons.utils.ObjectMapper;
import org.reactivecommons.utils.ObjectMapperImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public CodeBuilderAdapters codeBuilderAdapters() {return new CodeBuilderAdapters();}

    @Bean
    public CodeBuilderApi codeBuilderApi() {return new CodeBuilderApi();}

}
