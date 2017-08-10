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
        <form id="form" name="form" action="/register.htm" method="post">
            <div class="registbg clearfix">
                <div class="logtit"> 会员注册</div>
                <div class="infoform clearfix">
                    <div class="formtit fl"> 用户名</div>
                    <div class="formcont fl">
                        <input type="text" class="profipt" name="account" id="account" value="${buyer.account}"/>
                    </div>
                    <div class="formhint fl" style="display: none;">
                        清填写公司英文名称（如有英文名称请填写）
                    </div>
                </div>
                <div class="infoform clearfix">
                    <div class="formtit fl"> 联系人姓名</div>
                    <div class="formcont fl">
                        <input type="text" class="profipt" name="contact" value="${buyer.contact}"/>
                    </div>
                    <div class="formhint fl" style="display: none;">
                        清填写公司英文名称（如有英文名称请填写）
                    </div>
                </div>
                <div class="infoform clearfix">
                    <div class="formtit fl"> 设置密码</div>
                    <div class="formcont fl">
                        <input type="password" class="profipt" name="password" id="password" value="${buyer.password}"/>
                    </div>
                    <div class="formhint fl" style="display: none;">
                        清填写公司
                    </div>
                </div>
                <div class="infoform clearfix">
                    <div class="formtit fl"> 确认密码</div>
                    <div class="formcont fl">
                        <input type="password" class="profipt" name="passwordR"/>
                    </div>
                    <div class="formhint fl" style="display: none;">
                        清填写公司
                    </div>
                </div>
                <div class="infoform clearfix">
                    <div class="formtit fl"> 电子邮箱</div>
                    <div class="formcont fl">
                        <input type="text" class="profipt" name="email" value="${buyer.email}"/>
                    </div>
                    <div class="formhint fl" style="display: none;">
                        清填写公司
                    </div>
                </div>
                <div class="infoform clearfix">
                    <div class="formtit fl"> 手机号码</div>
                    <div class="formcont fl">
                        <input type="text" class="profipt" name="phone" id="phone" value="${buyer.phone}"/>
                    </div>
                    <div class="formhint fl" style="display: none;">
                        清填写公司
                    </div>
                </div>
                <div class="logverfbg clearfix">
                    <div class="formtit fl"> 短信验证码</div>
                    <div class="formcont fl">
                        <input type="text" placeholder="验证码" class="iptverf fl" name="phoneSecCodeKey" value="${buyer.phoneSecCodeKey}"/>
                        <%--<a class="verflk fl" id="sendSecCode"> &lt;%&ndash;重新发送(60)&ndash;%&gt; 发送手机验证码 </a>--%>
                        <div class="btn btnipt" id="sendSecCode"> 发送手机验证码</div>
                    </div>
                    <div class="formhint fl" style="display: none;">
                        清填写公司
                    </div>
                </div>
                <div class="logverfbg clearfix">
                    <div class="formtit fl">&nbsp; </div>
                    <a class="btnregst fl" id="submit"> 立即注册 </a>
                </div>
            </div>
        </form>
    </div>
    <!-- end/bdWrp -->

</div>
<!-- end/graycont -->


<script type="text/javascript" src="/resources/js/plugins/validator/jquery.validate.min.js"></script>
<script type="text/javascript" src="/resources/js/plugins/validator/custom_additional_methods.js"></script>
<script type="text/javascript" src="/resources/js/plugins/validator/messages_zh.min.js"></script>
<script type="text/javascript">
    var status = '${status}';
    var msg = '${msg}';


    $(document).ready(function () {

        $('#submit').click(function () {
            if ($('#form').validate().form()) {
                $('#form').submit();
            } else {
                validator.focusInvalid();
            }
        });
        $('body').on('keydown', function (e) {
            var code = e.which;
            if (code == 13) {
                if ($('#form').validate().form()) {
                    $('#form').submit();
                } else {
                    validator.focusInvalid();
                }
            }
        });

        initValidator();

        // 发送手机验证码
        $('#sendSecCode').click(function () {

            if($('#sendSecCode').hasClass("disabled")) {
                return;
            }
            $('#sendSecCode').addClass('disabled');

            if ($('#form').validate().element($(':input[name=phone]'))) {
                var phone = $(':input[name=phone]').val();
                $.getJSON('/buyer/sendSecMsg.json', {"phone": phone}, function (data) {
                    if (data.status == "OK") {
                        _timeWait = 60;
                        timeout();
                    } else {
                        $('#sendSecCode').removeClass('disabled');
                    }
                });
            } else {
                validator.focusInvalid();
            }
        });

        if (status == "PARAM_ERROR") {
            showMsg(msg);
        }
    });

    _timeWait = 60;
    function timeout() {
        if (_timeWait == 0) {
            $('#sendSecCode').html("发送手机验证码").removeClass('disabled');
        } else {
            setTimeout(function () {
                $('#sendSecCode').html("重新发送( " + _timeWait + " )");

                _timeWait--;
                timeout();
            }, 1000)
        }
    }


    function initValidator() {
        // validate the form when it is submitted
        validator = $("#form").validate({
//            debug: true,
            errorPlacement: function (error, element) {
                // 显示错误信息
                var msg = $(element).parent().next('div');
                if ($.isEmptyObject(msg) || msg.size() == 0) {
                    msg = $(element).parent().parent().next('div');
                }
                msg.html(error.text()).show();
            },
            // 校验成功后处理
            success: function (label, element) {
                var msg = $(element).parent().next('div');
                if ($.isEmptyObject(msg) || msg.size() == 0) {
                    msg = $(element).parent().parent().next('div');
                }
                msg.html("").hide();
            },
            rules: {
                account: {
                    required: true,
                    maxlength: 30,
                    uniqueAccount:true
                },
                contact: {
                    required: true,
                    maxlength: 30

                },
                password: {
                    required: true
                },
                passwordR: {
                    required: true,
                    equalTo: "#password"
                },
                email: {
                    required: true,
                    email: true
                },
                phone: {
                    required: true,
                    mobileChina: true,
                    uniquePhone:true
                },
                phoneSecCodeKey: {
                    required: true
                }
            }
        });
    }

    $.validator.addMethod('uniqueAccount', function(value) {
        var isSuccess = false;
        $.ajax({
            type: 'post',
            url: '/buyer/checkAccount.json',
            data: 'account=' + value,
            async: false,
            success: function(data) {
                if(data.status == 'OK') {
                    isSuccess = true;
                }
            }
        });
        return isSuccess;
    }, '用户名已存在！');
    $.validator.addMethod('uniquePhone', function(value) {
        var isSuccess = false;
        $.ajax({
            type: 'post',
            url: '/buyer/checkPhone.json',
            data: 'phone=' + value,
            async: false,
            success: function(data) {
                if(data.status == 'OK') {
                    isSuccess = true;
                }
                return false;
            }
        });
        return isSuccess;
    }, '手机号已存在！');

</script>