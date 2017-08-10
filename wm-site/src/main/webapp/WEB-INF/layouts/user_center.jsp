<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@include file="/WEB-INF/jsp/taglib/taglibs.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
  <title> list </title>
  <meta name="description" content="众才" />
  <meta name="keywords" content="众才 云商城 云电器商城 电器商城"/>
  <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
  <meta name="Author" content="cloud assistant" />
  <link rel="shortcut icon" href="img/zc-ico-48.ico" type="image/x-icon"/>
  <%@ include file="/WEB-INF/common/common.jsp" %>

</head>
<body class="bodynormal">
<%@ include file="/WEB-INF/common/header.jsp" %>
<div class="graycont">
  <div class="bdWrp">

    <div class="mcontbg clearfix">
      <%@ include file="/WEB-INF/common/left.jsp" %>
      <decorator:body/>  <!-- end/rcontbg -->
    </div>

  </div>  <!-- end/bdWrp -->


</div>
<%@ include file="/WEB-INF/common/footer.jsp" %>
</body>
</html>


