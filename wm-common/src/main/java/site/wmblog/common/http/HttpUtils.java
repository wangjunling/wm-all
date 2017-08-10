package site.wmblog.common.http;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Fe on 14-9-12.
 */
public class HttpUtils {

    public static boolean isXhr(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        if (StringUtils.isEmpty(requestType))
            return false;
        else
            return true;
    }


}
