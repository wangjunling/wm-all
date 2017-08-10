package site.wmblog.common.result;

/**
 * Created by Fe on 15/1/19.
 */
public class AjaxResult {

    public static final String STATUS_OK       = "OK";
    public static final String STATUS_ERROR    = "ERROR";
    public static final String STATUS_NO_LOGIN = "NO_LOGIN";
    public static final String STATUS_NO_PERMISSION = "NO_PERMISSION";
    public static final String STATUS_PARAM_ERROR = "PARAM_ERROR";

    public AjaxResult(Object data) {
        this.data = data;
        this.status = STATUS_OK;
    }

    public AjaxResult() {
        this.status = STATUS_OK;
    }

    /**
     * 返回状态
     */
    private String status;
    /**
     * 异常提示
     */
    private String message;
    /**
     * 业务数据
     */
    private Object data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public <T> T getData() {
        return (T) data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
