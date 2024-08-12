$(document).ready(function(){
    includeHTML(); // Include HTML content
    $(document).on('mouseenter', 'ul.gnb_ul li', function() {
        var dataN = $(this).find('a').data('n');
        $(this).find('a').css('color', '#cf0032');
        var currentUl = $('.dropdown_nav ul[data-n="' + dataN + '"]');
        currentUl.stop(true, true).addClass('on').css('overflow', 'visible').animate({
            height: '100%'
        });
        $('.dropdown_nav ul').not(currentUl).stop(true, true).animate({
            height: 0
        }, function() {
            $(this).css('overflow', 'hidden');
        });
    });
    $(document).on('mouseleave', '.dropdown_nav ul', function() {
        $(this).stop(true, true).animate({
            height: 0
        }, function() {
            $(this).css('overflow', 'hidden');
        });
    });
});
