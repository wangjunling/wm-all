<%--
  Created by IntelliJ IDEA.
  User: chengpanwang
  Date: 7/16/15
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/taglib/taglibs.jsp" %>

<!-- end/slide -->

<div class="graycont">

    <div class="bdWrp">

        <div class="loginbg clearfix">
            <form id="form" action="/login.htm" method="post">
                <div class="one_half fl">
                    <div class="logtit"> 会员登录</div>
                    <div class="logiptwrp">
                        <input type="text" placeholder="众才账号" class="iptlog" name="account" value='<c:out value="${buyer.account}"/>'/>
                    </div>
                    <div class="logiptwrp">
                        <input type="password" placeholder="请输入密码" class="iptlog" name="password" value='<c:out value="${buyer.password}"/>'/>
                    </div>
                    <div class="logverfbg clearfix" id="randCodeDiv">
                        <input type="text" placeholder="验证码" class="iptverf fl" name="randCode"/>

                        <div class="verfpic fl"><img src="/common/randCode.htm"></div>
                        <a class="verflk fl"> 看不清，换一张 </a>
                    </div>
                    <div class="logiptwrp">
                        <input type="checkbox" class="logcebox" name="isSavePass"/> 记住密码
                        <div id="errorMsg" style="font-size: 14px;color: red;float: right;margin-right: 34px;font-weight: bold;display: none;">
                            你输入的用户名已存在
                        </div>
                    </div>
                    <input type="hidden" name="backUrl" value='<c:out value="${buyer.backUrl}" />'>
                    <a class="btnlogin" id="submit"> 登 录 </a>
                </div>

                <div class="one_half rlogcon fl">
                    <div class="rlogtit"> 您可以使用自己的众才账号来享受其他独一无二的服务，例如</div>
                    <ul class="rlogtxt">
                        <li> 专家团队的设计规划服务</li>
                        <li> 专家团队的设计规划服务</li>
                        <li> 专家团队的设计规划服务</li>
                        <li> 专家团队的设计规划服务</li>
                    </ul>

                    <a class="btncreat" href="/register.htm"> 立即创建众才账户 </a>
                </div>
            </form>
        </div>

    </div>
    <!-- end/bdWrp -->

</div>
<!-- end/graycont -->
<script type="text/javascript">
    var status = '${status}';
    var msg = '${msg}';


    $(document).ready(function () {
        $('#randCodeDiv img, #randCodeDiv a').click(function () {
            $('#randCodeDiv img').attr('src', '/common/randCode.htm?time=' + new Date().getTime());
        });


        $('#submit').click(function () {
            $('#errorMsg').html("").hide();
            $('#form').submit();
        });

        $('form').on('keydown', function (e) {
            var code = e.which;
            if (code == 13) {
                $('#errorMsg').html("").hide();
                $('#form').submit();
            }
        });

        if (status == "PARAM_ERROR") {
            $('#errorMsg').html(msg).show()
        }
    });


</script>