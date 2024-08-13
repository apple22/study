$(document).ready(function(){
    includeHTML(); // Include HTML content
    
    $(document).on('mouseenter', 'ul.gnb_ul li', function() {
        var dataN = $(this).find('a').data('n');
        
        // 현재 a 태그 색상을 변경
        //$(this).find('a').css('color', '#cf0032');
        
        // 나머지 a 태그 색상을 white로 변경
        $('ul.gnb_ul li a').not($(this).find('a')).css('color', 'white');
        
        // 드롭다운 메뉴와 스팬을 애니메이트 및 표시
        var currentUl = $('.dropdown_nav ul[data-n="' + dataN + '"]');
        var currentSpan = $('.gnb ul li span[data-n="' + dataN + '"]');
        
        // 다른 스팬 요소 숨기기
        $('.gnb ul li span').not(currentSpan).css('display', 'none');
        // 드롭다운 메뉴 애니메이트 및 표시
        currentUl.stop(true, true).addClass('on').css('overflow', 'visible').animate({
            height: '100%'
        });

        // 현재 스팬 표시
       // currentSpan.css('display', 'block');
        // 나머지 드롭다운 메뉴를 숨김
        $('.dropdown_nav ul').not(currentUl).stop(true, true).animate({
            height: 0
        }, function() {
            $(this).css('overflow', 'hidden');
        });
    });

    $(document).on('mouseleave', '.dropdown_nav ul', function() {
        // 마우스가 드롭다운 메뉴를 떠날 때, 메뉴를 닫고 색상을 초기화
        $(this).stop(true, true).animate({
            height: 0
        }, function() {
            $(this).css('overflow', 'hidden');
            // 모든 li a의 색상을 white로 변경
            $('ul.gnb_ul li a').css('color', 'white');
            // 모든 스팬 요소를 숨김
            $('.gnb ul li span').css('display', 'none');
        });
    });
});
