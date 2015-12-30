function getCSDNNews(){
	var alist=$('.news_list ul li a');
	var len=alist.length;
	var newsArray=[];
	for(var i=0;i<len;i++){
		newsArray.push($(alist[i]).attr('title'));
	}
	chrome.extension.sendMessage({cmd: "setNewsArr",'arr':newsArray},function(response) {
		
	});
	//alist[0].click();
}
getCSDNNews();