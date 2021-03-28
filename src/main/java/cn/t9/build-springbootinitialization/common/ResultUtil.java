package cn.ffcs.eda.mqmessage.common;

/**
 * @author Exrick
 */
public class ResultUtil<T> {

    private cn.ffcs.eda.mqmessage.common.ResultToFront<T> result;

    public ResultUtil(){
        result = new cn.ffcs.eda.mqmessage.common.ResultToFront<>();
        result.setSuccess(true);
        result.setMessage("success");
        result.setCode(200);
    }

    public cn.ffcs.eda.mqmessage.common.ResultToFront<T> setData(T t){
        this.result.setResult(t);
        this.result.setCode(200);
        return this.result;
    }

    public cn.ffcs.eda.mqmessage.common.ResultToFront<T> setSuccessMsg(String msg){
        this.result.setSuccess(true);
        this.result.setMessage(msg);
        this.result.setCode(200);
        this.result.setResult(null);
        return this.result;
    }

    public cn.ffcs.eda.mqmessage.common.ResultToFront<T> setData(T t, String msg){
        this.result.setResult(t);
        this.result.setCode(200);
        this.result.setMessage(msg);
        return this.result;
    }

    public cn.ffcs.eda.mqmessage.common.ResultToFront<T> setErrorMsg(String msg){
        this.result.setSuccess(false);
        this.result.setMessage(msg);
        this.result.setCode(500);
        return this.result;
    }

    public cn.ffcs.eda.mqmessage.common.ResultToFront<T> setErrorMsg(Integer code, String msg){
        this.result.setSuccess(false);
        this.result.setMessage(msg);
        this.result.setCode(code);
        return this.result;
    }

    public static <T> cn.ffcs.eda.mqmessage.common.ResultToFront<T> data(T t){
        return new cn.ffcs.eda.mqmessage.common.ResultUtil<T>().setData(t);
    }

    public static <T> cn.ffcs.eda.mqmessage.common.ResultToFront<T> data(T t, String msg){
        return new cn.ffcs.eda.mqmessage.common.ResultUtil<T>().setData(t, msg);
    }

    public static <T> cn.ffcs.eda.mqmessage.common.ResultToFront<T> success(String msg){
        return new cn.ffcs.eda.mqmessage.common.ResultUtil<T>().setSuccessMsg(msg);
    }

    public static <T> cn.ffcs.eda.mqmessage.common.ResultToFront<T> error(String msg){
        return new cn.ffcs.eda.mqmessage.common.ResultUtil<T>().setErrorMsg(msg);
    }

    public static <T> cn.ffcs.eda.mqmessage.common.ResultToFront<T> error(Integer code, String msg){
        return new cn.ffcs.eda.mqmessage.common.ResultUtil<T>().setErrorMsg(code, msg);
    }
}
