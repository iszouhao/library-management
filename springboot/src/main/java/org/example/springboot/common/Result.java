package org.example.springboot.common;

import lombok.Data;

/*包装类*/
@Data
public class Result {
    private static final String SUCCESS_CODE="200";
    private static final String ERROR_CODE="-1";
    private String code;
    private Object data;
    private String msg;

    /**
     * 创建一个成功的Result对象
     * @return Result对象
     */
    public static Result success(){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        return result;
    }

    /**
     * 创建一个带有数据的成功的Result对象
     * @param data 数据
     * @return Result对象
     */
    public static Result success(Object data){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setData(data);
        return result;
    }

    /**
     * 创建一个失败的Result对象
     * @param msg 错误信息
     * @return Result对象
     */
    public static Result error(String msg){
        Result result =new Result();
        result.setCode(ERROR_CODE);
        result.setMsg(msg);
        return result;
    }
}
