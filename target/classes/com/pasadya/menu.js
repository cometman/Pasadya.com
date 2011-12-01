$(document).ready(function(){

    //When mouse rolls over
      $("#shop").mouseover(function(){
        $(this).stop().animate({height:'270px'},{queue:false, duration:600, easing: 'easeOutBounce'})
    });
    
    $("#about").mouseover(function(){
        $(this).stop().animate({height:'150px'},{queue:false, duration:600, easing: 'easeOutBounce'})
    });

    $("#portfolio").mouseover(function(){
        $(this).stop().animate({height:'150px'},{queue:false, duration:600, easing: 'easeOutBounce'})
    });

    //When mouse is removed
    $("li").mouseout(function(){
        $(this).stop().animate({height:'50px'},{queue:false, duration:600, easing: 'easeOutBounce'})
    });

  
});