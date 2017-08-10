<%@ tag import="site.wmblog.common.web.xuser.XUserSession" %>
<%@ tag pageEncoding="utf-8" isELIgnored="false" description="公用头部" body-content="empty" %>
<%= XUserSession.getCurrent().getCsrfToken()%>
