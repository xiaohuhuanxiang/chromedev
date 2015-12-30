function getCurIp(){	
	$.ajax({
		url:"http://www.ip38.com/",
		type:"GET",
		dataType: "text",
		async:true,				
		timeout: 1e4,		
		success:function(data, t, jqXHR){	
//<LI>您的本机IP地址：
//    111.12.126.16    &nbsp;&nbsp;来自：</strong><span id="ipad"> 稍等,查询中.... </span></LI>	
			var reg=/您的本机IP地址：\s.*?(\d*\.\d*\.\d*\.\d*)/;
			var result=reg.exec(data);
			console.log(result[0]);
			console.log(result[1]);			
			
			curIp=result[1];
			//alert(curIp);
			if(result[1]!=undefined){
				console.log('成功获取本机ip');
			}else{
				
			}
			$('body').append("<br>外网ip为："+curIp);
		},
		error:function( jqXHR, textStatus, errorThrown) {			
			alert(textStatus);
			alert(jqXHR.status);
			//setTimeout(getCurIp,5000);
		}
	});
}

$(document).ready(function(){
	getCurIp();
	chrome.extension.sendMessage({cmd: "getNewsArr"},function(response) {
		if(response.arr){
			var len=response.arr.length;
			for(var i=0;i<len;i++){
				$('body').append("<br>"+response.arr[i]+'<br>');
			}
		}
	});//
	
});