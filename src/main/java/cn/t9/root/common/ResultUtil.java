package cn.t9.root.common;

/**
 * @author Exrick
 */
public class ResultUtil<T> {

    private ResultToFront<T> result;

    public ResultUtil(){
        result = new ResultToFront<>();
        result.setSuccess(true);
        result.setMessage("success");
        result.setCode(200);
    }

    public ResultToFront<T> setData(T t){
        this.result.setResult(t);
        this.result.setCode(200);
        return this.result;
    }

    public ResultToFront<T> setSuccessMsg(String msg){
        this.result.setSuccess(true);
        this.result.setMessage(msg);
        this.result.setCode(200);
        this.result.setResult(null);
        return this.result;
    }

    public ResultToFront<T> setData(T t, String msg){
        this.result.setResult(t);
        this.result.setCode(200);
        this.result.setMessage(msg);
        return this.result;
    }

    public ResultToFront<T> setErrorMsg(String msg){
        this.result.setSuccess(false);
        this.result.setMessage(msg);
        this.result.setCode(500);
        return this.result;
    }

    public ResultToFront<T> setErrorMsg(Integer code, String msg){
        this.result.setSuccess(false);
        this.result.setMessage(msg);
        this.result.setCode(code);
        return this.result;
    }

    public static <T> ResultToFront<T> data(T t){
        return new ResultUtil<T>().setData(t);
    }

    public static <T> ResultToFront<T> data(T t, String msg){
        return new ResultUtil<T>().setData(t, msg);
    }

    public static <T> ResultToFront<T> success(String msg){
        return new ResultUtil<T>().setSuccessMsg(msg);
    }

    public static <T> ResultToFront<T> error(String msg){
        return new ResultUtil<T>().setErrorMsg(msg);
    }

    public static <T> ResultToFront<T> error(Integer code, String msg){
        return new ResultUtil<T>().setErrorMsg(code, msg);
    }
}
