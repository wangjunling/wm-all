function getUrlParameter(sParam) {
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) {
            return sParameterName[1];
        }
    }
}
$('[name="keyWord"]').val(decodeURI(getUrlParameter('keyWord') || ''));

$('body').on('keydown', function (e) {
    var code = e.which;
    if (code == 13) {
        var keyWord = $.trim($('[name="keyWord"]').val());
        if (keyWord) {
            location.href = '/product/search.htm?keyWord=' + encodeURI(keyWord);
        }
    }
});
$('#searchBtn').on('click', function () {
    var keyWord = $.trim($('[name="keyWord"]').val());
    if (keyWord) {
        location.href = '/product/search.htm?keyWord=' + encodeURI(keyWord);
    }
});

$('#shoppongCartBtn').on('click ', function () {
    $('[name="productList"]').remove();
    $.ajax({
        dataType: 'json',
        type: 'post',
        url: '/sc/scProductList.json',
        success: function (data, r, xhr) {
            if (data.status == 'OK') {
                var list = data.data;
                if (list != undefined && list.length >= 1) {
                    $('#cartTips').html('<a class="btn-blue btn btnpquit" href="/shopping/confirmOrder.htm"> 提交采购单 </a>');
                    for (var i in list) {
                        var product = list[i];
                        var li = '<li name="productList">'
                            + '<div class="poplinebg clearfix">'
                            + '<div class="poppic fl"> <img src="' + product.mainImageUrl + '" width="48"/> </div>'
                            + '<div class="fl popgdtxt">'
                            + '<h3> ' + product.productName + ' </h3>'
                            + '<p>  </p>'
                            + '</div>'
                            + '<a class="popdel fl">  </a>'
                            + '<div class="popnumbbg fl">'
                            + product.quantity
                            + '</div>'
                            + '</div>'
                            + '</li>';
                        $('#submitLi').before(li);
                    }
                } else {
                    $('#cartTips').html('<div class="" style="color: #5d5d5d;font-size: 16px;text-align: center;vertical-align: middle;">还没有商品</div>');
                }
            } else {
                $('#cartTips').html('<div class="" style="color: #5d5d5d;font-size: 16px;text-align: center;vertical-align: middle;">还没有商品</div>');
            }
        }
    });
});

$.ajax({
    dataType: 'json',
    type: 'post',
    url: '/category/categoryTree.json',
    success: function (data, r, xhr) {
        if (data.status == 'OK') {
            var categoryArr = data.data;

            for (var indexOne in categoryArr) {
                var categoryOne = categoryArr[indexOne];
                var target = $('#target-id-' + categoryOne.id);
                if (target.length <= 0) {
                    continue;
                }
                var spanSubmuwrp = $('<span>').addClass("submuwrp");
                spanSubmuwrp.append('<div style="height: 45px;"></div>');
                var spanSubmulist = $('<span>').addClass('submulist').appendTo($('<span>').addClass("submubg").appendTo(spanSubmuwrp));
                var levelTwo = categoryOne.categoryNodes;
                for (var indexTwo in levelTwo) {

                    var categoryTwo = levelTwo[indexTwo];
                    var spanSumuline = $('<span>').addClass('sumuline clearfix').append(
                        $('<a>', {'class': 'smutit', 'text': categoryTwo.name, 'href': '/product/search.htm?brandId=&categoryId=' + categoryTwo.id}));
                    spanSumuline.appendTo(spanSubmulist);

                    var spanSmutxtbg = $('<span>').addClass('smutxtbg clearfix').appendTo(spanSumuline);
                    var levelThree = categoryTwo.categoryNodes;
                    for (var indexThree in levelThree) {
                        var categoryThree = levelThree[indexThree];
                        spanSmutxtbg.append($('<span>', {'class': 'smutxt'}).append(
                            $('<a>', {
                                'style': 'color:#000;',
                                'text': categoryThree.name,
                                'href': '/product/search.htm?brandId=&categoryId=' + categoryThree.id
                            })));
                    }

                }
                target.after(spanSubmuwrp);
            }

            afterCategory();

        } else if (data.status == 'ERROR') {

        }
    }


});


$('#homeHeader').click(function () {
    window.location.href = '/';

});


function afterCategory() {
    $('.menulink').each(function (i, v) {
        if ($(v).children('span').size() < 1) {
            $(v).removeClass("menulink").addClass('menulink-none').find('a').append('<i class="i-expect" style="display: none;"></i>')
                .attr('href', "#").addClass("disabled").mouseover(function(){$(this).find('i').show();})
            .mouseout(function(){ $(this).find('i').hide(); });

        }
    });
}