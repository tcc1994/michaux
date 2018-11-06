  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- å¼¹åºæ¡ -->
  <script type="text/javascript" src="${ctx}/static/js/alert/alert.js"></script>
    <div class="modal fade" id="alert_like" tabindex="-1">
        <!-- çªå£å£°æ -->
        <div class="modal-dialog modal-sm">
            <!-- åå®¹å£°æ -->
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal"><span>&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel"></h4>
                </div>
                <div class="modal-body text-center">
                    <div id="modal_con"></div>
                </div>
                <input id="skipUrl" hidden/>
                <div class="modal-footer">
                    <button id="ok_btn" class="btn btn-sm btn-warning">确定</button>
                </div>
            </div>
        </div>
    </div>
    
    