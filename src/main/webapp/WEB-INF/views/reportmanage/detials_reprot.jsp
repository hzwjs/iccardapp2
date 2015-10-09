<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>食堂IC卡应用明细表</title>
    <c:import url="../system/base.jsp"></c:import>
    <!-- view_source_begin -->
    <script type="text/javascript">
     $(document).ready(function() {

         $('.container').omCalendar();

     });

     
     
         $(function() {
            $('#grid').omGrid({
                limit:20,
                title : '食堂IC卡应用明细表',
                showIndex : false,  
                singleSelect : true,
                height:500,
                colModel :  [ {header : '卡号', name : 'cardno', align : 'left', width : 100},
                              {header : '户名', name : 'name', align : 'left', width : 100},
                              {header : '归属部门', name : 'department', align : 'left', width : 100},
                              {header : '交易笔数', name : 'count', align : 'left', width : 100},
                              {header : '交易金额', name : 'amount', align : 'left', width : 100},
                              {header : '受理终端号', name : 'terminator', width : 200, align : 'center'}, 
                              {header : '消费/圈存', name : 'type', align : 'left', width : 100},
                              {header : '是否成功', name : 'state', align : 'left', width : 100},
                              ],
				dataSource : ''
            });
            
           
           
            $('#query').bind('click', function(e) {
                var stime=$('#stime').val();
                var etime=$('#etime').val();
                $('#exp').attr("style","display:block,float:rigth");
                $('#grid').omGrid("setData", "<c:url value='/sys/manage/report/detialsreport?stime=' />"+stime+'&etime='+etime);
            });
            
           
         
        })
        
        
    </script>
    <!-- view_source_end -->
</head>
<body>
 <div id="demo" style="margin-left:30px;margin-top:20px">
    <div id="tbdiv">
     <input id="stime" class="container" placeholder="选择日期"></input>
     <input id="query" type="button" value="查询"/>
     <a id="exp" style="display:none" href="<c:url value='/sys/manage/report/download?expfilename=食堂IC卡应用明细表.xlsx'/>" >
     	<input id="exp" type="button" value="导出报表" >
     </a>
    </div>
    <table id="grid"></table>
    
    
    </div>
</body>
</html>