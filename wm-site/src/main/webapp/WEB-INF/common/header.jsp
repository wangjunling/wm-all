<%@ page import="site.wmblog.common.web.xuser.XUserSession" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page import="site.wmblog.common.web.xuser.XUser" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<link rel="shortcut icon" href="/resources/img/zc-ico-48.ico" type="image/x-icon"/>
<div id="hd">
    <div class="tgrbar clearfix">
        <div class="topbar">
            <div class="bdWrp clearfix">
                <div class="slogan fl" id="homeHeader" style="cursor: pointer"> 材易得首页 您好，欢迎来到材易得 </div>
                <div class="tbrigbg fr">
                    <%
                        XUser xUser = XUserSession.getCurrent().getXUser();
                        if (StringUtils.isNotBlank(xUser.getUserName())) {
                            out.write("<div class=\"log_reg fl\"> <a class=\"reglk\" href=\"/buyer/profile.htm\">");
                            out.write(xUser.getUserName());
                            out.write("</a> </div>");

                            out.write("<a class=\"tbarlk\" href=\"/order/orderList.htm\"> 我的材易得 </a>");

                            if (xUser.isSignedIn()) {
                                out.write("<a class=\"tbarlk\" id=\"logout\" href=\"#\"> 退出 </a>");
                            }
                        } else {
                            out.write(
                                    "<div class=\"log_reg fl\"> <a class=\"loglk\"  href=\"/login.htm\"> 请登录 </a> <a class=\"reglk\" href=\"/register.htm\"> 免费注册 </a> </div>");
                        }
                    %>
                     <a class="tbarlk"> 客户服务 </a> <a class="tbarlk last"> 商家支持 </a>
                </div>
            </div>
        </div>
        <div class="logobar bdWrp">
            <a class="zclogo fl" href="/index.html"> </a>
            <div class="topmenu fl clearfix">
                <span class="menulink"> <a class="menutxt" id="target-id-1" href="/product/search.htm?brandId=&categoryId=1"> 室内精装 </a> </span>
                <span class="menulink"> <a class="menutxt" id="target-id-2" href="/product/search.htm?brandId=&categoryId=2"> 设施设备 </a></span>
                <span class="menulink"> <a class="menutxt" id="target-id-3" href="/product/search.htm?brandId=&categoryId=3"> 土建大宗 </a> </span>
                <span class="menulink"> <a class="menutxt" id="target-id-4" href="/product/search.htm?brandId=&categoryId=4"> 外景设施 <%--<i class="i-expect"></i>--%></a> </span>
            </div>
            <div class="toprigbox fl">
                <input type="text" placeholder="请输入要搜索内容..." name="keyWord" class="tpsipt fl">
                <a class="btn btntsearch fr" href="#" id="searchBtn"> <i class="icn_search"> </i></a>
            </div>
            <div class="cartbg fl" id="usermenu">
                <a class="cartlk dropdown-toggle" href="#" data-toggle="dropdown" id="shoppongCartBtn"> </a>
                <ul class="dropdown-menu" id="cartList">
                    <li id="submitLi">
                        <div class="quitbg" id="cartTips">
                            <%--<a class="btn-blue btn btnpquit" href="/shopping/confirmOrder.htm"> 提交订单 </a>--%>
                        </div>
                    </li>
                    <li><i class="blt"></i></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/resources/js/plugins/jq-dropdown.js"></script>
<script type="text/javascript" src="/resources/js/header.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
       $('#logout').click(function(){
           $.getJSON('/logout.json', function(){
               location.reload();
           });
       });
    });
</script>
