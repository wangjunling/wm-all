var stepItems = $('.step-item');
var stepTriggerItem = $('.step-trigger-item');

stepTriggerItem.on('mouseenter', function(ev){
    var idx = $(ev.currentTarget).index();

    stepItems.eq(idx).show().siblings().hide();
});
