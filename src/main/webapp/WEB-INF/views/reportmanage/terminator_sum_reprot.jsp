<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>食堂应用汇总报表</title>
    <c:import url="../system/base.jsp"></c:import>
    <!-- view_source_begin -->
    <script type="text/javascript">
     $(document).ready(function() {

         $('.container').omCalendar();

     });

     
     
         $(function() {
            $('#grid').omGrid({
                limit:20,
                title : '食堂应用汇总报表',
                showIndex : false,  
                singleSelect : true,
                height:500,
                colModel :  [ {header : '受理终端号', name : 'terminator', width : 200, align : 'center'}, 
                              {header : '交易笔数', name : 'count', align : 'left', width : 100},
                              {header : '交易金额', name : 'amount', align : 'left', width : 100},
                              ],
				dataSource : ''
            });
            
           
           
            $('#query').bind('click', function(e) {
                var stime=$('#stime').val();
                var etime=$('#etime').val();
                $('#exp').attr("style","display:block,float:rigth");
                $('#grid').omGrid("setData", "<c:url value='/sys/manage/report/terminatorreport?stime=' />"+stime+'&etime='+etime);
            });
            
           
         
        })
        
        
    </script>
    <!-- view_source_end -->
</head>
<body>
 <div id="demo" style="margin-left:30px;margin-top:20px">
    <div id="tbdiv">
     <input id="stime" class="container" placeholder="起始时间"></input>
     --
     <input id="etime" class="container" placeholder="结束时间"></input>
     <input id="query" type="button" value="查询"/>
     <a id="exp" style="display:none" href="<c:url value='/sys/manage/report/download?expfilename=食堂应用汇总报表.xlsx'/>" >
     	<input id="exp" type="button" value="导出报表" >
     </a>
    </div>
    <table id="grid"></table>
    
    
    </div>
</body>
</html>