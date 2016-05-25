$(function(){
    // control-mode. control for top and side mode (fixed or normal), you can remove it if you want..
    var control_mode = '<div class="control-mode" id="control-mode">'
    +'    <ul class="choice-mode grd-teal corner-bl hide">'
    +'        <li><a id="normal-mode" href="#normal-mode">返回</a></li>'
    +'        <li><a id="fixedtop-mode" href="#fixedtop-mode">全屏</a></li>'
    +'        <li><a id="fixedside-mode" href="#fixedside-mode">缩小</a></li>'
    +'        <li><a id="fixedsideonly-mode" href="#fixedsideonly-mode">隐藏</a></li>'
    +'    </ul>'
    +'    <div class="navigate-mode"><a href="#" class="grd-teal corner-bottom" style=" background-color:#00a0b1;"><i>设置</i></a></div>'
    +'</div>';
    
    $('body').append(control_mode)
    if(sessionStorage.mode == undefined){
        sessionStorage.mode = 1;
    }
    
    $('#control-mode > .navigate-mode').click(function(e){
        $('#control-mode > .choice-mode').slideToggle(); // toggle slide hide
        
        return false;
    });
    $('html').on('click', function(){
        $('#control-mode > .choice-mode').slideUp(); // toggle slide hide
    });
    $('#normal-mode').click(function(){
        $('.header, .side-left, .side-right').removeClass('fixed');
        
        // set position by default
        $('.header').css({
            'top' : '0px'
        });
        $('.side-left, .side-right').css({
            'top' : '60px'
        });
        
        $('#control-mode > .choice-mode').slideToggle(); // toggle slide hide
        
        sessionStorage.mode = 1;
        return false;
    });
    $('#fixedtop-mode').click(function(){
        $('.header, .side-left, .side-right').removeClass('fixed'); // remove first to normalize class
        $('.header').addClass('fixed');
        
        // set position by default
        $('.header').css({
            'top' : '0px'
        });
        $('.side-left, .side-right').css({
            'top' : '60px'
        });
        
        $('#control-mode > .choice-mode').slideToggle(); // toggle slide hide
        
        sessionStorage.mode = 2;
        return false;
    });
    $('#fixedside-mode').click(function(){
        $('.header, .side-left, .side-right').removeClass('fixed'); // remove first to normalize class
        $('.header, .side-left, .side-right').addClass('fixed');
        
        // set position by default
        $('.header').css({
            'top' : '0px'
        });
        
        $('.side-left, .side-right').css({
            'top' : '60px'
        });
        
        $('#control-mode > .choice-mode').slideToggle(); // toggle slide hide
        
        sessionStorage.mode = 3;
        return false;
    });
    $('#fixedsideonly-mode').click(function(){
        $('.header, .side-left, .side-right').removeClass('fixed'); // remove first to normalize class
        $('.side-left, .side-right').addClass('fixed');
        
        // set position by default
        if($(window).scrollTop() > 60){
            $('.side-left, .side-right').css({
                'top' : '0px'
            });
        }
            
        $('#control-mode > .choice-mode').slideToggle(); // toggle slide hide
        
        sessionStorage.mode = 4;
        return false;
    });
    
    if(sessionStorage.mode){
        if(sessionStorage.mode == '1'){ // normal mode
            $('.header, .side-left, .side-right').removeClass('fixed');
        }
        if(sessionStorage.mode == '2'){ // fixed header only
            $('.header, .side-left, .side-right').removeClass('fixed'); // remove first to normalize class
            $('.header').addClass('fixed');
        }
        if(sessionStorage.mode == '3'){ // fixed all
            $('.header, .side-left, .side-right').removeClass('fixed'); // remove first to normalize class
            $('.header, .side-left, .side-right').addClass('fixed')
        }
        if(sessionStorage.mode == '4'){ // fixed side only
            $('.header, .side-left, .side-right').removeClass('fixed'); // remove first to normalize class
            $('.side-left, .side-right').addClass('fixed');
        }
        
        // help for responsive
        if(sessionStorage.mode == 4){
            // control for responsive
            if($(window).width() > 767){
                data_scroll = 60 - parseInt($(this).scrollTop());
                $('.side-left, .side-right').css({
                    'top' : data_scroll+'px'
                });
                $('body, html').animate({
                    scrollTop : 0
                })
            }
            else{
                $('.side-left, .side-right').css({
                    'top' : '0px'
                });
            }
        }
        else{
            if($(window).width() <= 767){
                $('.side-left, .side-right').css({
                    'top' : '0px'
                });
            }
            else{
                $('.side-left, .side-right').css({
                    'top' : '60px'
                });
            }
        }
    }
    
    // end control-mode
    
    
    

    
    
})
