<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IC卡应该管理系统</title>
<c:import url="base.jsp"></c:import>
<!-- view_source_begin -->
<style>
html, body {
	width: 100%;
	height: 100%;
	padding: 0;
	margin: 0;
}

#center-tab .om-panel-body {
	padding: 0;
}


.content-width {MARGIN: auto;width:350px;float:left;margin-top:1px;}
.content-width img{MAX-WIDTH: 100%!important;HEIGHT: auto!important;width:expression(this.width > 600 ? "600px" : this.width)!important;}

</style>
<script type="text/javascript">
   
    function logout() {
    	 $.omMessageBox.confirm({
    	        title:'提示',
    	        content:'确定要退出?',
    	        onClose:function(value){
    	        	if(value){
    	        		$.post("<c:url value='/sys/logout'/>", function(result) {
            				if (result.code==0) {
            					window.location.href = window.location.href;
            				}
            			}, 'json');
    	        	}
        			
    	        }
    	    });
    }
         $(function() {
            $('body').omBorderLayout({
           	   panels:[ {
           		   id:"north-panel", 
//            	       title:"This is north panel", 
           	       region:"north", 
           	       height:82,
           	   	   header:false
//            	       resizable:true, 
//            	       collapsible:true 
           	    },{
           	        id:"center-panel",
           	     	header:false,
           	        region:"center",
           	        height:600
           	    },{
           	        id:"west-panel",
           	        resizable:true,
           	        collapsible:true,
           	        title:"导航",
           	        region:"west",
           	        width:180
           	    }]
            });
            var tabElement = $('#center-tab').omTabs({
                height : "100%"
            });

           
            var ifh = tabElement.height() - tabElement.find(".om-tabs-headers").outerHeight() - 4; //为了照顾apusic皮肤，apusic没有2px的padding，只有边框，所以多减去2px
            $('#3Dbox').height(ifh);
            
            $.ajax({
    			url : "<c:url value='/sys/manage/resource/tree'/>",
    			type : "POST",
    			dataType : "JSON",
    			success : function(data) {
    				treeData(data);
    				$("#navTree").omTree({
    	                dataSource : data,
    	                simpleDataModel: true,
    	                onClick : function(data , event){
    	                	if(data.resourceUrl){// 叶子节点
    	                		var tabId = tabElement.omTabs('getAlter', 'tab_'+data.id);
    	                		if(tabId){
    	                			tabElement.omTabs('activate', tabId);
    	                		}else{
    			                	tabElement.omTabs('add',{
    			                        title : data.text, 
    			                        tabId : 'tab_'+data.id,
    			                        content : "<iframe id='"+data.id+"' border=0 frameBorder='no' name='inner-frame' src='"+ CONTEXT_PATH + data.resourceUrl+"' height='"+ifh+"' width='100%'></iframe>",
    			                        closable : true
    			                    });
    	                		}
    	                	}
    	                }
    	            });

    			}
    		});
            
        });
        /* 为树节点准备数据 */ 
        function treeData(data) {
     		for ( var i in data) {
     			data[i].text = data[i].resourceName;
     			data[i].pid = data[i].resourcePid;
     		}
     	}
         function hideDropList() {

 			$("#droplist").hide();

 			$("body").unbind("mousedown", onBodyDown);

 		}
    </script>
<!-- view_source_end -->
</head>
<body>
	<!-- view_source_begin -->
	<div id="north-panel" style="height: auto;">
		<div 
			style="background-color: #2684c2; padding: 5px 0px 2px 5px; display: block; height: 73px;">
			<div class=content-width>
			<img src="<c:url value='/images/loginlogo.PNG' />" />
			</div>
			<div
				style="color: #fff; font-size: 14px; float: right; padding: 30px 20px 0 0;">
				<span style="padding-right: 10px;">欢迎您登录系统</span> 用户名：<span
					style="color: red;">${sessionInfo.loginname }</span> <span
					style="padding-left: 20px;"><a href="javascript:void(0)"
					onclick="logout()" style="color: #fff; text-decoration: none;">退出</a></span>
			</div>
		</div>
	</div>
	<div id="center-panel">
		<div id="center-tab">
			<ul>
				<li><a href="#tab1">欢迎首页</a></li>
			</ul>
			<div id="tab1">
				<iframe id='3Dbox' border=0 frameBorder='no'
					src=<c:url value='/sys/home/system/index'/> width='100%'></iframe>
			</div>
		</div>
	</div>
	<div id="west-panel">
		<ul id="navTree"></ul>
	</div>
	<!-- view_source_end -->
	<div id="view-desc"></div>
</body>
</html>