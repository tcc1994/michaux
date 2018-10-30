var successdata;
var inputId;
function ajaxFileUpload(obj,iId) {
	inputId = iId;
	$.ajaxFileUpload({
	// 服务器上传路径
	url : '/image/upimage',
	//  本地测试上传路径
    // url : '/jty/image/upimage',
		secureuri : false,
		fileElementId : obj,
		type : 'post',
		dataType : 'json',
		success : function(data) {
			if(typeof(data) != 'undefined'){
				successdata = eval("(" + data + ")");
				if (successdata != null && typeof(successdata) != 'undefined' && successdata.success) {
					$("#" + iId).val(successdata.path);
					$("#" + iId).val(successdata.path).change();
				} else {
					alert("上传失败，请重新上传或稍后在试！");
				}
				tanc_g();
	        } else {
	        	alert("上传失败，请重新上传或稍后在试！");
	        	tanc_g();
	        }
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}
//$.noConflict(); // 解决$冲突问题

$.extend({
			createUploadIframe : function(id, uri) {
				// create frame
				var frameId = 'jUploadFrame' + id;

				if (window.ActiveXObject) {
					var io = document.createElement('<iframe id="' + frameId
							+ '" name="' + frameId + '" />');
					if (typeof uri == 'boolean') {
						io.src = 'javascript:false';
					} else if (typeof uri == 'string') {
						io.src = uri;
					}
				} else {
					var io = document.createElement('iframe');
					io.id = frameId;
					io.name = frameId;
				}
				io.style.position = 'absolute';
				io.style.top = '-1000px';
				io.style.left = '-1000px';

				document.body.appendChild(io);

				return io;
			},
			createUploadForm : function(id, fileElementId) {
				// create form
				var formId = 'jUploadForm' + id;
				var fileId = 'jUploadFile' + id;
				var form = $('<form  action="" method="POST" name="'
						+ formId + '" id="' + formId
						+ '" enctype="multipart/form-data"></form>');
				var oldElement = $('#' + fileElementId);
				var newElement = $(oldElement).clone();
				$(oldElement).attr('id', fileId);
				$(oldElement).before(newElement);
				$(oldElement).appendTo(form);
				// set attributes
				$(form).css('position', 'absolute');
				$(form).css('top', '-1200px');
				$(form).css('left', '-1200px');
				$(form).appendTo('body');
				return form;
			},

			ajaxFileUpload : function(s) {
				// TODO introduce global settings, allowing the client to modify
				// them for all requests, not only timeout
				s = $.extend({}, $.ajaxSettings, s);
				var id = new Date().getTime();
				var form = $.createUploadForm(id, s.fileElementId);
				var io = $.createUploadIframe(id, s.secureuri);
				var frameId = 'jUploadFrame' + id;
				var formId = 'jUploadForm' + id;
				// Watch for a new set of requests
				if (s.global && !$.active++) {
					$.event.trigger("ajaxStart");
				}
				var requestDone = false;
				// Create the request object
				var xml = {};
				if (s.global)
					$.event.trigger("ajaxSend", [ xml, s ]);
				// Wait for a response to come back
				var uploadCallback = function(isTimeout) {
					var io = document.getElementById(frameId);
					try {
						if (io.contentWindow) {
							xml.responseText = io.contentWindow.document.body ? io.contentWindow.document.body.innerHTML
									: null;
							xml.responseXML = io.contentWindow.document.XMLDocument ? io.contentWindow.document.XMLDocument
									: io.contentWindow.document;
						} else if (io.contentDocument) {
							xml.responseText = io.contentDocument.document.body ? io.contentDocument.document.body.innerHTML
									: null;
							xml.responseXML = io.contentDocument.document.XMLDocument ? io.contentDocument.document.XMLDocument
									: io.contentDocument.document;
						}
						xml.getResponseHeader = function (a){};
					} catch (e) {
						$.handleError(s, xml, null, e);
					}
					if (xml || isTimeout == "timeout") {
						requestDone = true;
						var status;
						try {
							status = isTimeout != "timeout" ? "success"
									: "error";
							// Make sure that the request was successful or
							// notmodified
							if (status != "error") {
								// process the data (runs the xml through
								// httpData regardless of callback)
								var data = $.uploadHttpData(xml,
										s.dataType);
								// If a local callback was specified, fire it
								// and pass it the data
								if (s.success)
									s.success(data, status);

								// Fire the global callback
								if (s.global)
									$.event.trigger("ajaxSuccess", [ xml,
											s ]);
							} else
								$.handleError(s, xml, status);
						} catch (e) {
							status = "error";
							console.log(successdata);
							if (successdata.success) {
								$("#" + iId).val(successdata.path);
							} else {
								alert("上传失败！");
							}
							// $.handleError(s, xml, status, e);
						}

						// The request was completed
						if (s.global)
							$.event.trigger("ajaxComplete", [ xml, s ]);

						// Handle the global AJAX counter
						if (s.global && !--$.active)
							$.event.trigger("ajaxStop");

						// Process result
						if (s.complete)
							s.complete(xml, status);

						$(io).unbind();

						setTimeout(function() {
							try {
								$(io).remove();
								$(form).remove();

							} catch (e) {
								$.handleError(s, xml, null, e);
							}

						}, 100);

						xml = null;

					}
				};
				// Timeout checker
				if (s.timeout > 0) {
					setTimeout(function() {
						// Check to see if the request is still happening
						if (!requestDone)
							uploadCallback("timeout");
					}, s.timeout);
				}
				try {
					// var io = $('#' + frameId);
					var form = $('#' + formId);
					$(form).attr('action', s.url);
					$(form).attr('method', 'POST');
					$(form).attr('target', frameId);
					if (form.encoding) {
						form.encoding = 'multipart/form-data';
					} else {
						form.enctype = 'multipart/form-data';
					}
					$(form).submit();

				} catch (e) {
					$.handleError(s, xml, null, e);
				}
				if (window.attachEvent) {
					document.getElementById(frameId).attachEvent('onload',
							uploadCallback);
				} else {
					document.getElementById(frameId).addEventListener('load',
							uploadCallback, false);
				}
				return {
					abort : function() {
					}
				};

			},

			uploadHttpData : function(r, type) {
				var data = !type;
				var obj;
				data = type == "xml" || data ? r.responseXML : r.responseText;
				// If the type is "script", eval it in global context
				if (type == "script")
					$.globalEval(data);
				// Get the JavaScript object, if JSON is used.
				// if (type == "json") {
				// data = data.replace("<pre>","").replace("</pre>","");
				// obj = eval(data);
				//					
				// }
				// evaluate scripts within html
				if (type == "html")
					$("<div>").html(data).evalScripts();
				// alert($('param',
				// data).each(function(){alert($(this).attr('value'));}));
				return data;
			}
		});




function popWin(a){
//	function n(){
//		var a=k?k:document.body,
//			b=a.scrollHeight>a.clientHeight?a.scrollHeight:a.clientHeight,
//			c=a.scrollWidth>a.clientWidth?a.scrollWidth:a.clientWidth;
//			$("#maskLayer").css({height:b,width:c})}
//	var d,e,b=9e3,c=!1,f=$("#"+a),g=f.width(),h=f.height(),i=f.find(".tit"),j=f.find(".close"),k=document.documentElement,l=($(document).width()-f.width())/2,m=(k.clientHeight-f.height())/2;f.css({left:l,top:m,display:"block","z-index":b- -1}),i.mousedown(function(a){c=!0,d=a.pageX-parseInt(f.css("left")),e=a.pageY-parseInt(f.css("top")),f.css({"z-index":b- -1}).fadeTo(50,.5)}),i.mouseup(function(){c=!1,f.fadeTo("fast",1)}),$(document).mousemove(function(a){if(c){var b=a.pageX-d;0>=b&&(b=0),b=Math.min(k.clientWidth-g,b)-5;var i=a.pageY-e;0>=i&&(i=0),i=Math.min(k.clientHeight-h,i)-5,f.css({top:i,left:b})}}),j.live("click",function(){$(this).parent().parent().hide().siblings("#maskLayer").remove()}),$('<div id="maskLayer"></div>').appendTo("body").css({background:"#000",opacity:".4",top:0,left:0,position:"absolute",zIndex:"8000"}),n(),$(window).bind("resize",function(){n()}),$(document).keydown(function(a){27==a.keyCode&&($("#maskLayer").remove(),f.hide())})
}

function tanc_k(){
      popWin("theme-popover");
      $('.theme-popover').css("display","block");
	  $('#maskLayer').css("display","block");
}

function tanc_g(){
	 $('.theme-popover').css("display","none");
    $('#maskLayer').css("display","none");
}
