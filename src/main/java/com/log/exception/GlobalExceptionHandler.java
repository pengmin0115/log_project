package com.log.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pengmin
 * @date 2021/2/23 13:49
 */

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger("error");

    /**
     *  处理MyException
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(value = {MyException.class})
    public JsonResult myExceptionHandler(HttpServletRequest request, MyException exception) {
        logger.error("myException handle: {}",exception);
        return new JsonResult(exception.getMessage());
    }

    /**
     *  处理NullPointerException
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(value = {NullPointerException.class})
    public JsonResult nullPointerExceptionHandler(HttpServletRequest request, MyException exception) {
        logger.error("nullPointerException handle: {}",exception);
        return new JsonResult(exception.getMessage());
    }


    /**
     *  处理Exception
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public JsonResult exceptionHandler(HttpServletRequest request, Exception exception) {
        logger.error("Exception handle: {}",exception);
        return new JsonResult(exception.getMessage());
    }
}
