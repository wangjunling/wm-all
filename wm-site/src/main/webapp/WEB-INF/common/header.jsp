<%@ page import="site.wmblog.common.web.xuser.XUserSession" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page import="site.wmblog.common.web.xuser.XUser" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<header class="wm-header mdl-layout__header">
    <div class="mdl-layout__header-row">
        <!-- Title -->
        <span class="mdl-layout-title"><a class="wm-logo" href="#">DOUBLEKILL</a></span>
        <!-- Add spacer, to align navigation to the right -->
        <div class="mdl-layout-spacer"></div>
        <!-- Navigation. We hide it in small screens. -->
        <nav class="wm-navigation mdl-navigation mdl-layout--large-screen-only">
            <a class="mdl-navigation__link" href="">首页</a>
            <a class="mdl-navigation__link" href="">分类</a>
            <a class="mdl-navigation__link" href="">归档</a>
            <a class="mdl-navigation__link" href="">标签</a>
        </nav>
        <!-- Tabs -->
    </div>
</header>
<div class="mdl-layout__drawer">
    <span class="mdl-layout-title">DOUBLEKILL</span>
    <nav class="mdl-navigation">
        <a class="mdl-navigation__link" href="">首页</a>
        <a class="mdl-navigation__link" href="">分类</a>
        <a class="mdl-navigation__link" href="">归档</a>
        <a class="mdl-navigation__link" href="">标签</a>
    </nav>
</div>
