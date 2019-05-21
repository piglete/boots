package com.bych;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by lxl on 2019/05/10.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket confApiContext() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("RestFull APIs")
                .apiInfo(getApiInfo())
                .useDefaultResponseMessages(false)
                .pathMapping("/")
                .select()
//                .forCodeGeneration(true)
                .apis(RequestHandlerSelectors.basePackage("com.bych.control"))
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(ApiIgnore.class);//忽略类型
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("QHGM")
                .description("QINHUA NATURE GAS MONITOR SYSTEM")
                .termsOfServiceUrl("http://www.boots.com")
                .contact("boots")
                .version("1.0")
                .build();
    }
}
