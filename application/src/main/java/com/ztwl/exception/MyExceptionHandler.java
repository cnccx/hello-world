package com.ztwl.exception;

import com.ztwl.common.exception.MyException;
import com.ztwl.common.response.ResultBody;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description: 业务相关统一异常处理类
 * Copyright: 厦门神州鹰软件科技有限公司
 * @author wangtonggui
 * @date 2018/3/9
 **/
@ControllerAdvice
public class MyExceptionHandler {
    /**
     * 捕获自定义的异常实体
     * @param e 异常实体
     * @return response的统一实体
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public ResultBody myException(MyException e) {
        int code = e.getResultEnum().getCode();
        switch (code) {
            // 业务处理
            default:

        }
        return ResultBody.errorBody(e.getResultEnum(), e.getBody());
    }
}
