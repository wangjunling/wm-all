<%@ page language="java" pageEncoding="UTF-8" %>
<div class="lmenubg fl">
    <div class="sidelbar">
        <div class="proftitle"> 个人中心 </div>
        <div id="accordion" class="profmenu">
            <h3 class="open"> 会员中心 </h3>
            <div class="content" style="display: block;">
                <ul class="leftmenu">
                    <li id="profile"><a class="lists" href="/buyer/profile.htm"> 会员信息 </a></li>
                    <li id="address"><a href="/buyerShippingAddress/toList.htm" class="lists"> 收货地址 </a></li>
                </ul>
            </div>

            <h3 class="open"> 采购单管理 </h3>
            <div class="content" style="display: block;">
                <ul class="leftmenu">
                    <li class="" id="order"><a class="lists" href="/order/orderList.htm"> 我的采购单 </a></li>
                </ul>
            </div>

        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $('.leftmenu .current').removeClass("current");
        switch(leftMenuName){
            case "profile":
                $('#profile').addClass('current');
                break;
            case "address":
                $('#address').addClass('current');
                break;
            case "order":
                $('#order').addClass('current');
                break;
            default:
                break;
        }

    });
</script>