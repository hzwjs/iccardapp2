<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>操作员管理主页面</title>
    <c:import url="base.jsp"></c:import>
    <!-- view_source_begin -->
    <style>
    </style>
     <script type="text/javascript">
  	
        $(function() {
            $('#grid').omGrid({
                limit:20,
                title : '用户信息列表',
                showIndex : false,  
                singleSelect : true,
                height:500,
                colModel :  [ {header : '登录名', name : 'operator', width : 100, align : 'center'}, 
                              {header : '用户名', name : 'name', width : 150, align : 'left'}, 
                              {header : '电话', name : 'telNo', align : 'left', width : 120},
                              {header : '分行号', name : 'branchCode', align : 'left', width : 100},
                              {header : '区域编码', name : 'areaCode', align : 'left', width : 100},
                              {header : '是否有效', name : 'forbid', align : 'left', width : 80},
                              {header : '备注', name : 'note', align : 'left', width : 80},
                              {header : '操作', name : 'operator', align : 'center', width : 150,renderer:userAu},
                              ],
				dataSource : "<c:url value='/sys/manage/operator/page'/>"
            });
            
            function userAu(value){
            	return "<a href='javascript:;' onclick='au_user("+'"'+value+'"'+");'>赋予角色</a>";
            }
            
            var dialog = $("#dialog-form").omDialog({
                width: 350,
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
                $("input[name='operator']",dialog).val(rowData.operator);
                $("input[name='name']",dialog).val(rowData.name);
                $("input[name='pwd']",dialog).val(rowData.pwd);
                $("input[name='telNo']",dialog).val(rowData.telNo);
                $("input[name='areaCode']",dialog).val(rowData.areaCode);
                $("input[name='areadigit']",dialog).val(rowData.areadigit);
                $("input[name='note']",dialog).val(rowData.note);
                branchCode:$("input[name='branchCode']",dialog).val(rowData.branchCode);
                dialog.omDialog("option", "title", title);
                dialog.omDialog("open");//显示dialog
            };
            //dialog中点提交按钮时将数据提交到后台并执行相应的add或modify操作
            var submitDialog = function(){
                if (validator.form()) {
                	
	                var submitData={
	                	operator:$("input[name='operator']",dialog).val(),
	                	name:$("input[name='name']",dialog).val(),
	                	pwd:$("input[name='pwd']",dialog).val(),
	                	telNo:$("input[name='telNo']",dialog).val(),
	                	areaCode:$("input[name='areaCode']",dialog).val(),
	                	areadigit:$("input[name='areadigit']",dialog).val(),
	                	note:$("input[name='note']",dialog).val(),
	                    forbid:$("select[name='forbid']",dialog).val(),
	                    branchCode:$("input[name='branchCode']",dialog).val(),
	                };
	                $.post("<c:url value='/sys/manage/operator/saveorupdate'/>",submitData,function(){
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
            };
            var isAdd = true; //弹出窗口中是添加操作还是修改操作？
            $('#create').bind('click', function() {
                isAdd = true;
                $('#operator').attr('readonly',false);
                $('#operator').css('background','none');
                showDialog('新增');//显示dialog
            });
            $('#modify').bind('click', function() {
                var selections=$('#grid').omGrid('getSelections',true);
                if (selections.length == 0) {
                    alert('请至少选择一行记录');
                    return false;
                }
                isAdd = false;
                // 设置登录名位不可编辑状态
                $('#operator').attr('readonly',true);
                $('#operator').css('background','#CDCDCD');
                showDialog('修改',selections[0]);//显示dialog
            });
            $('#delete').bind('click', function(e) {
                var selections=$('#grid').omGrid('getSelections',true);
                if (selections.length == 0) {
                    alert('请至少选择一行记录');
                    return false;
                }
                if(confirm("确认删除吗？")){
                //将选择的记录的id传递到后台去并执行delete操作
                var toDeleteRecordID=selections[0].operator;
                $.post("<c:url value='/sys/manage/operator/delete'/>",{operation:'delete',operator:toDeleteRecordID},function(result){
                	if(result.code==0){
                		 $('#grid').omGrid('reload');//刷新当前页数据
                         $.omMessageTip.show({title: "操作成功", content: "删除数据成功", timeout: 1500});
                	}else{
                		 $.omMessageTip.show({title: "操作失败", content: result.msg, timeout: 1500});
                	}
                   
                });                	
                }else{
                	return;
                }
            });
           
            $('#query').bind('click', function(e) {
                var qCity=$('#qCity').val();
                if(qCity===""){ //没要有查询条件，要显示全部数据
                    $('#grid').omGrid("setData", '../../../gridcrud.do');
                }else{ //有查询条件，显示查询数据
                    $('#grid').omGrid("setData", '../../../gridcrud.do?qCity='+encodeURI(qCity));
                }
            });
            
            // 对表单进行校验
            var validator = $('#ipForm').validate({
                rules : {
                	operator : {required: true,minlength:4}, 
                	name : {required : true},
                	pwd :{required : true},
                	lev:{maxlength:10},
                	branchCode :{required : true,maxlength:4},
                	telNo:{maxlength:16},
                	areaCode:{maxlength:4},
                	areadigit:{maxlength:4},
                	
                }, 
                messages : {
                	operator : {required : "登录名不能为空",minlength:"登录名不能少于4位"},
                	name : {required : "ID不能为空"},
                	pwd :{required : "密码不能为空"},
                    branchCode :{required : "类型不能为空",maxlength:"分行号不能大于4位"},
                    telNo:{maxlength:"电话号码不能大于16位"},
                    areaCode:{maxlength:"地区编码不能大于4位"},
                    areadigit:{maxlength:"areadigit不能大于4位"},
                }
            });
        });
            
        
        
  function au_user(id){
      	var url = "<c:url value='/sys/home/system/operators-au-manage.html?userId='/>" + id;
      	$.ajax({
      		url:url,
      		dataType:"text",
      		success:function(html){
      			$("#au_user").append(html);
      		}
      	});
        $("#au_user").omDialog({
		    autoOpen : true,
		    title:"赋予角色",
		    model:true,
		    height:400,
		    resizable:false,
		    buttons:[{
			   text:"确定",
			   click:function(){
				     var record=$("#grid").omGrid('getSelections',true);
				     var close=$("#au_user").omDialog('close');
				     var ext = $('#mu_tree').omTree('getChecked',true);
				     var ids=[];
				 for ( var i in ext) {
							ids.push(ext[i].id);
					}
				 $.ajax({
					 url:"<c:url value='/sys/manage/role/roletouser'/>",
					 data:{
						userId:record[0].operator,
						roles:ids.join(',')
					 },
					 type:'POST',
					 dataType:"json",
					 success:function(data){
						 if(data.code==0){
						 	 showTimeoutTip("角色赋予成功！");
						 }else{
							 showTimeoutTip("角色赋予失败！");
						 }
					 }
				 });
			 }
		 }]
	 });
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
        <input id="create" type="button" value="新增"/>
        <input id="modify" type="button" value="修改"/>
        <input id="delete" type="button" value="删除"/>
<!--         地区(模糊查询，为空时显示全部)：<input id="qCity"></input> -->
<!--         <input id="query" type="button" value="查询"/> -->
    </div>
    <table id="grid"></table>
    <div id="au_user"></div>
    
    <div id="dialog-form">
        <form id="ipForm">
 	        <table>
 	        	<tr>
	                <td>登录名：</td>
	                <td><input id="operator" name="operator" /></td>
	            </tr>
	            <tr>
	                <td>用户名：</td>
	                <td><input name="name" /></td>
	            </tr>
	            <tr>
	                <td>登陆密码：</td>
	                <td><input type="password" name="pwd" /></td>
	            </tr>
	            <tr style="display:none">
	                <td>等级：</td>
	                <td><input name="lev" /></td>
	            </tr>
	            <tr>
	                <td>电话：</td>
	                <td><input name="telNo" /></td>
	            </tr>
	            <tr>
	                <td>分行号：</td>
	                <td><input name="branchCode" /></td>
	            </tr>
	            <tr>
	                <td>地区编码：</td>
	                <td><input name="areaCode" /></td>
	            </tr>
	            <tr>
	                <td>备注：</td>
	                <td><input name="note" /></td>
	            </tr>
	            <tr>
	                <td>是否有效：</td>
	                <td><select name="forbid"><option value="T">是</option><option value="F">否</option></select></td>
	            </tr>
	        </table>
	        
        </form>
    </div>
    </div>
</body>
</html>