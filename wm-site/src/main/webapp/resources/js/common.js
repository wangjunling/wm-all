/**
 * Created by chengpanwang on 6/26/15.
 */
//编码
function escapeHtml(str) {
    vars = "";
    if (str.length == 0)return "";
    s = str.replace(/&/g, "&amp;");  //1
    s = s.replace(/</g, "&lt;");
    s = s.replace(/>/g, "&gt;");
    s = s.replace(/ /g, "&nbsp;");
    s = s.replace(/\'/g, "&#39;");
    s = s.replace(/\"/g, "&quot;");
    s = s.replace(/\n/g, "<br>");
    return s;
}

//解码
function unEscapeHtml(str) {
    var s = "";
    if (str.length == 0) return "";
    s = str.replace(/&amp;/g, "&");   //2
    s = s.replace(/&lt;/g, "<");
    s = s.replace(/&gt;/g, ">");
    s = s.replace(/&nbsp;/g, "");
    s = s.replace(/&#39;/g, "\'");
    s = s.replace(/&quot;/g, "\"");
    s = s.replace(/<br>/g, "\n");
    returns;
}

function isBlank(str) {
    return str == null || $.trim(str) == '';
}

function getCsrfToken() {
    return Cookies.get('csrf_token')
}

var getUrlParameter = function (sParam) {
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) {
            return sParameterName[1];
        }
    }
}

/**
 * 统一弹出提示框
 * @param msg
 */
function showMsg(msg) {

    if ($('#__popupform').length == 0) {
        var div = '<!-----------------  Modal  -------------->' +
            '<div id="__popupform" style="display:none;" class="modal-wrapsmall">' +
            '<a href="#shut" class="close" data-dismiss="modal" style="z-index: 1">  &times;  </a>' +
            '<div class="modal-body" style="text-align: center;">' +
            '<div class="poptit"> 恭喜您已经成功注册为众才网会员 </div>' +
                /*'<div class="popuptxt">' +
                 '页面将在5秒后跳转！' +
                 '</div>' +*/
            '<div class="btnsbox clearfix">' +
            '<a class="btn-blue btn btnok" data-dismiss="modal"> 关闭 </a>' +
            '</div>' +
            '</div> <!--end modal-body-->' +
            '</div> <!--end modal-wrapsmall-->' +
            '<!-------------- End/Modal------------------>';

        $('body').append(div);
    }

    $('#__popupform .poptit').html(msg);
    $('#__popupform').modal('show');
}

/**
 * 确认弹出框
 * @param msg
 * @param ok
 * @param cancle
 */
function confirmMsg(msg, okFunc, closeFunc) {

    if ($('#popupConfirm').length == 0) {
        var div = '<!-----------------  Modal  -------------->' +
            '<div id="popupConfirm" style="display:none;" class="modal-wrapsmall">' +
            '<a href="#shut" class="close" data-dismiss="modal" style="z-index: 1">  &times;  </a>' +
            '<div class="modal-body" >' +
            '<div class="poptit"> 恭喜您已经成功注册为众才网会员 </div>' +
                /*'<div class="popuptxt">' +
                 '页面将在5秒后跳转！' +
                 '</div>' +*/
            '<div class="btnsbox clearfix">' +
            '<a class="btn-blue btn" style="width: 60px;margin-right: 15px;" data-dismiss="modal" id="popupOk"> 确定 </a>' +
            '<a class="btn-blue btn " style="width: 60px;" data-dismiss="modal" id="popupClose"> 取消 </a>' +
            '</div>' +
            '</div> <!--end modal-body-->' +
            '</div> <!--end modal-wrapsmall-->' +
            '<!-------------- End/Modal------------------>';

        $('body').append(div);

    }

    $('#popupOk').unbind().click(function () {
        if (typeof okFunc != 'undefined') {
            okFunc();
        }
    });
    $('#popupClose').unbind().click(function () {
        if (typeof closeFunc != 'undefined') {
            closeFunc();
        }
    });


    $('#popupConfirm .poptit').html(msg);
    $('#popupConfirm').modal('show');
}


var _timeWait;
/**
 * 倒计时
 * @param wait
 * @param callback
 */
function timeout(wait, callback) {
    _timeWait = wait;

    innerTimeOut(callback);
}

function innerTimeOut(callback) {
    if (_timeWait == 0) {
        callback(_timeWait);
    } else {
        setTimeout(function () {
            _timeWait--;
            callback(_timeWait);
            innerTimeOut();
        }, 1000)
    }
}

$(document).ajaxSuccess(function(event, xhr, settings) {

    try {
        var json = $.parseJSON(xhr.responseText);
        if (json.status == "NO_LOGIN") {
            location.href=json.data;
        }

    } catch (e) {
    }
});

$(document).ajaxSend(function(evt, request, settings){
    var method = settings.type;
    if (method == undefined) {
        return;
    }

    if ('get' == settings.type.toLowerCase()) {

    }
});

