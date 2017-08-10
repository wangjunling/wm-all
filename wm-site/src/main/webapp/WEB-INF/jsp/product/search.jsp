<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.easycai.com/functions" prefix="dyCafn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- end/slide -->
<c:set var="len" value="${fn:length(searchCondition.categoryAttributeMap)}"/>
<input type="hidden" id="brandId" value=""/>
<c:forEach var="ca" items="${searchCondition.categoryAttributeMap}" varStatus="status">
    <input type="hidden" id="categoryAttr_${status.index}" value=""/>
</c:forEach>
<input type="hidden" id="categoryId" value=""/>
<input type="hidden" id="keyWord" value=""/>

<div class="wcont navibg">
    <div class="bdWrp">
        <div class="navibar clearfix">
            <a class="navilk fl" href="/home.htm"> 首页 </a>
            <i class="icnarrow fl"> </i>
            <c:forEach var="cr" items="${crumbsList}" varStatus="vs">
                <c:if test="${vs.index < (fn:length(crumbsList) - 1)}">
                    <a class="navilk fl" href="/product/search.htm?categoryId=${cr.categoryId}"> ${cr.name} </a>
                    <i class="icnarrow fl"> </i>
                </c:if>
                <c:if test="${vs.index == (fn:length(crumbsList) - 1)}">
                    <a class="navitxt fl" href="/product/search.htm?categoryId=${cr.categoryId}"> ${cr.name} </a>
                </c:if>
            </c:forEach>
            <%--<a class="navilk fl" href="list.html"> 室内精品 </a>--%>
            <%--<i class="icnarrow fl"> </i>--%>
            <%--<span class="navitxt fl"> 开关插座 </span>--%>
        </div>
    </div>
</div>

<div class="wcont">
    <div class="bdWrp">
        <div class="mucontbg clearfix">
            <div class="lmenubg fl">

                <div id="leftmubg">
                    <c:forEach var="caTree" items="${categoryTree.categoryNodes}">
                        <div class="leftmutit">
                                ${caTree.name}
                        </div>
                        <div class="sidebar" id="m_left">
                            <div id="accordion">
                                <c:forEach var="secondCaTree" items="${caTree.categoryNodes}">
                                    <h3> ${secondCaTree.name} </h3>

                                    <div class="content" style="display: none;">
                                        <ul class="leftmenu clearfix">
                                            <c:forEach var="threeTree" items="${secondCaTree.categoryNodes}">
                                                <li <c:if test="${param.categoryId == threeTree.id}">class="current"</c:if>><a class="lists"
                                                                                                                               href="/product/search.htm?categoryId=${threeTree.id}"
                                                                                                                               name="threeCategory_${threeTree.id}"> ${threeTree.name} </a>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="rcontbg fr">
                <div class="catebg">
                    <div class="catewrp <c:if test="${fn:length(searchCondition.categoryAttributeMap) == 0}">last</c:if> clearfix">
                        <div class="catetab fl"> 品牌</div>
                        <div class="catebox fl">
                            <c:choose>
                                <c:when test="${param.brandId == '' || param.brandId == null}">
                                    <a class="catelk catelked" id="brand_unlimited" name="conditionBrand" value=""> 不限</a>
                                </c:when>
                                <c:otherwise>
                                    <a class="catelk" id="brand_unlimited" name="conditionBrand" value=""> 不限</a>
                                </c:otherwise>
                            </c:choose>
                            <c:forEach var="brand" items="${searchCondition.brandList}">
                                <c:choose>
                                    <c:when test="${param.brandId == brand.id}">
                                        <a id="brand_${brand.id}" name="conditionBrand" class="catelk catelked"
                                           value="${brand.id}"> ${brand.name} </a>
                                    </c:when>
                                    <c:otherwise>
                                        <a id="brand_${brand.id}" name="conditionBrand" class="catelk" value="${brand.id}"> ${brand.name} </a>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </div>
                    </div>


                    <c:forEach var="ca" items="${searchCondition.categoryAttributeMap}" varStatus="status">
                    <c:choose>
                    <c:when test="${status.index == len - 1}">
                    <div class="catewrp last clearfix">
                        </c:when>
                        <c:otherwise>
                        <div class="catewrp clearfix">
                            </c:otherwise>
                            </c:choose>
                            <div class="catetab fl"> ${ca.key} </div>
                            <div class="catebox fl">
                                <c:choose>
                                    <c:when test="${dyCafn:caIdsContainReqParam(ca.value, param.attributeIds)}">
                                        <a class="catelk" name="conditionAttr_${status.index}" value=""> 不限</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="catelk catelked" name="conditionAttr_${status.index}" value=""> 不限</a>
                                    </c:otherwise>
                                </c:choose>

                                <c:forEach var="caItem" items="${ca.value}">
                                    <c:choose>
                                        <c:when test="${dyCafn:caReqParamContainEachId(caItem.id,param.attributeIds)}">
                                            <a id="caItem_${caItem.id}" name="conditionAttr_${status.index}" class="catelk catelked"
                                               value="${caItem.id}"> ${caItem.val} </a>
                                        </c:when>
                                        <c:otherwise>
                                            <a id="caItem_${caItem.id}" name="conditionAttr_${status.index}" class="catelk"
                                               value="${caItem.id}"> ${caItem.val} </a>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                    <!-- end/catebox -->

                    <div class="listtit clearfix">
                        <div class="sorttit fl"> 排序</div>
                        <a class="sortlk fl" name="orderColumn" value="view_count"> 人气 </a>
                        <a class="sortlk fl" name="orderColumn" value="sales"> 销量 </a>
                    </div>
                    <!-- end/listtit -->

                    <div class="goodsbox clearfix">
                        <c:choose>
                            <c:when test="${fn:length(searchResult.searchDetailList) > 0}">
                                <c:forEach var="sd" items="${searchResult.searchDetailList}">
                                    <div class="goodsbg fl" value="/product/toDetail.htm?productId=${sd.productId}">
                                        <div class="search-pic">
                                            <img src="${sd.mainImageUrl}" width="180" height="180" name="imgUrl"
                                                 address="/product/toDetail.htm?productId=${sd.productId}"/>
                                        </div>
                                        <div class="gdstxt" address="/product/toDetail.htm?productId=${sd.productId}"
                                             style="overflow:hidden; white-space:nowrap; text-overflow:ellipsis;"> ${sd.productName} </div>
                                        <a class="btncart" address="${sd.productId}"> 加入采购单 </a>
                                    </div>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <div style="margin: 20px auto 0 auto;text-align: center;"><img src="/resources/images/searchFail.jpg"></div>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div class="pagesbox" id="pager">
                        ${dyCafn:renderPageList(pager)}
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="graycont">

    </div>
</div>
<!-- end/cont -->

<script type="text/javascript" src="/resources/js/search.js"></script>
