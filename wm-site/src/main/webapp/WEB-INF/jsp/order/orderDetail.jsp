<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<div class="rcontbg fr">
    <div class="newtabs proftab">
        <div class="nav">
            <ul class="left-nav">
                <li><a href="javascript:void(0)" class="curtab"> 采购单详情 </a></li>
            </ul>
        </div>

        <div class="ordstep">
            <table class="steptab" width="100%" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td width="129" align="left"   <c:if test="${fn:length(orderDto.orderStateChangeList) == 1}"> class="curstep" </c:if>><span
                            class="steptit"> 提交订单 </span></td>
                    <c:choose>
                        <c:when test="${hasRefused == true}">
                            <td width="189" align="center" <c:if
                                    test="${fn:length(orderDto.orderStateChangeList) == 2}"> class="curstep" </c:if>><span
                                    class="steptit"> 审核拒绝 </span></td>
                        </c:when>
                        <c:otherwise>
                            <td width="189" align="center" <c:if
                                    test="${fn:length(orderDto.orderStateChangeList) == 2}"> class="curstep" </c:if>><span
                                    class="steptit"> 审核通过 </span></td>
                        </c:otherwise>
                    </c:choose>
                    <td width="206" align="center" <c:if test="${fn:length(orderDto.orderStateChangeList) == 3}"> class="curstep" </c:if>><span
                            class="steptit">已报价 </span></td>
                    <td width="189" align="center" <c:if test="${fn:length(orderDto.orderStateChangeList) == 4}"> class="curstep" </c:if>><span
                            class="steptit">合同签订 </span></td>
                    <td align="right" width="129"  <c:if test="${fn:length(orderDto.orderStateChangeList) == 5}"> class="curstep" </c:if>><span
                            class="steptit stepyig"> 完成</span></td>
                </tr>
                <tr>
                    <td colspan="5">
                        <div class="stepbg curstep${fn:length(orderDto.orderStateChangeList)}"></div>
                    </td>
                </tr>
                <tr>
                    <c:forEach var="oc" items="${orderDto.orderStateChangeList}" varStatus="vs">
                        <td align="center"
                            <c:if test="${fn:length(orderDto.orderStateChangeList) == (vs.index + 1)}">class="curstep"</c:if>> ${oc.createTime} </td>
                    </c:forEach>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="ordbg clearfix">
            <div class="ordleft fl">
                <div class="orderbg clearfix">
                    <div class="ordertit fl"> 订单编号</div>
                    <div class="ordertxt fl"> ${orderDto.id} </div>
                </div>
                <div class="orderbg clearfix">
                    <div class="ordertit fl"> 订单状态</div>
                    <div class="ordertxt fl"> ${orderDto.stateText} </div>
                </div>
            </div>
            <div class="ordrigt fr">
                <div class="orderbg clearfix">
                    <div class="ordertit fl"> 采购人信息</div>
                </div>
                <div class="orderbg clearfix">
                    <div class="ordrigtit fl"> 采购人</div>
                    <div class="ordrigtxt fl"> ${orderDto.orderAddressDto.name} </div>
                </div>
                <div class="orderbg clearfix">
                    <div class="ordrigtit fl"> 收货地址</div>
                    <c:choose>
                        <c:when test="${fn:length(orderDto.orderAddressDto.receiveAddress) > 35}">
                            <div class="ordrigtxt fl"> ${fn:substring(orderDto.orderAddressDto.receiveAddress, 0, 35)}....</div>
                        </c:when>
                        <c:otherwise>
                            <div class="ordrigtxt fl"> ${orderDto.orderAddressDto.receiveAddress} </div>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="orderbg clearfix">
                    <div class="ordrigtit fl"> 联系方式</div>
                    <div class="ordrigtxt fl">${orderDto.orderAddressDto.contactNo}</div>
                </div>
            </div>
        </div>

        <div class="addrwrp">
            <table cellpadding="0" cellspacing="1" class="addrtable ordertab">
                <tbody>
                <tr>
                    <th width="20%"> 商品编号</th>
                    <th width="15%"> 商品图片</th>
                    <th width="25%"> 商品名称</th>
                    <th width="18%"> 价格</th>
                    <th width="12%"> 交易数量</th>
                    <th width="10%"> 交易合同</th>
                </tr>

                <c:forEach var="so" items="${orderDto.subOrderList}">
                    <tr>
                        <td> ${so.num} </td>
                        <td><img src="${so.mainImageUrl}" class="gdpic" width="40"></td>
                        <td><a href="/product/toDetail.htm?productId=${so.productId}">${so.name}</a></td>
                        <td><span class="clorgn"> ${so.amount} </span></td>
                        <td> ${so.quantity} </td>
                        <td>
                            <c:choose>
                                <c:when test="${so.buyerContractDto != null}">
                                    <a class="oprt" href="/file/downLoad.json?${so.buyerContractDto.fullFileUrl}"> 下载 </a>
                                </c:when>
                                <c:otherwise>
                                    <a class="oprt"> 合同未上传 </a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <div class="tabbtm clearfix">
                <div class="orderbg fr clearfix">
                    <div class="ordertit fl"> 采购单总金额:</div>
                    <div class="ordertxt fl"> ${orderDto.totalPrice} </div>
                </div>
            </div>

        </div>

    </div>
    <!-- end/proftab -->

</div>
<!-- end/rcontbg -->
<script type="text/javascript">
    var leftMenuName = "order";
</script>
