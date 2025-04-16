package org.yinxiao.nothing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.yinxiao.nothing.config.WebMvcConfig;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class NothingApplication {

    public static void main(String[] args) {
        SpringApplication.run(NothingApplication.class, args);
    }

}
