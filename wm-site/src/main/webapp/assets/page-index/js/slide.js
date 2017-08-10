//banner
var element = $('#slide');
var curr = 0;
var slideItem = element.find('[data-role=slide-item]');
var imglen = slideItem.length;
var bannerBtn = '';
for(var i = 0; i < imglen; i++){
    bannerBtn += '<a href="javascript:;"></a>';
}
element.find('[data-role=slide-trigger]').html(bannerBtn);

var triggerList = element.find('[data-role=slide-trigger] a');
triggerList.eq(0).addClass("current");

triggerList.each(function(i) {
    var el = $(this);
    el.click(function() {
        if(!slideItem.is(":animated")) {
            this.blur();
            curr = i;
            slideItem.eq(i).css("z-index", "10").siblings("[data-role=slide-item]").css("z-index", "1");
            slideItem.eq(i).fadeIn(1000).siblings("[data-role=slide-item]").fadeOut(1000);
            el.siblings("a").removeClass("current").end().addClass("current");
        }
        else {
            return false;
        }
    });
});

var timer = setInterval(function() {
    todo = (curr + 1) % imglen;
    triggerList.eq(todo).click();
}, 5000);

triggerList.hover(function() {
        clearInterval(timer);
    },
    function() {
        timer = setInterval(function() {
            todo = (curr + 1) % imglen;
            triggerList.eq(todo).click();
        }, 5000);
    }
);