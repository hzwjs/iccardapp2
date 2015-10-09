<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>授权界面</title>
<%-- <c:import url="base.jsp"></c:import> --%>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/form.css'/>">
<!-- view_source_begin -->
<style>
</style>
<script type="text/javascript">
	$(function() {
		var url = "<c:url value='/sys/manage/resource/alltree'/>";
		$.ajax({
			url : url,
			type : "POST",
			dataType : "JSON",
			success : function(data) {
				treeData(data);
				$("#mu_tree").omTree({
					dataSource : data,
					simpleDataModel : true,
					showCheckbox : true,
					cascadeCheck:true
				});
				$('#mu_tree').omTree('expandAll');
				$('#mu_tree li span').removeAttr('class',"file").attr("class","userfile");
				$.ajax({
					url : "<c:url value='/sys/manage/resource/roletotree?roleId=${param.roleId}'/>",
					type : "POST",
					dataType : "text",
					success : function(data) {
						data=eval(data);
						for ( var v in data) {
						   var node=$('#mu_tree').omTree('findNodeBy',function(nodedata){
						    	if(nodedata.id==data[v].id){
						    		return true;
						    	}
						    });
						   $('#mu_tree').omTree('check',node);
						}
						
					}
				});		 
			}
		});
	});
	function treeData(data) {
		for ( var i in data) {
 			data[i].text = data[i].resourceName;
 			data[i].pid = data[i].resourcePid;
 		}
	}

</script>
<style type="text/css">
#droplist {
	display: none;
	position: absolute;
	width: 158px;
	/* 兼容IE6,7 */
	*width: 154px;
	/* 兼容IE8 */
	width: 156px\0;
	height: 200px;
	border: 1px solid;
	overflow: auto;
}

.input_text {
	width: 160px;
	height: 18px;
}

#nav_cont {
	margin-left: auto;
	margin-right: auto;
}
</style>
<!-- view_source_end -->
</head>
<body>
			<ul id="mu_tree">

			</ul>
	</body>
</html>