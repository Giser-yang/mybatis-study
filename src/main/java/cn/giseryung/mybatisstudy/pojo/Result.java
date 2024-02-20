package cn.giseryung.mybatisstudy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result <T>{
    private Integer code;
    private String message;
    private T data;

    public static Result success(){
        return new Result(200,"操作成功",null);
    }
    public static  <E>Result<E> success(E data){
        return new Result<E>(200,"操作成功",data);
    }
    public static Result error(){
        return new Result(400,"操作失败",null);
    }
}
