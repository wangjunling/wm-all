<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/taglib/taglibs.jsp" %>

<!-- end/slide -->

<style>
    #addressForm div.error {
        width: 150px;
        line-height: 20px;
        padding: 4px 10px;
        color: #999;
        background-color: #f5f5f5;
        border: 1px #efefef solid;
        font-size: 13px;
        float: left;
    }
</style>


<div class="rcontbg fr">
    <div class="newtabs proftab" id="aaaaa">
        <div class="nav">
            <ul class="left-nav">
                <li><a href="javascript:void(0)" class="curtab"> 收货地址 </a></li>
            </ul>
        </div>
        <div class="tabcontainer">
            <div class="sub-con cur-sub-con">
                <div class="infoform clearfix">
                    <div class="formtit clorgn fl">新增收货地址</div>
                    <div class="formcont fl" style="width: 480px;">
                        <span class="formtxt"> 电话号码、手机号选填一项，其余为必填项，收货地址最多保存10个 </span>
                    </div>
                </div>
                <form id="addressForm">
                    <input type="hidden" name="id"/>

                    <div class="infoform clearfix">
                        <div class="formtit fl">所在地区</div>
                        <div class="formlcont fl">
                            <select class="addrslt fl" id="provinceSelect"
                                    name="provinceCode">
                                <option selected="selected">北京市</option>
                                <option>上海市</option>
                                <option>安徽省</option>
                                <option>浙江省</option>
                            </select> <select class="addrslt fl" id="citySelect" name="cityCode">
                            <option selected="selected">北京市</option>
                            <option>上海市</option>
                            <option>安徽省</option>
                            <option>浙江省</option>
                        </select> <select class="addrslt fl" id="areaSelect" name="areaCode">
                            <option selected="selected">浦东新区</option>
                            <option>徐汇区</option>
                            <option>静安区</option>
                            <option>卢湾区</option>
                        </select>
                        </div>
                    </div>

                    <div class="infoform clearfix">
                        <div class="formtit fl">详细地址</div>
                        <div class="formcont fl">
                            <textarea class="prof_area" id="detailAddress" name="address"> </textarea>
                        </div>
                    </div>
                    <div class="infoform clearfix">
                        <div class="formtit fl">邮政编码</div>
                        <div class="formcont fl">
                            <input type="text" class="profipt" id="zipCode" name="zipCode"/>
                        </div>
                    </div>
                    <div class="infoform clearfix">
                        <div class="formtit fl">收货人姓名</div>
                        <div class="formcont fl">
                            <input type="text" class="profipt" id="name" name="name"/>
                        </div>
                    </div>
                    <div class="infoform clearfix">
                        <div class="formtit fl">手机号码</div>
                        <div class="formcont fl">
                            <input type="text" class="profipt" id="telephone"
                                   name="telephone"/>
                        </div>
                    </div>
                    <div class="infoform clearfix">
                        <div class="formtit fl">电话号码</div>
                        <div class="formcont fl">
                            <input type="text" class="profipt" id="phone" name="phone"/>
                        </div>
                    </div>

                    <div class="infoform clearfix">
                        <div class="formtit fl">&nbsp;</div>
                        <div class="formcont fl">
                            <a class="btnsubmit" id="submitBtn"> 立即提交 </a>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div class="addrwrp">
            <div class="addrhistit">已保存的收货地址(最多可保存10个)</div>
            <table cellpadding="0" cellspacing="1" class="addrtable"
                   id="addressTable">
                <thead>
                <tr>
                    <th width="15%">收货人</th>
                    <th width="20%">所在地区</th>
                    <th width="30%">详细地址</th>
                    <th width="10%">邮编</th>
                    <th width="15%">联系方式</th>
                    <th width="10%">操作</th>
                </tr>
                </thead>


            </table>

        </div>

    </div>
    <!-- end/proftab -->

</div>
<!-- end/rcontbg -->

<!-- end/bdWrp -->

<!-- end/graycont -->


<script type="text/javascript"
        src="/resources/js/plugins/dataTables/jquery.dataTables.js"></script>

<script type="text/javascript" src="/resources/js/common.js"></script>
<script type="text/javascript" src="/resources/js/shippingAddress.js"></script>
<script type="text/javascript"
        src="/resources/js/plugins/validate/jquery.validate.min.js"></script>
<script type="text/javascript"
        src="/resources/js/plugins/validate/messages_zh.min.js"></script>
<script type="text/javascript"
        src="/resources/js/plugins/jquery-select.js"></script>
<script type="text/javascript">

    var leftMenuName = "address";
</script>
