<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/taglib/taglibs.jsp" %>

<div class="rcontbg fr">
    <div class="newtabs proftab">
        <div class="nav">
            <ul class="left-nav">
                <li><a href="javascript:void(0)" class="curtab"> 我的采购单 </a></li>
            </ul>
        </div>
        <div class="searchbar">
            <div class="selt fl">
                <select class="prof_selt" id="state">
                    <option selected="selected" value=""> 所有 </option>
                    <option value="submit"> 已提交</option>
                    <option value="approved"> 审核通过</option>
                    <option value="unapproved"> 审核拒绝</option>
                    <option value="quote"> 已报价</option>
                    <option value="contract"> 合同已签订</option>
                    <option value="complete"> 完成</option>
                </select>
            </div>
            <input class="iptsech fl" type="text" id="orderId" name="id" placeholder="订单id"> <a class="btn fl btnsearch" style="width: 80px;" id="search"> 查  询 </a>
        </div>
        <div class="addrwrp">
            <table cellpadding="0" cellspacing="1" class="addrtable ordertab">
                <thead>
                <tr>
                    <th width="30%"> 采购单编号</th>
                    <th width="15%"> 收货人</th>
                    <th width="15%"> 订单金额</th>
                    <th width="20%"> 创建时间</th>
                    <th width="15%"> 订单状态</th>
                    <th width="10%"> 操作</th>
                </tr>
                </thead>
                <tbody>
                <%--订单内容--%>
                </tbody>
            </table>

            <div id="emptyDiv" style="display: none">没有找到订单</div>
            <div class="pagesbox" id="pageDiv">
                <a class="pagelk dispage wzpage"> <i class="prearw"> </i> 上一页 </a>
                <a class="pagelk curpage"> 1 </a>
                <a class="pagelk"> 2 </a>
                <a class="pagelk"> 3 </a>
                <span class="pagemore"> ... </span>
                <a class="pagelk"> 24 </a>
                <a class="pagelk wzpage"> 下一页 <i class="nxtarw"> </i> </a>
            </div>

        </div>

    </div>
    <!-- end/proftab -->

</div>

<script type="text/javascript" src="/resources/js/plugins/laypage/laypage.js"></script>
<script type="text/javascript" src="/resources/js/app/order.js"></script>
<script type="text/javascript">
    var leftMenuName = "order";
</script>