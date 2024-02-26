package cn.giseryung.mybatisstudy.exception;

import cn.giseryung.mybatisstudy.pojo.Result;
import cn.giseryung.mybatisstudy.utils.CMSException;
import cn.giseryung.mybatisstudy.utils.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
//        e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));

        return Result.error("操作错误");
    }
//    /**-------- 指定异常处理方法 --------**/
//    @ExceptionHandler(NullPointerException.class)
//    @ResponseBody
//    public R error(NullPointerException e) {
//        e.printStackTrace();
//        return R.setResult(ResultCodeEnum.NULL_POINT);
//    }
//
//    @ExceptionHandler(HttpClientErrorException.class)
//    @ResponseBody
//    public R error(IndexOutOfBoundsException e) {
//        e.printStackTrace();
//        return R.setResult(ResultCodeEnum.HTTP_CLIENT_ERROR);
//    }

    /**-------- 自定义定异常处理方法 --------**/
    @ExceptionHandler(CMSException.class)
    @ResponseBody
    public Result error(CMSException e) {
        log.error(ExceptionUtil.getMessage(e));

        return Result.error(e.getErrInfo());
    }
}
