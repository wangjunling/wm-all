/**
 * Created by chengpanwang on 7/13/15.
 */

(function ($) {

    $.select = function (option) {
        install(option);
    };

    function install(option) {
        var defaultOption = {
            url: '',
            selectId: '',
            parentId: '',
            initText: '请选择',
            initValue: '',
            selectedValue: '',
            valuePropertyName: "code",
            textPropertyName: 'name'
        };

        $.extend(defaultOption, option);
        initSelect(defaultOption);
    }

    function hasParent(defaultOption) {
        return defaultOption.parentId != null && $.trim(defaultOption.parentId) != '';
    }

    function refresh(defaultOption, data, isSelected) {
        var select = $(defaultOption.selectId);
        //用于清空间隔一级以上的select值
        select.val('');
        select.change();
        var option = '<option value="' + defaultOption.initValue + '">' + defaultOption.initText + '</option>';
        select.empty().append(option);

        if ((defaultOption.parentId == null || $.trim(defaultOption.parentId) == '') || ((defaultOption.parentId != null && $.trim(defaultOption.parentId) != '') && (data!=null && $.trim(data)!={}) )) {
            var url = defaultOption.url;

            if (data!=null && $.trim(data)!={}) {
                url = url + data;
            }

            $.ajax({
                url: url,
                type: 'get',
                dataType: 'json',
                async:false,
                success: function (data) {
                    $.each(data.data, function (k, v) {
                        if (isSelected && defaultOption.selectedValue == v[defaultOption.valuePropertyName]) {
                            option = '<option value="' + v[defaultOption.valuePropertyName] + '" selected="selected">'
                                + v[defaultOption.textPropertyName] + '</option>';
                        } else {
                            option = '<option value="' + v[defaultOption.valuePropertyName] + '">'
                                + v[defaultOption.textPropertyName] + '</option>';
                        }
                        select.append(option);
                    });
                }
            });
        }
    }

    function initSelect(defaultOption) {
        var select = $(defaultOption.selectId);
        var option = '<option value="' + defaultOption.initValue + '">' + defaultOption.initText + '</option>';
        select.empty().append(option);
        var data = {};
        if (hasParent(defaultOption)) {
            data = $(defaultOption.parentId).val();
            $(defaultOption.parentId).change(function () {
          
                data = $(defaultOption.parentId).val();
                refresh(defaultOption, data, false);
            });
        }
        refresh(defaultOption, data, true);
    }
})(jQuery);
