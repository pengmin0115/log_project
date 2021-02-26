package com.log;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author pengmin
 * @date 2021/2/22 17:11
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = {"com.fanle.excel.dao", "com.fanle.login.dao"})
public class LoggingApplication {

    public static void main(String[] args) {
        // 可以做JVM参数处理的事情;
        SpringApplication.run(LoggingApplication.class, args);

        // spring默认日志输出级别为info;
        Logger baseLogger = LoggerFactory.getLogger("base");
        Logger requestLogger = LoggerFactory.getLogger("request");

        baseLogger.debug("debug 日志");
        baseLogger.info("info 日志");
        baseLogger.warn("warn 日志");
        baseLogger.error("error 日志");

        requestLogger.info("application run ...");
    }

    @RestController
    public class IndexController {
        private final Logger requestLogger = LoggerFactory.getLogger("request");
        private final Logger notifyLogger = LoggerFactory.getLogger("notify");

        @RequestMapping("/hello")
        public String index() {
            String message = "日志信息";
            requestLogger.debug("debug, {}", message);
            requestLogger.info("aaa, {}", message);
            return "index";
        }


        @RequestMapping("/notify")
        public String notifyMethod() {
            String message = "notify日志信息";
            notifyLogger.info("notify logger: {}", message);
            return "index";
        }
    }
}
