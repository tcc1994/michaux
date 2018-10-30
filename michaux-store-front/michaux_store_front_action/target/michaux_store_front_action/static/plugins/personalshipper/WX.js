/**
 * Created by LISA on 2015/1/27.
 */
window.WX=(function(){

    var win_width=$(window).width()   //获得窗口的宽
    var win_height=$(window).height() //获得窗口的高
    var yanzheng={  integer : /^(-|\+)?\d+$/,// 整数
        float : /^[-\+]?\d+(\.\d+)?$/,// 浮点数
        time : /^(\d{1,2})(:)?(\d{1,2})\2(\d{1,2})$/,// 时间
        date : /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/,// 日期
        datetime : /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/,//日期+时间
        string_cn : /^[\u0391-\uFFE5]+$/,// 中文字符串
        string_en : /^[a-zA-Z0-9_\-]+$/,// 英文字符串
        url: /^(((ht|f)tp(s?))\:\/\/)[a-zA-Z0-9]+\.[a-zA-Z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/,//url
        email : /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,// 邮箱
        post : /^[1-9]{1}(\d){5}$/,// 邮编
        mobile : /[1][3-9][0-9]{9,9}/,// 手机
        tel : /^0(([1-9]\d)|([3-9]\d{2}))\d{8}$/,// 座机
        idcard : /(^\d{15}$)|(^\d{17}[0-9Xx]$)/,// 身份证
        qq : /^\d{5,9}$/ // QQ
    }
    function bg_gray(a,b){
        $('<div id="WX_bg"></div>').css({"width":"100%","height":"100%","background":"gray","opacity":a,"position":"fixed","left":"0","top":"0","z-index":b}).appendTo("body")
    }
    function close_bg(){
        $("#WX_bg").remove()
    }

    function alt(a,b){
        bg_gray(a,b)    //添加灰色背景函数

    }
    function al_box(a,b,c){

        if(b.substr(b.length-1,1)=="%"){
            $('<div id="WX_box"></div>').html(c).appendTo("body")
            var juzhong=(win_width-b)/2+"px"
            juzhong=(100-parseInt(b))/2+"%";
            var juzhong2=(win_height-$("#WX_box").height())/2+"px"
            $('#WX_box').css({"z-index":a,"position":"absolute","left":juzhong,"width":b,"top":juzhong2})
            
          

        }


        if(b.substr(b.length-1,1)!="%"){
            $('<div id="WX_box"></div>').html(c).appendTo("body")
            var juzhong=(win_width-parseInt(b))/2+"px"
             var juzhong2=(win_height-$("#WX_box").height())/2+"px"
            $('#WX_box').css({"z-index":a,"position":"absolute","left":juzhong,"width":b+"px","top":juzhong2})
           
          

        }


    }
    function cl_box(){
        $("#WX_box").remove()
    }
     //----------------------------------------------------------------------------------------------------------表格排序
    var tab=null
    var el=[]
    var index_array=[]   //储存点击的index
    var tr_array=[]    //储存tr
    var key=true       //排列状态开关




    function which_table(e){   //判断是哪个table
        tab=$(e)

        table_attribute()
    }
    function table_attribute(){   //寻找需要绑定事件的元素

        var change=tab.children("thead").children("tr").children("th")
        el.splice(0,el.length)
        change.each(function(){
            if($(this).attr("change")=="yes"){  //如果change==true 便执行events()函数

                el.push($(this)) //把需要点击的元素装进数组


            }
        })

        events()      //
    }
    function events(){     //给元素绑定相应事件
        for(var i=0;i<el.length;i++){

            if(el[i].attr("change")=="yes"){el[i].on("click",function(){
                 tab=$(this).parent().parent().parent("table")
                change_box($(this))   //把点击元素传进参数给change_box

            })}
        }
    }
    function change_box(e){
        index_array.splice(0,index_array.length)

        var index=e.index()
        index!=-1&&	index_array.push(index) //获取index值
        if(index_array.length!=0){tbody()}

    }
    var tbody=function  (){
        tr_array.splice(0,tr_array.length)
        tab.children("tbody").children("tr").each(function(index){
            tr_array.push($(this))  //把每个tr都放进数组

            var text=$(this).children("td").eq(index_array[0]).text()
            var first_str=text.substr(0,1)
            if(first_str!="-"){text=text.replace(/[&\|\\\*^%$#@\-]/g,"")}  //如果第一项不是“-”就去掉特殊符号}
            tr_array[tr_array.length-1].attr({"bijiao":text})  //给每一个tr 添加一个一比较的值为value的自定义属性bijiao
            //alert(tr_array[tr_array.length-1].attr("bijiao"))
        })

        tr_array.length!=0&&(main())
    }
    var main=function(){    //排序

        var reg= /^[A-Za-z]+$/;
        var choose=reg.test(tr_array[0].attr("bijiao")) //判断是否符合正则表达式
        if(choose){  //判断是数字韩式字母
            str()
        }else{
            num()
        }

        var hanzi = new RegExp("[\\u4E00-\\u9FFF]+","g");
        var hanzi2=hanzi.test(tr_array[0].attr("bijiao"))
        if(hanzi2){    //判断是不是汉字
            chinese()
        }

    }
    function num(){    //数字排序
        tr_array.sort(function(n,b){return n.attr("bijiao")-b.attr("bijiao")})
        animation()
    }

    function str(){    //字母排序
        tr_array.sort(function(n,b){

            if(n.attr("bijiao").toString().toLowerCase()<b.attr("bijiao").toString().toLowerCase()){return -1}else{return 1}
        })
        animation()
    }
    function chinese(){   //汉字排序
        tr_array.sort(function(a,b){return a.attr("bijiao").localeCompare(b.attr("bijiao"))});//汉字拼音排序方法

        animation()
    }

    function animation(){

        tab.children("tbody").children("tr").remove()
        if(key==false){
            tr_array.reverse();

            key=true
            for(var i=0;i<tr_array.length;i++){
                tr_array[i].appendTo(tab.children("tbody"))
            }
            return
        }


        for(var i=0;i<tr_array.length;i++){
            tr_array[i].appendTo(tab.children("tbody"))
        }

        key=false
    }



    //-----------------------------------------------------------------------------------------------------------表格排序
    var hand_choose=function(name,where,callback1,callback2){
        var start_x,star_y,end_x,end_y;

       if(where=="左右"){
           for(var i=0;i<$(name).size();i++){
               $(name)[i].addEventListener("touchstart",function(e){
                   start_x=e.targetTouches[0].pageX;
                   start_y=e.targetTouches[0].pageY;


               }); //开始触摸
               $(name)[i].addEventListener("touchend",function(e){
                   end_x= e.changedTouches[0].pageX;
                   end_y= e.changedTouches[0].pageY;

                   if(end_x>start_x){callback1(); }
                   else if(end_x<start_x){callback2();}




               })

                 }

           }
         if(where=="上下"){
             for(var i=0;i<$(name).size();i++){
                 $(name)[i].addEventListener("touchstart",function(e){
                     start_x=e.targetTouches[0].pageX;
                     start_y=e.targetTouches[0].pageY;


                 }); //开始触摸
                 $(name)[i].addEventListener("touchend",function(e){
                     end_x= e.changedTouches[0].pageX;
                     end_y= e.changedTouches[0].pageY;

                     if(end_y>start_y){callback1(); }  //从上往下
                     else if(end_y<start_y){callback2();} //从下往上




                 })

             }



         }



    }
 //------------------------------------------------------------------------------------替换全部




    return{
           alert:function(e){alt(e.opacity, e.zindex)},  //弹出灰色背景方法
           close_alert:function(e){ close_bg()},     //关闭灰色背景方法
           alert_box:function(e){al_box(e.zindex, e.width, e.content)} ,          //弹出居中div盒子
           close_box:function(e){cl_box()},            //关闭居中盒子
           form:function(e){   //返回表单验证的正则表达式
                  return yanzheng

           },
           river:function(e){new which_table(e.name)},   //表格的自动排序方法
           remove_str:function(e,b){                   //去掉特殊符号
                b=e.replace(/[&\|\\\*^%$#@\-]/g,"")
               return b
           },
           hand:function(e){   //上下左右滑动方法
            hand_choose(e.name, e.where, e.callback1, e.callback2)

           },
           all_replace:function(a,b,c){   //替换全部字符串
            var new_st=a.replace(/\b/g,c)
                 return new_st
           },
           window:function(a,b){            //如果浏览器地址含有某个参数  执行某些方法
            if(window.location.href.indexOf(a)!=-1){b()}
           }


    }




})()


function childList(father){
    var result=new Array();
    var el=father.childNodes;
    for(var i=0;i<el.length;i++){
        if(el[i].nodeType===1){
            result.push(el[i]);
        }
    }
    return result;
}
HTMLCollection.prototype.INDEX=function(el){
    for(var i=0;i<this.length;i++){
        if(this[i]===el){
            return i
        }
    }

}
Array.prototype.INDEX=function(el){
    for(var i=0;i<this.length;i++){
        if(this[i]===el){
            return i
        }
    }

}
function text_fn(el,newtext){    //第一个参数是一个element节点  第二个参数是修改后的文字
        
        if(document.all){
             el.innerText=newtext;
             return newtext
        }else{
             el.textContent=newtext;
             return newtext
        }
        
    }
    
    
    
    
