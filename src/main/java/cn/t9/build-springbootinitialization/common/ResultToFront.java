package cn.ffcs.eda.mqmessage.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author Exrickx
 * 前后端交互数据标准
 */

@ApiModel(description= "前后端交互数据")
public class ResultToFront<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "成功标志")
    private boolean success;

    @ApiModelProperty(value = "消息")
    private String message;

    @ApiModelProperty(value = "返回代码")
    private Integer code;

    @ApiModelProperty(value = "时间戳")
    private long timestamp = System.currentTimeMillis();

    @ApiModelProperty(value = "结果对象")
    private T result;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultToFront{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", timestamp=" + timestamp +
                ", result=" + result +
                '}';
    }
}
