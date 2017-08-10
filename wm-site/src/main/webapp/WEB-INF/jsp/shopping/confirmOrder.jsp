  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ page language="java" pageEncoding="UTF-8" %>
    <div class="graycont">

    <div class="bdWrp">

    <div class="mcontbg clearfix">

    <div class="alcontbg">
    <div class="newtabs">
    <div class="nav">
    <ul class="left-nav">
    <li><a href="javascript:void(0)" class="curtab"> 选择收货地址 </a></li>
    </ul>
    <a href="#" class="new-add"  id="toAddBtn"> 新增收货地址 </a>
    </div>

    <ul class="addrbox" id="addressListBox">
    <c:forEach var="ba" items="${buyerAddressDtoList}" varStatus="vs">
      <li>
      <div class="addrbg clearfix">
      <c:choose>
        <c:when test="${vs.index == 0}">
          <div class="addrtit curaddr fl" name="selectAddress" value="${ba.id}"> 默认地址 <i class="iconcuraddr"></i> </div>
        </c:when>
        <c:otherwise>
          <div class="addrtit fl" name="selectAddress" value="${ba.id}"> 其他地址 </div>
        </c:otherwise>
      </c:choose>
      <div class="addrname ellipsis fl"> <c:out value="${ba.name}"/> </div>
      <c:choose>
        <c:when test="${fn:length(ba.receiveAddress) > 35}">
          <div class="addrtxt ellipsis fl" title="<c:out value="${ba.receiveAddress}"/>">${fn:substring(ba.receiveAddress, 0, 35)}....</div>
        </c:when>
        <c:otherwise>
          <div class="addrtxt ellipsis fl"> <c:out value="${ba.receiveAddress}"/></div>
        </c:otherwise>
      </c:choose>
      <div class="addrphone fl"> <c:out value="${ba.telephone}"/> </div>
        <c:choose>
          <c:when test="${vs.index == 0}">
            <a class="addrcurlk fl" value="${ba.id}" name="defaultAddressHref" style="visibility: hidden;"> 设为默认地址 </a>
          </c:when>
          <c:otherwise>
            <a class="addrcurlk fl" value="${ba.id}" name="defaultAddressHref"> 设为默认地址 </a>
          </c:otherwise>
        </c:choose>
      <a class="addrlk fl" data-toggle="modal" name="toEditBtn" value="${ba.id}"> 编辑 </a>
      <a class="addrlk fl" name="toDeleteBtn" value="${ba.id}"> 删除 </a>
      </div>
      </li>
    </c:forEach>
    </ul>

    <div class="contitle">
    <span class="moreaddr" id="moreAddress" style="cursor: pointer"> 更多地址 </span>
    <span id="hideMoreAddress" style="cursor: pointer; display:none;"> 隐藏地址 <i class="hide-moreaddr"></i></span>
    </div>
    <div class="nav">
    <ul class="left-nav">
    <li><a href="javascript:void(0)" class="curtab"> 采购单清单 </a></li>
    </ul>
    </div>

    <div class="odrswrp">
    <table cellpadding="0" cellspacing="1" class="addrtable ordertab" id="confirmOrderProductList">
    <tbody><tr>
    <th width="5%"> <input type="checkbox" class="cekbox" name="selectAllProduct"> </th>
    <th width="12%"> 商品图片 </th> <th width="24%"> 商品名称 </th>
    <th width="10%"> 价格 </th> <th width="16%"> 交易数量 </th>
    <th width="25%"> 型号/规格属性 </th> <th width="8%"> 操作 </th>
    </tr>

    <c:forEach var="sc" items="${shoppingCartProductDetailList}">
      <tr>
      <td> <input type="checkbox" class="cekbox" value="${sc.productId}" name="checkBoxProduct"> </td>
      <td> <img src="${sc.mainImageUrl}" class="gdspic" width="40"> </td>
      <td> <div class="gdtabtxt"> ${sc.productName}</div></td>
      <td> 面议 </td>
      <td> <div class="gdtabnumb"> <a class="numadd fl" name="downQuantity"> - </a> <input type="text" class="gdnumbs fl" name="quantity" id="quantity_${sc.productId}" value="${sc.quantity}"> <a class="nummenus fl" name="upQuantity"> + </a> </div> </td>
      <td> <textarea class="tabarea" id="remark_${sc.productId}" name="remark" placeholder="选填，最多可输入100个字"></textarea>  </td><td> <a class="oprt" name="removeProduct" value="${sc.productId}"> 删除 </a> </td>
      </tr>
    </c:forEach>


    </tbody></table>
    </div>
    <div class="ordtabbtm">
    <table cellpadding="0" cellspacing="0" class="ordbmtab">
    <tbody><tr>
    <td width="5%"> <input type="checkbox" class="cekbox" name="selectAllProduct"> </td>
    <td width="5%" align="left"> 全选 </td>
    <td width="14%"><a class="tablk" id="remoceAllProduct"> 删除所有商品 </a> </td>
    <td width="56%"><textarea class="tabtarea  order-textarea" id="allRemark" placeholder="选填，最多可输入100个字"></textarea></td>
    <td width="30%">
    <a class="btnsmit" data-toggle="modal" id="submitOrder"> 提交采购单 </a>
    </td>
    </tr>
    </tbody></table>
    </div>

    </div> <!-- end/proftab -->
    </div>  <!-- end/rcontbg -->

    </div>

    </div>  <!-- end/bdWrp -->

    </div>


    <div id="popupform" style="display:none;" class="modal-wrap in">
    <a href="#shut" class="close" data-dismiss="modal">  ×  </a>
    <div class="modal-body popform">
    <div class="infoform clearfix">
    <div class="formtit fl"> <span class="clorgn"> 新增收货地址 </span> </div>
    <div class="formlcont fl">
    电话号码、手机号选填一项，其余为必填项，收货地址最多保存10个
    </div>
    </div>
    <form id="addressForm">
    <input type="hidden" name="id">
    <div class="infoform clearfix">
    <div class="formtit fl"> 公司注册地址 </div>
    <div class="formlcont fl">
    <select class="addrslt fl" name="provinceCode" id="provinceSelect">
    </select>
    <select class="addrslt fl" name="cityCode" id="citySelect">
    </select>
    <select class="addrslt fl" name="areaCode" id="areaSelect">
    </select>
    </div>

    </div>

    <div class="infoform clearfix">
    <div class="formtit fl"> 详细地址 </div>
    <div class="formcont fl">
    <input type="text" class="profipt" name="address" id="address">
    </div>
    </div>

    <div class="infoform clearfix">
    <div class="formtit fl"> 邮政编码 </div>
    <div class="formcont fl">
    <input type="text" class="profipt" name="zipCode" id="zipCode">
    </div>
    </div>
    <div class="infoform clearfix">
    <div class="formtit fl"> 收件人姓名 </div>
    <div class="formcont fl">
    <input type="text" class="profipt" name="name" id="name">
    </div>
    </div>
    <div class="infoform clearfix">
    <div class="formtit fl"> 手机号码 </div>
    <div class="formcont fl">
    <input type="text" class="profipt" name="telephone" id="telephone">
    </div>
    </div>
    <div class="infoform clearfix">
    <div class="formtit fl"> 电话号码 </div>
    <div class="formcont fl">
    <input type="text" class="profipt" name="phone" id="phone">
    </div>
    </div>


    <div class="infoform clearfix">
    <div class="formtit fl"> &nbsp; </div>
    <div class="formcont fl">
    <a class="btnpopup" id="submitBtn"> 立即保存 </a>
    </div>
    </div>
    </form>
    </div> <!--end modal-body-->
    </div>

    <div id="popupok" style="display:none;" class="modal-wrapsmall">
    <a href="#shut" class="close" data-dismiss="modal">  ×  </a>
    <div class="modal-body">

    <div class="poptit"> 恭喜你，采购意向单提交成功，<br> 审核通过会有客服人员联系您！</div>
    <div class="popuptxt" id="time">
    </div>
    <div class="btnsbox clearfix">
    <a class="btn-blue btn btnok" data-dismiss="modal" id="autoLink"> 手动跳转 </a>
    </div>
    </div> <!--end modal-body-->
    </div>
    <script type="text/javascript"
    src="/resources/js/plugins/validate/jquery.validate.min.js"></script>
    <script type="text/javascript"
    src="/resources/js/plugins/validate/messages_zh.min.js"></script>
    <script type="text/javascript"
    src="/resources/js/plugins/jquery-select.js"></script>
    <script type="text/javascript" src="/resources/js/confirmOrder.js"></script>