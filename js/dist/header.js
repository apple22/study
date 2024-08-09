$(document).ready(function(){
    includeHTML(); // Include HTML content

    // 이벤트 핸들러는 includeHTML 호출 이후에 설정해야 함
    $(document).on('click', 'ul.gnb_ul', function() {
        alert("hi");
    });
});