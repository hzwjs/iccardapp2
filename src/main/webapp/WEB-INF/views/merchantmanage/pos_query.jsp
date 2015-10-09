<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>设备查询</title>
    <c:import url="../system/base.jsp"></c:import>
    <!-- view_source_begin -->
    <style>
    .edit{
/* background-color: #E9C2A6;
 background-color: #6B4226; */
 background-color: #CDCDCD;
}
    </style>
     <script type="text/javascript">
     $(document).ready(function() {

 		$('.container').omCalendar();

 	});
     
        $(function() {
            $('#grid').omGrid({
                limit:20,
                title : '设备信息列表',
                showIndex : false,  
                singleSelect : true,
                height:500,
                colModel :  [ {header : '设备ID', name : 'devCode', width : 150, align : 'center'}, 
                              {header : '设备IP', name : 'devIp', width : 150, align : 'left'}, 
                              {header : '设备类型', name : 'devType', align : 'left', width : 120},
                              {header : '设备状态', name : 'devState', align : 'left', width : 120},
                              {header : '设备样式', name : 'devModel', align : 'left', width : 120},
                              {header : '设备数量', name : 'psamNo', align : 'left', width : 120},
                              {header : '分行号', name : 'devBank', align : 'center', width : 120},
                              ],
				dataSource : "<c:url value='/sys/manage/posDev/page'/>"
            });
            
            var dialog = $("#dialog-form").omDialog({
                width: 600,
                autoOpen : false,
                modal : true,
                resizable : false,
                buttons : {
                    "提交" : function(){
		                submitDialog();
		                return false; //阻止form的默认提交动作i
		            },
                    "取消" : function() {
                        $("#dialog-form").omDialog("close");//关闭dialog
                    } 
                } 
            });
            //显示dialog并初始化里面的输入框的数据
            var showDialog = function(title,rowData){
                validator.resetForm();
                rowData = rowData || {};
                qid = rowData.devCode;
                $.ajax({
             		url: "<c:url value='/sys/manage/posDev/details?qid='/>"+encodeURI(qid),
             		type:'POST',
             		success:function(result){
             			var devCode = $("#devCode").val(result.devCode);
                 		var devIp = $("#devIp").val(result.devIp);
                 		var devType = $("#devType").val(result.devType);
                 		var devState = $("#devState").val(result.devState);
                 		var devDesc = $("#devDesc").val(result.devDesc);
                 		var devAcct = $("#devAcct").val(result.devAcct);
                  		var devAcctName = $("#devAcctName").val(result.devAcctName);
                  		var devModel = $("#devModel").val(result.devModel);
                  		var psamNo = $("#psamNo").val(result.psamNo);
                  		var phoneNo = $("#phoneNo").val(result.phoneNo);
                  		var posMerch = $("#posMerch").val(result.posMerch);
                  		var merchType = $("#merchType").val(result.merchType);
                  		var merchName = $("#merchName").val(result.merchName);
                  		var signDate = $("#signDate").val(result.signDate);
                  		var devBank = $("#devBank").val(result.devBank);
             		}
             		});
                $("input[name='operator']",dialog).val(rowData.operator);
                $("input[name='name']",dialog).val(rowData.name);
                $("input[name='pwd']",dialog).val(rowData.pwd);
                $("input[name='lev']",dialog).val(rowData.lev);
                $("input[name='telNo']",dialog).val(rowData.telNo);
                $("input[name='areaCode']",dialog).val(rowData.areaCode);
                $("input[name='areadigit']",dialog).val(rowData.areadigit);
                $("input[name='note']",dialog).val(rowData.note);
                branchCode:$("input[name='branchCode']",dialog).val(rowData.branchCode)
                dialog.omDialog("option", "title", title);
                dialog.omDialog("open");//显示dialog
            };
            
            //dialog中点提交按钮时将数据提交到后台并执行相应的add或modify操作
            var submitDialog = function(){
                if (validator.form()) {
	                var submitData={
	                	devCode:$("input[name='devCode']",dialog).val(),
	                	devIp:$("input[name='devIp']",dialog).val(),
	                	devType:$("input[name='devType']",dialog).val(),
	                	devState:$("input[name='devState']",dialog).val(),
	                	devDesc:$("input[name='devDesc']",dialog).val(),
	                	devAcct:$("input[name='devAcct']",dialog).val(),
	                	devAcctName:$("input[name='devAcctName']",dialog).val(),
	                	devModel:$("input[name='devModel']",dialog).val(),
	                	psamNo:$("input[name='psamNo']",dialog).val(),
	                	phoneNo:$("input[name='phoneNo']",dialog).val(),
	                	posMerch:$("input[name='posMerch']",dialog).val(),
	                	merchType:$("input[name='merchType']",dialog).val(),
	                	merchName:$("input[name='merchName']",dialog).val(),
	                	signDate1:$("input[name='signDate']",dialog).val(),
	                	devBank:$("input[name='devBank']",dialog).val(),
	                };
	                
	                if(!(/^((((19|20)\d{2})-(0?(1|[3-9])|1[012])-(0?[1-9]|[12]\d|30))|(((19|20)\d{2})-(0?[13578]|1[02])-31)|(((19|20)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-29))$/).test($('#signDate').val())){
	                	showTimeoutTip("日期格式不对")
	        		}else{
	                $.post("<c:url value='/sys/manage/posDev/modify'/>",submitData,function(){
	                    if(isAdd){
	                        $('#grid').omGrid('reload',1);//如果是添加则滚动到第一页并刷新
	                        $.omMessageTip.show({title: "操作成功", content: "添加数据成功", timeout: 1500});
	                    }else{
	                        $('#grid').omGrid('reload');//如果是修改则刷新当前页
	                        $.omMessageTip.show({title: "操作成功", content: "修改数据成功", timeout: 1500});
	                    }
	                    $("#dialog-form").omDialog("close"); //关闭dialog
	                });
	        		}
                }
            };
            
            var isAdd = true; //弹出窗口中是添加操作还是修改操作？
            $('#create').bind('click', function() {
                isAdd = true;
                showDialog('新增');//显示dialog
            });
            $('#modify').bind('click', function() {
                var selections=$('#grid').omGrid('getSelections',true);
                if (selections.length == 0) {
                    alert('请至少选择一行记录');
                    return false;
                }
                isAdd = false;
                $('#devCode').attr('readonly',true);
                $('#devCode').css('background','#CDCDCD');
                showDialog('修改',selections[0]);//显示dialog
            });
            $('#details').bind('click', function() {
                var selections=$('#grid').omGrid('getSelections',true);
                if (selections.length == 0) {
                    alert('请选择一行记录');
                    return false;
                }
                isAdd = false;
                showDialog('详情',selections[0]);//显示dialog
            });
            $('#delete').bind('click', function(e) {
                var selections=$('#grid').omGrid('getSelections',true);
                if (selections.length == 0) {
                    alert('请至少选择一行记录');
                    return false;
                }
                if(confirm("确认删除吗？")){
                    //将选择的记录的id传递到后台去并执行delete操作
                    var toDeleteRecordID=selections[0].devCode;
                    $.post("<c:url value='/sys/manage/posDev/delete'/>",{operation:'delete',devCode:toDeleteRecordID},function(result){
                    	if(result.code==0){
                    		 $('#grid').omGrid('reload');//刷新当前页数据
                             $.omMessageTip.show({title: "操作成功", content: "删除数据成功", timeout: 1500});
                    	}else{
                    		 $.omMessageTip.show({title: "操作失败", content: "删除异常", timeout: 1500});
                    	}
                    });
                }else{
                	return;
                }
            });
            $('#query').bind('click', function(e) {
                var qName=$('#qname').val();
                if(qName===""){ //没要有查询条件，要显示全部数据
                    $('#grid').omGrid("setData", "<c:url value='/sys/manage/posDev/page'/>");
                }else{ //有查询条件，显示查询数据
                    $('#grid').omGrid("setData", "<c:url value='/sys/manage/posDev/page?qname='/>"+encodeURI(qName));
                }
            });
            
            // 对表单进行校验
            var validator = $('#ipForm').validate({
                rules : {
                	loginname : {required: true}, 
                	id : {required : true},
                	password :{required : true},
                	branchCode :{required : true},
                	
                }, 
                messages : {
                	loginname : {required : "登陆名不能为空"},
                    id : {required : "ID不能为空"},
                    password :{required : "密码不能为空"},
                    branchCode :{required : "类型不能为空"},
                }
            });
        });
            
        
        function insertUndifend(data){
        	for ( var v in data) {
				if(data[v] === null){
					data[v]=undefined;
				}
			}
        	return data;
        }
        
        function showTimeoutTip(content){

            $.omMessageTip.show({

                title : '提示',

                content : content,

                timeout : 2000

            });

        }
    </script>
    <!-- view_source_end -->
</head>
<body>
 <div id="demo" style="margin-left:30px;margin-top:20px">
    <div id="tbdiv">
        <!-- <input id="create" type="button" value="新增"/> -->
        <input id="modify" type="button" value="修改"/>
       <!--  <input id="details" type="button" value="详情"/> -->
        <input id="delete" type="button" value="删除"/>
        设备ID(模糊查询，为空时显示全部)：<input id="qname"></input>
        <input id="query" type="button" value="查询"/>
    </div>
    <table id="grid"></table>
    <div id="au_user"></div>
    
    <div id="dialog-form">
        <form id="ipForm">
 	        <table class="grid_layout">
	            <tr>
					<td width="80px">设备ID：</td>
					<td><input name="devCode" id="devCode" /></td>
					<td width="30px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td width="80px">设备IP：</td>
					<td><input name="devIp" id="devIp" /></td>
				</tr>
				<tr>
					<td>设备类型：</td>
					<td><input name="devType" id="devType" /></td>
					<td><span class="errorImg"></span><span class="errorMsg"></span></td>
					<td>设备状态：</td>
					<td><input name="devState" id="devState" /></td>
				</tr>
				<tr>
					<td>设备描述：</td>
					<td colspan="4"><input name="devDesc" id="devDesc" /></td>
				</tr>
				<tr>
					<td width="80px">账户：</td>
					<td><input name="devAcct" id="devAcct" class="edit" disabled="true"/></td>
					<td><span class="errorImg"></span><span class="errorMsg"></span></td>
					<td width="108px">账户名称：</td>
					<td><input name="devAcctName" id="devAcctName" class="edit" disabled="true"/></td>
				</tr>
				<tr>
					<td>设备样式：</td>
					<td><input name="devModel" id="devModel" /></td>
					<td><span class="errorImg"></span><span class="errorMsg"></span></td>
					<td>设备数量：</td>
					<td><input name="psamNo" id="psamNo" /></td>
					<td><span class="errorImg"></span><span class="errorMsg"></span></td>
				</tr>
				<tr>
					<td>联系电话：</td>
					<td><input name="phoneNo" id="phoneNo" /></td>
					<td><span class="errorImg"></span><span class="errorMsg"></span></td>
					<td>pos商户：</td>
					<td><input name="posMerch" id="posMerch" class="edit" disabled="true"/></td>
				</tr>
				<tr>
					<td>商户类型：</td>
					<td><input name="merchType" id="merchType" class="edit" disabled="true"/></td>
					<td><span class="errorImg"></span><span class="errorMsg"></span></td>
					<td>商户名称：</td>
					<td><input name="merchName" id="merchName" class="edit" disabled="true"/></td>
				</tr>
				<tr>
					<td>分行号：</td>
					<td><input name="devBank" id="devBank" /></td>
					<td><span class="errorImg"></span><span class="errorMsg"></span></td>
					<td>签约日期：</td>
					<td><input name="signDate" id="signDate" class="container"/></td>
				</tr>
	        </table>
	        
        </form>
    </div>
    </div>
</body>
</html>