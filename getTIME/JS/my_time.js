function my_clock(el){
    var today=new Date();
    var h=today.getHours();
    var m=today.getMinutes();
    var s=today.getSeconds();
    m=m>=10?m:('0'+m);
    s=s>=10?s:('0'+s);
    el.innerHTML = h+":"+m+":"+s;
    setTimeout(function(){my_clock(el)}, 1000);//<code>my_clock</code>函数1000毫秒之后又会再次调用自身，这样<code>clock_div</code>中显示的时间就会被更新
}

var clock_div = document.getElementById('time_div');
my_clock(clock_div);