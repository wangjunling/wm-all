package site.wmblog.common.web.springmvc.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.common.collect.Lists;
import site.wmblog.common.http.HttpUtils;
import site.wmblog.common.result.AjaxResult;
import site.wmblog.common.util.FastJson;
import site.wmblog.common.web.xuser.XUser;
import site.wmblog.common.web.xuser.XUserSession;

/**
 * Created by Fe on 15/6/25.
 */
public class LoginCheckHandlerInterceptor extends HandlerInterceptorAdapter {

    public static final Logger logger                = LoggerFactory.getLogger(LoginCheckHandlerInterceptor.class);

    private List<String>       unCheckUrlList        = Lists.newArrayList();

    private List<String>       unCheckPatternUrlList = Lists.newArrayList();

    private String             loginUri;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestUri = request.getRequestURI();
        logger.info("check uri : {}", requestUri);
        if (unCheckUrlList.contains(requestUri) || patternMatch(requestUri)) {
            return true;
        } else {
            //TODO
            boolean hasLogin = hashLogin();
            //TODO 区分ajax请求和同步请求
            if (!hasLogin) {
                if (HttpUtils.isXhr(request)) {
                    printNoLoginResult(response);
                } else {
                    String backUrl = requestUri;
                    if (StringUtils.isNotBlank(request.getQueryString())) {
                        backUrl += "?" + request.getQueryString();
                    }
                    response.sendRedirect(loginUri + "?backUrl=" + backUrl);
                }
                return false;
            } else {
                return true;
            }
        }

    }

    private void printNoLoginResult(HttpServletResponse response) {
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            AjaxResult ajaxResult = new AjaxResult();
            ajaxResult.setStatus(AjaxResult.STATUS_NO_LOGIN);
            ajaxResult.setData(loginUri);
            writer.write(FastJson.toJson(ajaxResult));
        } catch (IOException e) {
            //TODO ignore
        } finally {
            if (writer != null) IOUtils.closeQuietly(writer);
        }

    }

    /**
     * 判断是否已经登录
     */
    private boolean hashLogin() {
        XUser xUser = XUserSession.getCurrent().getXUser();
        return xUser.isSignedIn();
    }

    public List<String> getUnCheckUrlList() {
        return unCheckUrlList;
    }

    public void setUnCheckUrlList(List<String> unCheckUrlList) {
        this.unCheckUrlList = unCheckUrlList;
    }

    public List<String> getUnCheckPatternUrlList() {
        return unCheckPatternUrlList;
    }

    public void setUnCheckPatternUrlList(List<String> unCheckPatternUrlList) {
        this.unCheckPatternUrlList = unCheckPatternUrlList;
    }

    public boolean patternMatch(String requestUri) {
        boolean flag = false;
        for (String patternUri : unCheckPatternUrlList) {
            Pattern pattern = Pattern.compile(patternUri);
            Matcher matcher = pattern.matcher(requestUri);
            if (matcher.matches()) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public String getLoginUri() {
        return loginUri;
    }

    public void setLoginUri(String loginUri) {
        this.loginUri = loginUri;
    }
}
