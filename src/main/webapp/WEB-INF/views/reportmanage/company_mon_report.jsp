<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>公司每月报表</title>
    <c:import url="../system/base.jsp"></c:import>
    <!-- view_source_begin -->
    
    <script type="text/javascript">
  
        $(function() {
            $('#grid').omGrid({
                limit:20,
                title : '公司每月报表',
                showIndex : false,  
                singleSelect : true,
                height:500,
                colModel :  [ {header : '公司名称', name : 'companyName', width : 200, align : 'center'}, 
                              {header : '月份', name : 'month', width : 150, align : 'left'},
                              {header : '消费人次', name : 'count', align : 'left', width : 120},
                              {header : '金额', name : 'amount', align : 'left', width : 100},
                              ],
				dataSource : ''
            });
            
           
          
            $('#query').bind('click', function(e) {
                var qmonth=$('#qmonth').val();
                $('#exp').attr("style","display:block,float:rigth");
                if(qmonth===""){ //没要有查询条件，要显示全部数据
                    $('#grid').omGrid("setData", "<c:url value='/sys/manage/report/companyreport?qmonth='/>"+'');
                }else{ //有查询条件，显示查询数据
                    $('#grid').omGrid("setData", "<c:url value='/sys/manage/report/companyreport?qmonth='/>"+encodeURI(qmonth));
                }
            });
            
            
        })
        
        
    </script>
    <!-- view_source_end -->
</head>
<body>
 <div id="demo" style="margin-left:30px;margin-top:20px">
		<div id="tbdiv">
			<input id="qmonth" placeholder="查询的月份"></input> 
			<input id="query" type="button" value="查询" />
			 <a id="exp" style="display: none"
				href="<c:url value='/sys/manage/report/download?expfilename=公司每月报表.xlsx'/>">
				<input id="exp" type="button" value="导出报表" />
			</a>
		</div>
		<table id="grid"></table>
    
    
    </div>
</body>
</html>