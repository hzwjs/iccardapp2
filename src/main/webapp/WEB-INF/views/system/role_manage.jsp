<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>角色管理主页面</title>
    <c:import url="base.jsp"></c:import>
    <!-- view_source_begin -->
    <style>
    </style>
    <!-- view_source_end -->
    <script type="text/javascript">
        $(function() {
        	var genderOptions = {
        		    dataSource : [{text:"可分配" , value:"0"},{text:"不可以分配",value:"1"}],
        		    editable: false
        		};
        	
            $('#role_manage').omGrid({
                limit:10,
                title : '角色信息列表',
                showIndex : false,  
                singleSelect : true,
                height:600,
                colModel :  [ {header : 'ID', name : 'roleId', align : 'center', width : 150},
                              {header : '角色名称', name : 'roleName', width : 200, align : 'left',editor:{rules:["required",true,"名称是必填的"],type:"text",editable:true,name:"name"}}, 
                              {header : '角色代码', name : 'roleCode', align : 'left', width : 200,editor:{rules:["required",true,"内容是必填的"],type:"text",editable:true,name:"content"}},
                              {header : '是否可分配', name : 'isAllot', align : 'left', width : 200,editor:{type:"omCombo", name:"isAllot" ,options:genderOptions},renderer:genderRenderer},
                              {header : '操作', name : 'roleId', align : 'center', width : 150,renderer:roleAu},
                              ],
				dataSource : "<c:url value='/sys/manage/role/page'/>",
				onBeforeEdit : function(){
					$('#demo >:button').attr("disabled",true);
				},
				onAfterEdit : function(){
					$('#demo >:button').removeAttr("disabled");
				},
				onCancelEdit : function(){
					$('#demo >:button').removeAttr("disabled");
				}
            });
            
            function roleAu(value){
            	return "<a href='javascript:;' onclick='au_role(" + value + ");'>授权</a>";
            }
            
           
            
            function genderRenderer(value){
            	/* 0可分配1不可分配*/
		        if("0" ==value){
		            return "可分配";
		        }else if("1" == value){
		            return "不可分配";
		        }else{
		            return "";
		        }
		    }
  
        
        function insertUndifend(data){
        	for ( var v in data) {
				if(data[v] === null){
					data[v]=undefined;
				}
			}
        	return data;
        }
       
        $('#add').click(function(){
        	$('#role_manage').omGrid('insertRow',0,{});
        });
        
        $('#delete').bind('click', function(e) {
            var selections=$('#role_manage').omGrid('getSelections',true);
            if (selections.length == 0) {
                alert('请至少选择一行记录');
                return false;
            }
            if(confirm("确定删除吗？")){
            	   //将选择的记录的id传递到后台去并执行delete操作
                var toDeleteRecordID=selections[0].roleId;
                $.post("<c:url value='/sys/manage/role/delete'/>",{operation:'delete',roleId:toDeleteRecordID},function(result){
                	if(result.code==0){
                		 $('#role_manage').omGrid('reload');//刷新当前页数据
                         $.omMessageTip.show({title: "操作成功", content: "删除数据成功", timeout: 1500});
                	}else{
                		 $.omMessageTip.show({title: "操作失败", content: result.msg, timeout: 1500});
                	}
                   
                });
            }else{
            	return;
            }
        });
        $('#save').click(function(){
        	var data = $('#role_manage').omGrid('getChanges');
        	/*****此处传递data到后台并处理*******/
        	var requestData=null;
        	if(data.insert.length>0){
        		requestData=data.insert[0];
        	}
        	if(data.update.length>0){
        		requestData=data.update[0];
        	}
        	console.log(requestData);
        	if(!requestData){
        		alert("无对象可保存");
        		return;
        	}
        	$.ajax({  
	            type: "POST",  
	            url:  "<c:url value='/sys/manage/role/saveorupdate'/>",  
	            data:insertUndifend(requestData),  
	            async: false,  
	            dataType: "json",  
	            success: function(data){  
	                if(data){  
	                    alert("操作成功");  
	                }  
	                  
	            }  
	        });  
        	/*****保存成功之后执行如下操作********/
        	 $('#role_manage').omGrid('reload');
        	/******或者执行$('#grid').omGrid('reload');***/
        });
    });
        
        function au_role(id){
         	var url="<c:url value='/sys/home/system/role_au_manage.html?roleId='/>" + id; 
        	$.ajax({
        		url:url,
        		dataType:"text",
        		success:function(html){
        			$("#au_role").append(html);
        		}
        	});
    		$("#au_role").omDialog({
    			 autoOpen : true,
    			 title:"授权",
    			 model:true,
    			 height:400,
    			 buttons:[{
    				 text:"授权",
    				 click:function(){
    					 var record=$("#role_manage").omGrid('getSelections',true);
    					 var close=$("#au_role").omDialog('close');
    					 var ext = $('#mu_tree').omTree('getChecked',true);
    					 var ids=[];
    					 for ( var i in ext) {
								ids.push(ext[i].id);
						}
    					 $.ajax({
    						 url:"<c:url value='/sys/manage/role/grant'/>",
    						 data:{
    							roleId:record[0].roleId,
    							resources:ids.join(',')
    						 },
    						 type:'POST',
    						 dataType:"json",
    						 success:function(data){
    							 if(data.code==-1){
    								 showTimeoutTip("先保存角色，再授权！");
    							 }else if(data.code==0){
    								 showTimeoutTip("授权成功！");
    							 }else{
    								 showTimeoutTip("授权失败！")
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
        <input type="button" id="add" value="新增"/>
       <input id="delete" type="button" value="删除"/>
        <input type="button" id="save" value="保存新增"/>
    	<table id="role_manage"></table>
    	<div id="au_role">
			
		</div>
    </div>
</body>
</html>