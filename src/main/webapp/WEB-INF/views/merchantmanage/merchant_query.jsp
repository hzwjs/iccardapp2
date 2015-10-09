<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>商户查询</title>
    <c:import url="../system/base.jsp"></c:import>
    <!-- view_source_begin -->
    <style>
    </style>
     <script type="text/javascript">
     $(document).ready(function() {

 		$('.container').omCalendar();

 	});
 
        $(function() {
            $('#grid').omGrid({
                limit:20,
                title : '商户信息列表',
                showIndex : false,  
                singleSelect : true,
                height:500,
                colModel :  [ {header : '商户编号', name : 'merchCode', width : 150, align : 'left'},
                              {header : '商户名称', name : 'merchName', width : 150, align : 'left'},
                              {header : '商户种类', name : 'merchZl', width : 100, align : 'center'}, 
                              {header : '商户类型', name : 'merchType', align : 'left', width : 120},
                              {header : '商户状态', name : 'state', align : 'left', width : 100},
                              {header : '交易类型', name : 'tradeType', align : 'left', width : 100},
                              {header : '清算账号', name : 'signAcct', align : 'left', width : 100},
                              {header : '清算账号名称', name : 'setAcctName', align : 'left', width : 80},
                              {header : '营业执照编号', name : 'regCode', align : 'center', width : 80},
                              {header : '税务登记证号', name : 'taxNo', align : 'left', width : 80},
                              ],
				dataSource : "<c:url value='/sys/manage/merchant/page'/>"
            });
            
            var dialog = $("#dialog-form").omDialog({
                width: 1000,
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
            	reset();
                rowData = rowData || {};
                qid = rowData.merchCode;
                $.ajax({
             		url: "<c:url value='/sys/manage/merchant/details?qid='/>"+encodeURI(qid),
             		type:'POST',
             		success:function(result){
             			var rowId = $("#rowId").val(result.rowId);
                 		var merchCode = $("#merchCode").val(result.merchCode);
                 		
             		 	var merchZl = $("#merchZl").val(result.merchZl);
                 		var merchName = $("#merchName").val(result.merchName);
                 		var merchType = $("#merchType").val(result.merchType);
                 		var approveDate = $("#approveDate").val(result.approveDate); 
                 		
                 		var signAcct = $("#signAcct").val(result.signAcct);
                 		var setAcctName = $("#setAcctName").val(result.setAcctName);
                 		var merchBank = $("#merchBank").val(result.merchBank);
                 		var merchDesc = $("#merchDesc").val(result.merchDesc);
                 		
                 	 	var postCode = $("#postCode").val(result.postCode);
                 		var regCode = $("#regCode").val(result.regCode);
                 		var taxNo = $("#taxNo").val(result.taxNo);
                 		var orgNo = $("#orgNo").val(result.orgNo);
                 		  
                 	 	var manager = $("#manager").val(result.manager);
                 		var regtelNoCode = $("#telNo").val(result.telNo);
                 		var busScope = $("#busScope").val(result.busScope);
                 		var state = $("#state").val(result.state);  
                 		
                 	 	var areaCode = $("#areaCode").val(result.areaCode);
                 		var shortName = $("#shortName").val(result.shortName);
                 		var branch = $("#branch").val(result.branch);
                 		var branchName = $("#branchName").val(result.branchName);  
                 		
                 	 	var tradeType = $("#tradeType").val(result.tradeType);
                 		var isthk = $("#isthk").val(result.isthk);
                 		var forgnFlag = $("#forgnFlag").val(result.forgnFlag);
                 		var fxjb = $("#fxjb").val(result.fxjb);
                 		  
                 		 var legalPersonName = $("#legalPersonName").val(result.legalPersonName);
                 		var legalPersonId = $("#legalPersonId").val(result.legalPersonId);
                 		var terminalMobileNo = $("#terminalMobileNo").val(result.terminalMobileNo);
                 		var terminalFixedNo = $("#terminalFixedNo").val(result.terminalFixedNo);  
                 		 
                 		var custManager = $("#custManager").val(result.custManager);
                 		var custManagerNo = $("#custManagerNo").val(result.custManagerNo);
                 		var custManagerPhone = $("#custManagerPhone").val(result.custManagerPhone);
                 		var isCollect = $("#isCollect").val(result.isCollect);
                 		
                 		var isReal = $("#isReal").val(result.isReal);
                 		var rateDiscount = $("#rateDiscount").val(result.rateDiscount);
                 		var rateDiscountDateBegin = $("#rateDiscountDateBegin").val(result.rateDiscountDateBegin);
                  		var rateDiscountDateEnd = $("#rateDiscountDateEnd").val(result.rateDiscountDateEnd);  
                  		
                  		 var atmLmt = $("#atmLmt").val(result.atmLmt);
                  		var cshLmt = $("#cshLmt").val(result.cshLmt);
                  		var tsfLmt = $("#tsfLmt").val(result.tsfLmt);
                  		var bindphone = $("#bindphone").val(result.bindphone);
                  		var atmDayTotl = $("#atmDayTotl").val(result.atmDayTotl);
                  		var cshDayTotl = $("#cshDayTotl").val(result.cshDayTotl);
                  		var tsfDayTotl = $("#tsfDayTotl").val(result.tsfDayTotl);  
             		}
             		});
                
                dialog.omDialog("option", "title", title);
                dialog.omDialog("open");//显示dialog
            };
            
            //dialog中点提交按钮时将数据提交到后台并执行相应的add或modify操作
            var submitDialog = function(){
            	
                if (validator.form()) {
	                var submitData={
	                	rowId:$("input[name='rowId']",dialog).val(),
	                	merchCode:$("input[name='merchCode']",dialog).val(),
		                	
	               	 	merchZl:$("select[name='merchZl']",dialog).val(),
	                	merchName:$("input[name='merchName']",dialog).val(),
	                	merchType:$("input[name='merchType']",dialog).val(),
	                	approveDate1:$("input[name='approveDate']",dialog).val(),
	                	
	                	signAcct:$("input[name='signAcct']",dialog).val(),
	                	setAcctName:$("input[name='setAcctName']",dialog).val(),
	                	merchBank:$("input[name='merchBank']",dialog).val(),
	                	merchDesc:$("input[name='merchDesc']",dialog).val(),
	                    
	                	postCode:$("input[name='postCode']",dialog).val(),
	                	regCode:$("input[name='regCode']",dialog).val(),
	                	taxNo:$("input[name='taxNo']",dialog).val(),
	                	orgNo:$("input[name='orgNo']",dialog).val(),
	                	
	                	manager:$("input[name='manager']",dialog).val(),
	                	telNo:$("input[name='telNo']",dialog).val(),
	                	busScope:$("input[name='busScope']",dialog).val(),
	                	state:$("select[name='state']",dialog).val(),
	                	
	                	areaCode:$("input[name='areaCode']",dialog).val(),
	                	shortName:$("input[name='shortName']",dialog).val(),
	                	branch:$("input[name='branch']",dialog).val(),
	                	branchName:$("input[name='branchName']",dialog).val(),
	                	
	                	tradeType:$("select[name='tradeType']",dialog).val(),
	                	isthk:$("select[name='isthk']",dialog).val(),
	                	forgnFlag:$("select[name='forgnFlag']",dialog).val(),
	                	fxjb:$("select[name='fxjb']",dialog).val(),
	                	
	                	legalPersonName:$("input[name='legalPersonName']",dialog).val(),
	                	legalPersonId:$("input[name='legalPersonId']",dialog).val(),
	                	terminalMobileNo:$("input[name='terminalMobileNo']",dialog).val(),
	                	terminalFixedNo:$("input[name='terminalFixedNo']",dialog).val(),
	                	
	                	custManager:$("input[name='custManager']",dialog).val(),
	                	custManagerNo:$("input[name='custManagerNo']",dialog).val(),
	                	custManagerPhone:$("input[name='custManagerPhone']",dialog).val(),
	                	isCollect:$("select[name='isCollect']",dialog).val(),
	                	
	                	isReal:$("select[name='isReal']",dialog).val(),
	                	rate:$("input[name='rate']",dialog).val(),
	                	rateDiscountDateBegin1:$("input[name='rateDiscountDateBegin']",dialog).val(),
	                	rateDiscountDateEnd1:$("input[name='rateDiscountDateEnd']",dialog).val(),
	                	
	                	atmLmt:$("input[name='atmLmt']",dialog).val(),
	                	cshLmt:$("input[name='cshLmt']",dialog).val(),
	                	tsfLmt:$("input[name='tsfLmt']",dialog).val(),
	                	bindphone:$("input[name='bindphone']",dialog).val(),
	                	
	                	atmDayTotl:$("input[name='atmDayTotl']",dialog).val(),
	                	cshDayTotl:$("input[name='cshDayTotl']",dialog).val(),
	                	tsfDayTotl:$("input[name='tsfDayTotl']",dialog).val(),
	                };
	                if(!(/^((((19|20)\d{2})-(0?(1|[3-9])|1[012])-(0?[1-9]|[12]\d|30))|(((19|20)\d{2})-(0?[13578]|1[02])-31)|(((19|20)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-29))$/).test($('#approveDate').val())){
	                	showTimeoutTip("日期格式不对");
	                }else{
	                	$.post("<c:url value='/sys/manage/merchant/modify'/>",submitData,function(){
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
            
         // 重置
        	function reset() {
        		var merchZl = $("merchZl").val("");
        		var merchName = $("#merchName").val("");
        		var merchType = $("#merchType").val("");
        		var approveDate1 = $("#approveDate").val("");

        		var signAcct = $("#signAcct").val("");
        		var setAcctName = $("#setAcctName").val("");
        		var merchBank = $("#merchBank").val("");
        		var merchDesc = $("#merchDesc").val("");

        		var postCode = $("#postCode").val("");
        		var regCode = $("#regCode").val("");
        		var taxNo = $("#taxNo").val("");
        		var orgNo = $("#orgNo").val("");

        		var manager = $("#manager").val("");
        		var telNo = $("#telNo").val("");
        		var busScope = $("#busScope").val("");
        		var state = $("#state").val("");

        		var areaCode = $("#areaCode").val("");
        		var shortName = $("#shortName").val("");
        		var branch = $("#branch").val("");
        		var branchName = $("#branchName").val("");

        		var tradeType = $("#tradeType").val("");
        		var isthk = $("#isthk").val("");
        		var forgnFlag = $("#forgnFlag").val("");
        		var fxjb = $("#fxjb").val("");

        		var legalPersonName = $("#legalPersonName").val("");
        		var legalPersonId = $("#legalPersonId").val("");
        		var terminalMobileNo = $("#terminalMobileNo").val("");
        		var terminalFixedNo = $("#terminalFixedNo").val("");

        		var custManager = $("#custManager").val("");
        		var custManagerNo = $("#custManagerNo").val("");
        		var custManagerPhone = $("#custManagerPhone").val("");
        		var isCollect = $("#isCollect").val("");

        		var isReal = $("#isReal").val("");
        		var rate = $("#rate").val("");
        		var rateDiscountDateBegin1 = $("#rateDiscountDateBegin").val("");
        		var rateDiscountDateEnd1 = $("#rateDiscountDateEnd").val("");

        		var atmLmt = $("#atmLmt").val("");
        		var cshLmt = $("#cshLmt").val("");
        		var tsfLmt = $("#tsfLmt").val("");
        		var bindphone = $("#bindphone").val("");

        		var atmDayTotl = $("#atmDayTotl").val("");
        		var cshDayTotl = $("#cshDayTotl").val("");
        		var tsfDayTotl = $("#tsfDayTotl").val("");
        	}
         
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
                    var toDeleteRecordID=selections[0].rowId;
                    $.post("<c:url value='/sys/manage/merchant/delete'/>",{operation:'delete',rowId:toDeleteRecordID},function(result){
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
                    $('#grid').omGrid("setData", "<c:url value='/sys/manage/merchant/page'/>");
                }else{ //有查询条件，显示查询数据
                    $('#grid').omGrid("setData", "<c:url value='/sys/manage/merchant/page?qname='/>"+encodeURI(qName));
                }
            });
            
            // 对表单进行校验
            var validator = $('#ipForm').validate({
                rules : {
                	operator : {required: true}, 
                	name : {required : true},
                	pwd :{required : true},
                	lev:{maxlength:10},
                	branchCode :{required : true,maxlength:4},
                	telNo:{maxlength:16},
                	areaCode:{maxlength:4},
                	areadigit:{maxlength:4},
                	
                }, 
                messages : {
                	operator : {required : "登录名不能为空"},
                	name : {required : "ID不能为空"},
                	pwd :{required : "密码不能为空"},
                	lev:{maxlength:"等级不能大于10位"},
                    branchCode :{required : "类型不能为空",maxlength:"分行号不能大于4位"},
                    telNo:{maxlength:"电话号码不能大于16位"},
                    areaCode:{maxlength:"地区编码不能大于4位"},
                    areadigit:{maxlength:"areadigit不能大于4位"},
                }
            });
            
        });
        
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
       <!--  <input id="create" type="button" value="新增"/> -->
        <input id="modify" type="button" value="修改"/>
      <!--   <input id="details" type="button" value="详情"/> -->
        <input id="delete" type="button" value="删除"/>
        商户名称(模糊查询，为空时显示全部)：<input id="qname"></input>
        <input id="query" type="button" value="查询"/>
    </div>
    <table id="grid"></table>
    <div id="au_user"></div>
    
    <div id="dialog-form">
        <form id="ipForm">
 	        <table class="grid_layout">
 	         <tr style="display:none">
					<td>rowId：</td>
					<td><input name="rowId" id="rowId" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>商户编号：</td>
					<td><input name="merchCode" id="merchCode" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
				</tr>
	           <tr>
					<td>商户种类：</td>
					<td><select name="merchZl"><option value="1">传统pos商户</option></select></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>商户名称：</td>
					<td><input name="merchName" id="merchName" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>商户类型(mcc码)：</td>
					<td><input name="merchType" id="merchType" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>申请时间：</td>
					<td><input name="approveDate" id="approveDate" class="container"></input></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
				</tr>
				<tr>
					<td>清算账号(卡号)：</td>
					<td><input name="signAcct" id="signAcct" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>清算账户名称：</td>
					<td><input name="setAcctName" id="setAcctName" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>开户银行：</td>
					<td><input name="merchBank" id="merchBank" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>商户地址：</td>
					<td><input name="merchDesc" id="merchDesc" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
				</tr>
				<tr>
					<td>行政村：</td>
					<td><input name="postCode" id="postCode" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>营业执照编号：</td>
					<td><input name="regCode" id="regCode" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>税务登记证号：</td>
					<td><input name="taxNo" id="taxNo" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>组织机构代码证号：</td>
					<td><input name="orgNo" id="orgNo" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
				</tr>
				<tr>
					<td>联系人姓名：</td>
					<td><input name="manager" id="manager" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>联系电话：</td>
					<td><input name="telNo" id="telNo" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>商户经营范围：</td>
					<td><input name="busScope" id="busScope" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>商户状态：</td>
					<td><select name="state"><option value="1">开通</option></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
				</tr>
				<tr>
					<td>收单机构编号：</td>
					<td><input name="areaCode" id="areaCode" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>收单机构名称：</td>
					<td><input name="shortName" id="shortName" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>维护支行：</td>
					<td><input name="branch" id="branch" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>维护支行名：</td>
					<td><input name="branchName" id="branchName" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
				</tr>
				<tr>
					<td>交易类型：</td>
					<td><select name="tradeType"><option value="1">消费</option></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>是否允许退货手续费：</td>
					<td><select name="isthk"><option value="1">是</option>
							<option value="2">否</option></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>外币收单标志：</td>
					<td><select name="forgnFlag"><option value="1">是</option>
							<option value="2">否</option></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>风险级别：</td>
					<td><select name="fxjb"><option value="1">低风险</option></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
				</tr>
				<tr>
					<td>法人姓名：</td>
					<td><input name="legalPersonName" id="legalPersonName" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>法人身份证号：</td>
					<td><input name="legalPersonId" id="legalPersonId" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>移动终端申请台数：</td>
					<td><input name="terminalMobileNo" id="terminalMobileNo" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>固定终端申请台数：</td>
					<td><input name="terminalFixedNo" id="terminalFixedNo" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
				</tr>
				<tr>
					<td>客户经理：</td>
					<td><input name="custManager" id="custManager" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>客户经理号：</td>
					<td><input name="custManagerNo" id="custManagerNo" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>客户经理电话：</td>
					<td><input name="custManagerPhone" id="custManagerPhone" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>pos押金减免</td>
					<td><select name="isCollect"><option value="1">是</option>
							<option value="2">否</option></td>
				</tr>
				<tr>
					<td>费率优惠申请：</td>
					<td><select name="isReal"><option value="1">是</option>
							<option value="2">否</option></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>优惠折率：</td>
					<td><input name="rate" id="rate" /></td>
					<td>%</td>
					<td>费率优惠申请时间：</td>
					<td><input name="rateDiscountDateBegin"
						id="rateDiscountDateBegin" class="container" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>费率优惠到期时间：</td>
					<td><input name="rateDiscountDateEnd" id="rateDiscountDateEnd"
						class="container" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
				</tr>
				<tr>
					<td>交易每笔限额：</td>
					<td><input name="atmLmt" id="atmLmt" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>现金交易每笔限额：</td>
					<td><input name="cshLmt" id="cshLmt" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>转账交易每笔限额：</td>
					<td><input name="tsfLmt" id="tsfLmt" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>绑定电话：</td>
					<td><input name="bindphone" id="bindphone" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
				</tr>
				<tr>
					<td>交易日限额：</td>
					<td><input name="atmDayTotl" id="atmDayTotl" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>现金交易日限额：</td>
					<td><input name="cshDayTotl" id="cshDayTotl" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>转账交易日限额：</td>
					<td><input name="tsfDayTotl" id="tsfDayTotl" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
				</tr>
	        </table>
	        
        </form>
    </div>
    </div>
</body>
</html>