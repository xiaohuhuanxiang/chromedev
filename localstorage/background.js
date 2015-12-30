function getCurIp(){	
	$.ajax({
		url:"http://www.ip38.com/",
		type:"GET",
		dataType: "text",
		async:false,				
		timeout: 1e4,		
		success:function(data, t, jqXHR){	
//<LI>您的本机IP地址：
//    111.12.126.16    &nbsp;&nbsp;来自：</strong><span id="ipad"> 稍等,查询中.... </span></LI>	
			var reg=/您的本机IP地址：\s.*?(\d*\.\d*\.\d*\.\d*)/;
			var result=reg.exec(data);
			console.log(result[0]);
			console.log(result[1]);
			
			console.log('成功获取本机ip');
			curIp=result[1];
			alert(curIp);
			if(result[1]!=undefined){
				
			}else{
				clearTimeout(getCurIp);
				setTimeout(getCurIp,5000);
			}			
		},
		error:function( jqXHR, textStatus, errorThrown) {
			console.log("Disconnect error");
			console.log(textStatus)
			console.log(jqXHR.status)
			clearTimeout(getCurIp);
			alert(textStatus);
			alert(jqXHR.status);
			//setTimeout(getCurIp,5000);
		}
	});
}
var g_newsArr=null;
$(document).ready(function(){
	//getCurIp();
	try{
	g_newsArr=JSON.parse(''+localStorage['newsArr']);// background.html 页面的localStorage['newsArr']内容
	}catch(c){}
	chrome.extension.onMessage.addListener(function(request, sender, sendResponse) {
		if(request.cmd=='setNewsArr'){
			console.log(request.arr)
			g_newsArr=request.arr;
			localStorage['newsArr']=JSON.stringify(g_newsArr);
		}else if(request.cmd=='getNewsArr'){
			sendResponse({'arr':g_newsArr});
		}
	})
});
chrome.windows.onRemoved.addListener(function (windowId){
		console.log('ddd');
});
