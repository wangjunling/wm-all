<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@include file="/WEB-INF/jsp/taglib/taglibs.jsp" %>

<!doctype html>
<html lang="zh-cmn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="wmblog">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
    <title>wmblog</title>
<%@include file="/WEB-INF/common/common.jsp"%>
</head>

<body>
<!-- Always shows a header, even in smaller screens. -->
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
  <%@include file="/WEB-INF/common/header.jsp" %>
    <main class="wm-content mdl-layout__content">
        <div class="page-content">
            <div class="wm-content-inner mdl-grid">
                <%@include file="/WEB-INF/common/left.jsp"%>
                <decorator:body/>
            </div>

        </div>
        <%@ include file="/WEB-INF/common/footer.jsp" %>
    </main>
</div>
</body>

</html>
