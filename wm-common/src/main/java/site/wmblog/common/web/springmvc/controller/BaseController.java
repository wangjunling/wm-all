package site.wmblog.common.web.springmvc.controller;

import com.alibaba.fastjson.JSON;
import site.wmblog.common.constant.Constant;
import site.wmblog.common.web.xuser.XUser;
import site.wmblog.common.web.xuser.XUserSession;
import site.wmblog.common.result.AjaxResult;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Fe on 15/6/25.
 */
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected AjaxResult newAjaxResult() {
        return new AjaxResult();
    }

    protected AjaxResult newAjaxResult(Object data) {
        return new AjaxResult(data);
    }

    protected ModelAndView newModelAndView(String viewName) {
        return new ModelAndView(viewName);
    }

    public XUser getXUser() {
        return XUserSession.getCurrent().getXUser();
    }

    @ExceptionHandler
    public void resolveException(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception{
        logger.error("handle exception:", e);
        String uri = request.getRequestURI();
        if (StringUtils.endsWith(uri, ".json")) {
            AjaxResult ajaxResult = new AjaxResult();
            ajaxResult.setStatus(AjaxResult.STATUS_ERROR);
            ServletOutputStream out = response.getOutputStream();
            IOUtils.write((JSON.toJSONString(ajaxResult).getBytes(Constant.DEFAULT_CHARSET)), out);
            IOUtils.closeQuietly(out);

        } else {
            response.sendRedirect("/error/500.html");
        }
    }
}
