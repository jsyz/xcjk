jQuery(function(){
//选项卡滑动切换通用
jQuery(function(){jQuery(".hoverTag .chgBtn").hover(function(){jQuery(this).parent().find(".chgBtn").removeClass("chgCutBtn");jQuery(this).addClass("chgCutBtn");var cutNum=jQuery(this).parent().find(".chgBtn").index(this);jQuery(this).parents(".hoverTag").find(".chgCon").hide();jQuery(this).parents(".hoverTag").find(".chgCon").eq(cutNum).show();})})

//选项卡点击切换通用
jQuery(function(){jQuery(".clickTag .chgBtn").click(function(){jQuery(this).parent().find(".chgBtn").removeClass("chgCutBtn");jQuery(this).addClass("chgCutBtn");var cutNum=jQuery(this).parent().find(".chgBtn").index(this);jQuery(this).parents(".clickTag").find(".chgCon").hide();jQuery(this).parents(".clickTag").find(".chgCon").eq(cutNum).show();})})

//图库弹出层
$(".mskeLayBg").height($(document).height());
$(".mskeClaose").click(function(){$(".mskeLayBg,.mskelayBox").hide()});
$(".msKeimgBox li").click(function(){$(".mske_html").html($(this).find(".hidden").html());$(".mskeLayBg").show();$(".mskelayBox").fadeIn(300)});
$(".mskeTogBtn").click(function(){$(".msKeimgBox").toggleClass("msKeimgBox2");$(this).toggleClass("mskeTogBtn2")});

 var params = location.search.substr(1); 
	
 var pid = params.substring(params.indexOf('=')+1,params.length);
	
 var numbers = "";
 var size = 0;
 $.ajax({   
           url:'getCamerasByProjectID',//这里是你的action或者servlert的路径地址   
           type:'get', //数据发送方式   
           dataType:'json', //接受数据格式 (这里有很多,常用的有html,xml,js,json)  
           data:{"pid":pid},
           async:false,
           error: function(msg)
           { //失败  
           },   
           success: function(msg)
           { //成功 
            if(msg!=null)
            {
            	numbers = msg.numbers;
            	size = msg.size;
            	type = msg.carrieroperatorType;
            }
           }  
         });
         
$("#videoURL").attr("href","videos.html?numbers="+numbers+"&size="+size+"&type="+type);
$("#iframepage").attr('src',"videos.html?numbers="+numbers+"&size="+size+"&type="+type); 

});




//屏蔽页面错误
jQuery(window).error(function(){
  return true;
});
jQuery("img").error(function(){
  $(this).hide();
});





