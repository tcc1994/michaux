
function headImgSelect(targetObj, previewId){
	$('#headButton').prop('disabled', false);
	previewImage(targetObj, previewId);
}

/**
 * inputType 1详情页、列表货物图片;2身份认证图片
 */
function previewImage(targetObj, previewId,inputId, inputType) {
	var pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)/;    
	  var AllowImgFileSize=70;  // 允许上传图片文件的大小 0为无限制 单位：KB
	  var AllowImgWidth=200;   // 允许上传的图片的宽度 ŀ为无限制 单位：px(像素)
	  var AllowImgHeight=500;   // 允许上传的图片的高度 ŀ为无限制 单位：px(像素)
	  if (inputType == 1) {
		  AllowImgFileSize=5000;  // 允许上传图片文件的大小 0为无限制 单位：KB
		  AllowImgWidth=200;   // 允许上传的图片的宽度 ŀ为无限制 单位：px(像素)
		  AllowImgHeight=150;   // 允许上传的图片的高度 ŀ为无限制 单位：px(像素)
	  } else if (inputType == 2) {
		  AllowImgFileSize=2000;  // 允许上传图片文件的大小 0为无限制 单位：KB
		  AllowImgWidth=180;   // 允许上传的图片的宽度 ŀ为无限制 单位：px(像素)
		  AllowImgHeight=120;   // 允许上传的图片的高度 ŀ为无限制 单位：px(像素)
	  }
	  var ImgFileSize=Math.round(targetObj.fileSize/1024*100)/100;// 取得图片文件的大小
	  if(isNaN(ImgFileSize)){
		  ImgFileSize = Math.round($(targetObj)[0].files[0].size/1024*100)/100;
	  }
	  var ImgWidth=targetObj.width;   // 取得图片的宽度
	  var ImgHeight=targetObj.height;  // 取得图片的高度
	  if(!pattern.test(targetObj.value)){ 
	    alert("图片格式错误,请重新上传！");  
	    targetObj.focus(); 
	  }else  if(AllowImgWidth!=0&&AllowImgWidth<ImgWidth) {
	    alert("图片宽度超过限制。请上传宽度小于"+AllowImgWidth+"px的文件，当前图片宽度为"+ImgWidth+"px");
	    targetObj.focus(); 
	  }else if (AllowImgHeight!=0&&AllowImgHeight<ImgHeight) {
	    alert("图片高度超过限制。请上传高度小于"+AllowImgHeight+"px的文件，当前图片高度为"+ImgHeight+"px");
	    targetObj.focus(); 
	  }else if(AllowImgFileSize!=0&&AllowImgFileSize<ImgFileSize){
	    alert("图片文件大小超过限制。请上传小于"+AllowImgFileSize+"KB的文件，当前文件大小为"+ImgFileSize+"KB");
	    targetObj.focus(); 
	  }else{
		  previewVerificationImage(targetObj, previewId, inputId);
	  }
}


function previewVerificationImage(targetObj, previewId,inputId){

	var prev = document.getElementById("prev_" + previewId);
	prev.parentNode.removeChild(prev);
	tanc_k();
    var preview = document.getElementById(previewId);
    var ua = window.navigator.userAgent;

    if (ua.indexOf("MSIE") > -1) {

        targetObj.select();

        try {
            var src = document.selection.createRange().text;
            var ie_preview_error = document
                    .getElementById("ie_preview_error_" + previewId);

            if (ie_preview_error) {
                preview.removeChild(ie_preview_error);
            }

            var img = document.getElementById(previewId);

            img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"
                    + src + "', sizingMethod='scale')";
        } catch (e) {
            if (!document.getElementById("ie_preview_error_" + previewId)) {
                var info = document.createElement("<p>");
                info.id = "ie_preview_error_" + previewId;
                info.innerHTML = "a";
                preview.insertBefore(info, null);
            }
        }
    } else {
        var files = targetObj.files;
        for ( var i = 0; i < files.length; i++) {

            var file = files[i];

            var imageType = /image.*/;
            if (!file.type.match(imageType))
                continue;

            var prevImg = document.getElementById("prev_" + previewId);
            if (prevImg) {
                preview.removeChild(prevImg);
            }

            var img = document.createElement("img");
            img.id = "prev_" + previewId;
            img.classList.add("obj");
            img.file = file;
            img.style.width = '100%';
            img.style.height = '100%';
            
            preview.appendChild(img);

            if (window.FileReader) {
                var reader = new FileReader();
                reader.onloadend = (function(aImg) {
                    return function(e) {
                        aImg.src = e.target.result;
                    };
                })(img);
                reader.readAsDataURL(file);
            } else {
                if (!document.getElementById("sfr_preview_error_"
                        + previewId)) {
                    var info = document.createElement("p");
                    info.id = "sfr_preview_error_" + previewId;
                    info.innerHTML = "not supported FileReader";
                    preview.insertBefore(info, null);
                }
            }
        }
    }
    ajaxFileUpload($(targetObj).attr("id"),inputId);
}



function previewImage_bak(targetObj, previewId,inputId) {
// ajaxFileUpload($(targetObj).attr("id"),inputId);
	var prev = document.getElementById("prev_" + previewId);
	prev.parentNode.removeChild(prev);
    
    var preview = document.getElementById(previewId);
    var ua = window.navigator.userAgent;

    if (ua.indexOf("MSIE") > -1) {

        targetObj.select();

        try {
            var src = document.selection.createRange().text;
            var ie_preview_error = document
                    .getElementById("ie_preview_error_" + previewId);

            if (ie_preview_error) {
                preview.removeChild(ie_preview_error);
            }

            var img = document.getElementById(previewId);

            img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"
                    + src + "', sizingMethod='scale')";
        } catch (e) {
            if (!document.getElementById("ie_preview_error_" + previewId)) {
                var info = document.createElement("<p>");
                info.id = "ie_preview_error_" + previewId;
                info.innerHTML = "a";
                preview.insertBefore(info, null);
            }
        }
    } else {
        var files = targetObj.files;
        for ( var i = 0; i < files.length; i++) {

            var file = files[i];

            var imageType = /image.*/;
            if (!file.type.match(imageType))
                continue;

            var prevImg = document.getElementById("prev_" + previewId);
            if (prevImg) {
                preview.removeChild(prevImg);
            }

            var img = document.createElement("img");
            img.id = "prev_" + previewId;
            img.classList.add("obj");
            img.file = file;
            img.style.width = '100%';
            img.style.height = '100%';
            
            preview.appendChild(img);

            if (window.FileReader) {
                var reader = new FileReader();
                reader.onloadend = (function(aImg) {
                    return function(e) {
                        aImg.src = e.target.result;
                    };
                })(img);
                reader.readAsDataURL(file);
            } else {
                if (!document.getElementById("sfr_preview_error_"
                        + previewId)) {
                    var info = document.createElement("p");
                    info.id = "sfr_preview_error_" + previewId;
                    info.innerHTML = "not supported FileReader";
                    preview.insertBefore(info, null);
                }
            }
        }
    }
}