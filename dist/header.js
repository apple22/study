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
    });/*mouseleave*/


    var flag = 0; // 함수 외부에 flag 변수 선언
  


    $(document).on('click', '.select_down', function() {
        var imgurl = "../image/image_14.png";
        
        $("#img_form_url").attr("src", imgurl);

        if(flag === 0){
            $(".select_over").stop().animate({
                height: 70
            });

            flag = 1; // flag 값을 1로 변경
        } else if(flag === 1){
            $(document).on('click', '.en', function() {
                $('.lang').text('EN');
            });

            $(document).on('click', '.kr', function() {
                $('.lang').text('KR');
            });


            var imgurl_a = "../image/image_05.png";
            $("#img_form_url").attr("src", imgurl_a);
            $(".select_over").stop().animate({
                height: 0
            });


            flag = 0; // flag 값을 다시 0으로 변경
        }
        console.log(flag);
    });/*select_down*/


    $(document).on('click', '.hamburgur_menu', function() {
          

    });/*hamburgur*/


    $(document).on('mouseenter', '.select_over span', function() {
           target = $(this);
           $(this).css('background-color', '#EBEFF8');
           $('.select_over span').not($(this)).css('background-color', 'transparent');
    });


});


