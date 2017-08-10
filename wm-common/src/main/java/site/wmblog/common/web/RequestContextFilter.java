package site.wmblog.common.web;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.wmblog.common.util.FastJson;
import site.wmblog.common.web.xuser.XUserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chengpanwang on 7/17/15.
 */
public class RequestContextFilter implements Filter {

    public static final Logger logger = LoggerFactory.getLogger(RequestContextFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        RequestContext.init((HttpServletRequest) request, (HttpServletResponse) response, null);
        String seq = RequestContext.getSeq();
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        String cookieJson = FastJson.toJson(httpServletRequest.getCookies());
        logger.info("seq : {}  | request uri : {} | cookie : {} | request param : {} ",new Object[]{seq,httpServletRequest.getRequestURI(),cookieJson,getRequestParam(httpServletRequest)});
        long star = System.currentTimeMillis();
        chain.doFilter(request, response);
        RequestContext.getSession().setAttribute("xuser_session", XUserSession.getCurrent());
        long end = System.currentTimeMillis();
        logger.info("seq : {} |  response , used : {} ms",seq, end -star);
        RequestContext.clear();

    }

    public String getRequestParam(HttpServletRequest request) {
      return FastJson.toJson(request.getParameterMap());
    }

    @Override
    public void destroy() {

    }
}
