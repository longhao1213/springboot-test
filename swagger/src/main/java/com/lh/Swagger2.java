package com.lh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by 龙浩 on 2018/7/19.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    // swagger2的配置文件,这里可以配置swagger2的一些基本的内容,比如扫描的包等等
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 为当前包的路径 这个包指的是我们在哪些类中使用swagger2来测试。
                .apis(RequestHandlerSelectors.basePackage("com.lh.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    // 构建api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                // 页面标题
                .title("spring Boot 测试使用 Swagger2 构建REstful API")
                // 创建人
                .contact(new Contact("longhao", "", ""))
                // 版本号
                .version("1.0")
                // 描述
                .description("这里写API描述")
                .build();
    }
}
