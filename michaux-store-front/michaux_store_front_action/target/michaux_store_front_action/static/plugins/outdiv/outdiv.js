function imgShow(_this){
        var src = _this.attr("src");
        src = src.substring(0,src.lastIndexOf('&'));
      $("#bigimg").attr("src", src).load(function(){
//     $("#bigimg").attr("src", src);
//        $("<img/>").attr("src", src).load(function(){
            var windowW = $(window).width();
            var windowH = $(window).height();
            var realWidth = this.width;
            var realHeight = this.height;
            var imgWidth, imgHeight;
            var scale = 0.8;
             
            if(realHeight>windowH*scale) {
                imgHeight = windowH*scale;
                imgWidth = imgHeight/realHeight*realWidth;
                if(imgWidth>windowW*scale) {
                    imgWidth = windowW*scale;
                }
            } else if(realWidth>windowW*scale) {
                imgWidth = windowW*scale;
                imgHeight = imgWidth/realWidth*realHeight;
            } else {
                imgWidth = realWidth;
                imgHeight = realHeight;
            }
//            console.log("windowW : " + windowW);
//            console.log("windowH : " + windowH);
//            console.log("imgWidth : " + imgWidth);
//            console.log("imgHeight : " + imgHeight);
            $("#bigimg").css("width",imgWidth);
            $("#bigimg").css("height",imgHeight);
            var w = (windowW-imgWidth)/2;
            var h = (windowH-imgHeight)/2;
            $("#innerdiv").css({"top":h, "left":w});
            $("#outerdiv").fadeIn("fast");
        });
    }
//滚动鼠标滑轮,图片放大(最大150×150)
function bbimg(o){ 
	var zoom=parseInt(o.style.zoom, 10)||100;
	zoom+=event.wheelDelta/12;
	if (zoom > 0 && zoom < 150) {
		o.style.zoom=zoom+'%';
		return false;
	}else if(zoom > 150){
		o.style.zoom=150+'%';
		return false;
	}
	}