package com.curves.front.webapi.commons;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author vic
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.curves.front.webapi.services.controller"))
                .paths(PathSelectors.any())
                .build();

    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Curves WebAPI 开发平台")
//                .description("Curves 全系统 WebAPI 调试接口")
//                .termsOfServiceUrl("")
                .contact(initContextInfo())
                .version("1.0")
                .build();
    }

    private String initContextInfo() {
        StringBuffer sb = new StringBuffer();
        sb.append("Curves Network Technology Co., Ltd.");
        return sb.toString();
    }


}
