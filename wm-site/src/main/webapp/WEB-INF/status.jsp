<%@ page import="site.wmblog.common.context.SpringContext" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
 SpringContext springContext =  SpringContext.getBean(SpringContext.class);

    String userName = "jdd";
    String pass = "jdd123456";

    String reqUserName = request.getParameter("userName");
    String reqPass = request.getParameter("pass");
    if (StringUtils.isNotEmpty(reqUserName) && StringUtils.isNotEmpty(reqPass)) {
        if (reqUserName.equals(userName) && reqPass.equals(pass)) {
            if (springContext != null) {
                PrintWriter printWriter = response.getWriter();
                printWriter.write("{\"status\" : \"ok\"}");
            }
        }
    }
%>

