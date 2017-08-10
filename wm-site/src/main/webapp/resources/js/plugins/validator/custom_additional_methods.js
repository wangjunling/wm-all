//护照编号验证
jQuery.validator.addMethod("passport", function (value, element) {
    return this.optional(element) || checknumber(value);
}, "请正确输入您的护照编号");

// 手机号码验证
jQuery.validator.addMethod("mobileChina", function (value, element) {
    value= $.trim(value);
    var length = value.length;
    var mobile = /^((1[2-9]\d)+\d{8})$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "请输入手机号码:1xxxxxxxxxx");

// 电话号码验证
jQuery.validator.addMethod("telChina", function (value, element) {
    var tel = /^(\d{3,4}-?)?\d{7,8}$/; //电话号码格式010?-12345678 或 0216636521
    return this.optional(element) || (tel.test(value));
}, "请输入正确的电话号码xxx-xxxxxxx");

// 邮政编码验证
jQuery.validator.addMethod("zipChina", function (value, element) {
    var tel = /^[0-9]{6}$/;
    return this.optional(element) || (tel.test(value));
}, "请输入正确的邮政编码");
//正则表达式验证
jQuery.validator.addMethod("pattern", function (value, element, param) {
    if(this.optional(element)) {
        return true;
    }
    if(typeof param === 'string') {
        param = new RegExp('^(?:' + param + ')$');
    }
    return param.test(value);
}, "格式不正确");


jQuery.validator.addMethod("exactlength", function (value, element, param) {
    return this.optional(element) || value.length == param;
}, $.validator.format("最多输入{0}个字符"));
//真实姓名
jQuery.validator.addMethod("realname", function (value, element, param) {
    return this.optional(element) || value.length<=20;
}, $.validator.format("请输入真实姓名"));

//身份证号码验证
jQuery.validator.addMethod("identifycard", function (code, element, param) {
    code = (code||'').toUpperCase();
    var city = {11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江 ", 31: "上海", 32: "江苏", 33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北 ", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川", 52: "贵州", 53: "云南", 54: "西藏 ", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外 "};
    var pass = true;
    if(!code || !/^\d{15}(\d{2}[0-9X])?$/i.test(code)) {
        pass = false;
    }
    else if(!city[code.substr(0, 2)]) {
        pass = false;
    }
    else {
        //18位身份证需要验证最后一位校验位
        if(code.length == 18) {
            code = code.split('');
            //∑(ai×Wi)(mod 11)
            //加权因子
            var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
            //校验位
            var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
            var sum = 0;
            var ai = 0;
            var wi = 0;
            for (var i = 0; i < 17; i++) {
                ai = code[i];
                wi = factor[i];
                sum += ai * wi;
            }
            if(parity[sum % 11] != code[17]) {
                pass = false;
            }
        }
    }
    return this.optional(element) || pass;
}, $.validator.format("请输入正确的身份证号"));

