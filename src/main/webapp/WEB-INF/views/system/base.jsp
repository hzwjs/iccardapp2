<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<html>
<head>

<script type="text/javascript">
	var CONTEXT_PATH = "${pageContext.request.contextPath}";
</script>
<script type="text/javascript" src="<c:url value='/js/jquery-1.10.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/operamasks-ui.js'/>"></script>

<link rel="stylesheet" type="text/css" href="<c:url value='/css/elegant/om-all.css'/>"> 
<link rel="stylesheet" type="text/css" href="<c:url value='/css/form.css'/>"> 
 

<script type="text/javascript">
function message(title,content){
	$.omMessageBox.alert({
	    title:title,
	    content:content,
	    onClose:function(value){
	    }
	});
}

</script>
</head>

<body>
</body>
</html>
		