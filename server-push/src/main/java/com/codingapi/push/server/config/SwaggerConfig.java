package com.codingapi.push.server.config;

import com.google.common.base.Predicate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.regex.Pattern;


/**
 * @author 54484
 */
@EnableSwagger2
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "codingapi.swagger2")
@Configuration
public class SwaggerConfig {

    private String host;

    private String pattern;

    private String title;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Bean
    public Docket createRestApi() {
        Predicate<RequestHandler> predicate =
                new Predicate<RequestHandler>() {
                    @Override
                    public boolean apply(RequestHandler input) {
                        Class<?> declaringClass = input.declaringClass();

                        boolean isController = declaringClass.isAnnotationPresent(Controller.class);
                        boolean isRestController = declaringClass.isAnnotationPresent(RestController.class);

                        String className = declaringClass.getName();
                        boolean has = Pattern.matches(pattern, className);
                        if (has) {
                            if (isController) {
                                if (input.isAnnotatedWith(ResponseBody.class)) {
                                    return true;
                                }
                            }
                            if (isRestController) {
                                return true;
                            }
                            return false;
                        }

                        return false;
                    }
                };
        //添加head参数start
//        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<Parameter>();
//        tokenPar.name("token").description("授权令牌")
//                .modelRef(new ModelRef("string"))
//                .parameterType("query")
//                .required(false)
//                .build();
//        pars.add(tokenPar.build());
        //添加head参数end
        return new Docket(DocumentationType.SWAGGER_2)
                .host(host)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(predicate)
                .build()
                .directModelSubstitute(java.sql.Timestamp.class, java.sql.Date.class)
                .enableUrlTemplating(false);
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder().title(title).version("1.0").build();
    }
}
