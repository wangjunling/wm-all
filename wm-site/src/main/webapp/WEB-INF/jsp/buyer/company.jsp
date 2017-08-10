<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/taglib/taglibs.jsp" %>




<!-- end/slide -->

<div class="graycont">
    <form id="form" action="/buyer/company.htm" method="post">
    <div class="bdWrp">
        <div class="comptithint"> 恭喜您成为众才网体验会员，请完善企业资料信息 </div>
        <div class="compregistbg clearfix">
            <div class="logtit"> 公司注册 </div>
            <div class="infoform clearfix">
                <div class="formtit fl"> 公司中文名称 </div>
                <div class="formcont fl">
                    <input type="text" class="profipt" name="chineseName" value='<c:out value="${buyer.chineseName}"/>'/>
                </div>
                <div class="formhint fl" style="display: none;">
                    清填写公司英文名称（如有英文名称请填写）
                </div>
            </div>
            <div class="infoform clearfix">
                <div class="formtit fl"> 公司英文名称 </div>
                <div class="formcont fl">
                    <input type="text" class="profipt" name="englishName" value="<c:out value='${buyer.englishName}'/>"/>
                </div>
                <div class="formhint fl" style="display: none;">
                    清填写公司英文名称（如有英文名称请填写）
                </div>
            </div>
            <div class="infoform clearfix">
                <div class="formtit fl"> 公司电话 </div>
                <div class="formcont fl">
                    <input type="text" class="profipt" name="telephone" value="<c:out value='${buyer.telephone}' />"/>
                </div>
                <div class="formhint fl" style="display: none;">
                    清填写公司
                </div>
            </div>
            <div class="infoform clearfix">
                <div class="formtit fl"> 公司传真 </div>
                <div class="formcont fl">
                    <input type="text" class="profipt" name="fax" value="<c:out value='${buyer.fax}'/>" maxlength="20"/>
                </div>
                <div class="formhint fl" style="display: none;">
                    清填写公司
                </div>
            </div>
            <div class="infoform clearfix">
                <div class="formtit fl"> 营业执照注册号 </div>
                <div class="formcont fl">
                    <input type="text" class="profipt" name="businessLicenseNumber" value="<c:out value='${buyer.businessLicenseNumber}'/>"/>
                </div>
                <div class="formhint fl" style="display: none;">
                    清填写公司
                </div>
            </div>
            <div class="infoform clearfix">
                <div class="formtit fl"> 营业执照有效期类型</div>
                <div class="formcont fl">
                    <select class="addrslt fl" id="businessLicenseValidType" name="businessLicenseValidType">
                        <option value="date"> 截止日期</option>
                        <option value="forever"> 永久有效</option>
                    </select>
                </div>
                <div class="formhint fl" style="display: none">
                    请填写公司
                </div>
            </div>

            <div class="infoform clearfix" id="businessLicenseValidDateDiv">
                <div class="formtit fl"> 营业执照有效期 </div>
                <div class="formcont fl">
                    <input type="text" class="profipt" name="businessLicenseValidDate" id="businessLicenseValidDate" readonly
                           value='<fmt:formatDate value="${buyer.businessLicenseValidDate}" type="both" pattern="yyyy-MM-dd"/>'/>
                </div>
                <div class="formhint fl" style="display: none;">
                    清填写公司
                </div>
            </div>
            <div class="infoform clearfix">
                <div class="formtit fl"> 公司税籍编号 </div>
                <div class="formcont fl">
                    <input type="text" class="profipt" name="taxRegistrationNumber" value="<c:out value='${buyer.taxRegistrationNumber}'/>"/>
                </div>
                <div class="formhint fl" style="display: none;">
                    清填写公司
                </div>
            </div>
            <div class="infoform clearfix">
                <div class="formtit fl"> 公司注册资金 </div>
                <div class="formcont fl">
                    <div class="iptwrp clearfix">
                        <input type="text" class="profmipt fl" name="registeredCapital" value="<c:out value='${buyer.registeredCapital}'/>"/>
                        <span class="ipttxt fl"> 万元 RMB </span>
                    </div>
                </div>
                <div class="formhint fl" style="display: none;">
                    清填写公司
                </div>
            </div>
            <div class="infoform clearfix">
                <div class="formtit fl"> 公司注册地址</div>
                <div class="formlcont fl">
                    <select class="addrslt fl" id="provinceSelect" name="provinceCode">
                        <option selected="selected"> 北京市</option>
                    </select>
                    <select class="addrslt fl" id="citySelect" name="cityCode">
                        <option selected="selected"> 北京市</option>
                    </select>
                    <select class="addrslt fl" id="areaSelect" name="areaCode">
                        <option selected="selected"> 浦东新区</option>
                    </select>
                </div>
            </div>

            <div class="infoform clearfix">
                <div class="formtit fl"> 详细地址 </div>
                <div class="formcont fl">
                    <input type="text" class="profipt" name="address" value="<c:out value='${buyer.address}' />"/>
                </div>
                <div class="formhint fl" style="display: none;">
                    清填写公司
                </div>
            </div>

            <div class="infoform clearfix">
                <div class="formtit fl"> 公司营业执照</div>
                <div class="formcont fl">
                    <div class="iptwrp clearfix">
                        <input type="text" class="profmipt fl" name="businessLicenseUrlTemp" readonly/>
                        <input type="hidden" class="profmipt fl" name="businessLicenseUrl"
                               value='<c:out value="${buyer.businessLicenseUrl}" escapeXml="false"/>'/>
                        <a class="btn btnipt fr"> 删除 </a>

                        <div id="uploader-businessLicenseUrl">
                            <div> 上传</div>
                        </div>
                    </div>
                    <%--缩络图--%>
                    <div class=""></div>
                </div>
                <div class="formhint fl" style="display: none;">
                    <%--请填写公司--%>
                </div>
            </div>

            <div class="infoform clearfix">
                <div class="formtit fl"> 税务登记证</div>
                <div class="formcont fl">
                    <div class="iptwrp clearfix">
                        <input type="text" class="profmipt fl" name="taxRegistrationUrlTemp" readonly/>
                        <input type="hidden" class="profmipt fl" name="taxRegistrationUrl"
                               value='<c:out value="${buyer.taxRegistrationUrl}" escapeXml="false"/>'/>
                        <a class="btn btnipt fr"> 删除 </a>

                        <div id="uploader-taxRegistrationUrl">
                            <div id="filePicker"> 上传</div>
                        </div>
                    </div>

                    <div class=""></div>
                </div>
                <div class="formhint fl" style="display: none;">
                    <%--请填写公司--%>
                </div>
            </div>

            <div class="infoform clearfix">
                <div class="formtit fl"> 一般纳税人资格证</div>
                <div class="formcont fl">
                    <div class="iptwrp clearfix">
                        <input type="text" class="profmipt fl" name="taxCertificateUrlTemp" readonly/>
                        <input type="hidden" class="profmipt fl" name="taxCertificateUrl"
                               value='<c:out value="${buyer.taxCertificateUrl}" escapeXml="false"/>'/>
                        <a class="btn btnipt fr"> 删除 </a>

                        <div id="uploader-taxCertificateUrl">
                            <div> 上传</div>
                        </div>
                    </div>
                    <%--缩络图--%>
                    <div class=""></div>
                </div>
                <div class="formhint fl" style="display: none;">
                    <%--请填写公司--%>
                </div>
            </div>

            <div class="infoform clearfix">
                <div class="formtit fl">
                    &nbsp;
                </div>
                <div class="formcont fl">
                    <a class="btnsubmit" data-toggle="modal" href="#popupform" id="submit"> 立即提交 </a>
                </div>
                <a class="btncreg fl" id="cancle"> 以后再说 </a>
            </div>

        </div>

    </div>  <!-- end/bdWrp -->
    </form>
</div>  <!-- end/graycont -->


<!-----------------  Modal  -------------->
<div id="popupform" style="display:none;" class="modal-wrapsmall">
    <a href="#shut" class="close" data-dismiss="modal" style="z-index: 1">  &times;  </a>
    <div class="modal-body">

        <div class="poptit"> 恭喜您已经成功注册为众才网会员 </div>
        <div class="popuptxt">
            页面将在5秒后跳转！
        </div>
        <div class="btnsbox clearfix">
            <a class="btn-blue btn btnok" data-dismiss="modal"> 手动跳转 </a>
        </div>
    </div> <!--end modal-body-->
</div> <!--end modal-wrapsmall-->
<!-------------- End/Modal------------------>


<link rel="stylesheet" type="text/css" href="/resources/webuploader/webuploader.css">
<script type="text/javascript" src="/resources/webuploader/webuploader.js"></script>
<script type="text/javascript" src="/resources/js/plugins/jquery-select.js"></script>
<script type="text/javascript" src="/resources/js/plugins/validator/jquery.validate.min.js"></script>
<script type="text/javascript" src="/resources/js/plugins/validator/custom_additional_methods.js"></script>
<script type="text/javascript" src="/resources/js/plugins/validator/messages_zh.min.js"></script>
<script type="text/javascript" src="/resources/js/plugins/laydate/laydate.js"></script>
<script type="text/javascript" src="/resources/js/jq-modal.js"></script>
<script type="text/javascript" src="/resources/js/app/company.js"></script>
<script type="text/javascript">
    // 营业执照有效期类型
    var businessLicenseValidType = '${buyer.businessLicenseValidType}';
    var provinceCode = '${buyer.provinceCode}';
    var cityCode = '${buyer.cityCode}';
    var areaCode = '${buyer.areaCode}';
    var fullBusinessLicenseUrl = '${buyer.fullBusinessLicenseUrl}';
    var fullTaxRegistrationUrl = '${buyer.fullTaxRegistrationUrl}';
    var fullTaxCertificateUrl = '${buyer.fullTaxCertificateUrl}';
    var businessLicenseValidDate = '<fmt:formatDate value="${buyer.businessLicenseValidDate}" type="both" pattern="yyyy-MM-dd"/>';
    var status = "${status}";

</script>
