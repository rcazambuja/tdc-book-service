package br.com.rcazambuja.book;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringCloudApplication
@EnableBinding
@EnableSwagger2
@EnableFeignClients("br.com.rcazambuja")
@ComponentScan("br.com.rcazambuja")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
