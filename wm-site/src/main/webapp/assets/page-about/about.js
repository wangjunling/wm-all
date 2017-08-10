/**
 * Created by chengpanwang on 8/18/15.
 */

$(document).ready(function () {
    $(":text").focus(function () {
        $(this).parent().addClass('focus');
    }).blur(function () {
        $(this).parent().removeClass('focus');
        $(this).parent().removeClass('wrong');
    });

    $('textarea').focus(function () {
        $(this).addClass('textarea-focus');
    }).blur(function () {
        $(this).removeClass('textarea-focus');
        $(this).removeClass('textarea-wrong');
    });

    $('[type="button"].btn').click(function(){
        var self = $(this);

        if($('#name').val() == '') {
            $('#name').parent().addClass('wrong');
            return;
        }
        if(! /1\d{10}/.test($('#phone').val()) ) {
            $('#phone').parent().addClass('wrong');
            return;
        }

        if ($('#email').val() != '' && !/.+\@.+\.\w{1,3}/.test($('#email').val())) {
            $('#email').parent().addClass('wrong');
            return;
        }

        if($('#content').val() == '') {
            $('#content').addClass('textarea-wrong');
            return;
        }


        $(this).val('');
        $(this).addClass('loading');
        self.attr('disabled', 'disabled');

        $.getJSON('/feedback.json',$('#feedbackForm').serialize(), function(data){

            self.removeAttr('disabled');
            self.removeClass('loading');

            if (data != undefined && data.status=="OK") {
                self.val('提交成功');

                $(':text').val('');
                $('textarea').val('');

            } else {
                self.addClass('btn-wrong');
                self.val('提交失败');
            }


        });
    });
});