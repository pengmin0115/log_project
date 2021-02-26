package com.log.controller;

import com.log.exception.JsonResult;
import com.log.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pengmin
 * @date 2021/2/23 13:49
 */
@RestController
@RequestMapping("/error")
public class ErrorController {

    private Logger requestLogger = LoggerFactory.getLogger("request");

    @RequestMapping("/test1")
    public JsonResult test() {
        if (true) {
            throw new MyException("myException ...");
        }
        return new JsonResult();
    }

    @RequestMapping("/test2")
    public JsonResult test2(@RequestParam(name = "str") String str, HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        String remoteHost = request.getRemoteHost();
        String remoteUser = request.getRemoteUser();

        String method = request.getMethod();
        StringBuffer url = request.getRequestURL();
        int remotePort = request.getRemotePort();

        String queryString = request.getQueryString();
        requestLogger.info("[客户端]:{},[主机]:{},[用户]:{},[请求方式]:{},[URL]:{},[端口]:{},[参数]:{}", remoteAddr, remoteHost, remoteUser, method, url, remotePort, queryString);
        boolean equals = "".equals(str);
        return new JsonResult();
    }
}
