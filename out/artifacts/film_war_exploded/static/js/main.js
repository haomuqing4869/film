$(document).ready(function(){//文章加载更多
  $("#seemore").click(function(){  	
  		$("#seemore").hide();
  		$("#more_article").show();  	     
});

//头部搜索
  $("#search").click(function(){
  			//后台代码
			$.ajax({
				type:"post",
				url:"http://localhost:8080/ssm_model_war_exploded/movies/select",
				data:{"name":$("#invalue").val()},
				success:function(response){
					console.log("1111111111111")
				},
				error:function () {
					console.log("1111111111111")
				}
			});
});

//$("#invalue").blur(function(){
//if($("#invalue").val().length==0){
//		
//	    $("#invalue").hide();  }
//});

//G友的下拉框与选中时间
  $("#xiala").click(function(){	
  	if($("#kuang").is(':visible')){ 
  	    $("#kuang").hide();  	  	
  	}else{  		
  		 $("#kuang").show();
  }  	     
});


 $("#right_xiala").click(function(){	
  	if($("#right_kuang").is(':visible')){ 
  	    $("#right_kuang").hide();  	  	
  	}else{  		
  		 $("#right_kuang").show();
  }  	     
});

 $("#kuang li").click(function(){	  	 

 $("#xl_input").val($(this).text());
 $("#kuang").hide();  	
 
});


 $("#right_kuang li").click(function(){	  	 

 $("#rightxl_input").val($(this).text());
 $("#right_kuang").hide();  	
 
});


//文章内页  点赞背景图改变
//$("#user_info_head1").click(function(this){
//	this.sibling().re
//	
//});
//用户个人中心


$("#userinfo_head1").click(function(){
	$("#userinfo_head1").addClass("currenthead");
		$("#userinfo_head2").removeClass("currenthead");
//	$("#userinfo_head1").	
   $("#block1").show();
	$("#block2").hide();
});

$("#userinfo_head2").click(function(){
		$("#userinfo_head2").addClass("currenthead");
		$("#userinfo_head1").removeClass("currenthead");
//	$("#userinfo_head1").	
  $("#block1").hide();
   $("#block2").show();
  
	
});


 });  
   
  // 
   
   
   //文章内页出现回复框评论
function com_thumb(obj){
	 $(obj).empty();

var divshow=$(obj).parent().parent().children(":last") ;

   	if(divshow.is(':visible')){ 
	   $(obj).append("<img src='img/main/com_thumb.png'/>");  
	   
	   divshow.hide();
	}else{  			 
	   $(obj).append('<img src="img/main/com_thumb1.png" />');  
	   divshow.show();
}  	
	 
	 }

//我的消息回复框
function user_com_thumb(obj){
	
 
var divshow=$(obj).parent().parent().parent().children(":last") ;

   	if(divshow.is(':visible')){ 
	   
	   
	   divshow.hide();
	}else{  			 
	  
	   divshow.show();
}  	
	
	
	
}
//评论点赞
function com_zan(obj){	
  $(obj).empty();

	   $(obj).append("<img src='img/main/com_zan1.png'/>&nbsp;645");  

}

