 //获取系统时间，将时间以指定格式显示到页面。  
    function systemTime()  
    {  
        //获取系统时间。  
        var dateTime=new Date();  
        var yy = dateTime.getFullYear();
        var MM = dateTime.getMonth();
        var dd = dateTime.getDate();
        var hh=dateTime.getHours();  
        var mm=dateTime.getMinutes();  
        var ss=dateTime.getSeconds();  
          
        //分秒时间是一位数字，在数字前补0。  
        mm = extra(mm);  
        ss = extra(ss);  
          
        //将时间显示到ID为time的位置，时间格式形如：19:18:02  
        document.getElementById("showDate").innerHTML="现在是:[<font color=\"red\">"+yy+'年'+MM+'月'+dd+'日'+hh+"时"+mm+"分"+ss+"秒</font>]"+' 欢迎[<b>'+user+'</b>]登录'+name+'';  
          
        //每隔1000ms执行方法systemTime()。  
        setTimeout("systemTime()",1000);  
    }  
      
    //补位函数。  
    function extra(x)  
    {  
        //如果传入数字小于10，数字前补一位0。  
        if(x < 10)  
        {  
            return "0" + x;  
        }  
        else  
        {  
            return x;  
        }  
    }  