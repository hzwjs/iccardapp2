<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设备信息登记</title>
<c:import url="../system/base.jsp"></c:import>
<script type="text/javascript" src="<c:url value='/js/om-core.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/om-mouse.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/om-resizable.js'/>"></script>
<!-- view_source_begin -->
<style type="text/css">
input.error {
	border: 1px solid red;
}

body {
	font-size: 12px;
}

.om-button {
	font-size: 12px;
}

#nav_cont {
	width: 585px;
	margin-left: auto;
	margin-right: auto;
}

input {
	border: 1px solid #A1B9DF;
	vertical-align: middle;
	/* width: 96%; */
}

input:focus {
	border: 1px solid #3A76C2;
}

.om-calendar input:focus,.om-combo input:focus {
	border: none;
}

.sex {
	width: auto;
	border: none;
}

.sex:focus {
	border: none;
}

/* .input_slelct {
	width: 81%;
} */

.textarea_text {
	border: 1px solid #A1B9DF;
	height: 40px;
	width: 445px;
}

table.grid_layout tr td {
	font-weight: normal;
	height: 15px;
	padding: 5px 0;
	vertical-align: middle;
}

.color_red {
	color: red;
}

.toolbar {
	padding: 12px 0 5px;
	text-align: center;
}

.separator {
	border-top: 1px solid #adadad;
	height: 2px;
	line-height: 2px;
	overflow: hidden;
}

.address {
	width: 445px;
}

.om-span-field input:focus {
	border: none;
}

.errorImg {
	background: url("images/msg_bg.png") no-repeat scroll 0 0 transparent;
	height: 16px;
	width: 16px;
	cursor: pointer;
}

.errorMsg {
	border: 1px solid gray;
	background-color: #FCEFE3;
	display: none;
	position: absolute;
	margin-top: -18px;
	margin-left: 18px;
}

.display {
	color: gray;
	font-size: 13px;
}

.querycontent {
	color: blue;
	font-size: 12px;
	width: 500px;
}

#my-shadow {
	position: absolute;
	left: 50%;
	margin-left: -250px;
	top: 50%;
	margin-top: -190px;
	width: 100%;
	z-index: 100;
}

.shadow-fa {
	width: 80%;
	position: absolute;
	left: 50%;
	margin-left: -40%;
	top: 120px;
	z-index: 101;
	padding-bottom: 70px;
}

.received-set-span img {
	width: 60px;
	margin-bottom: -2px;
}
.edit{
/* background-color: #E9C2A6;
 background-color: #6B4226; */
 background-color: #CDCDCD;
}
</style>
<script type="text/javascript">
$(function() {
	
	$("#merchName").blur(function(){
		var merchname = $('#merchName').val();
		if (merchname==''||merchname=='undifend'||merchname==null) {
			showTimeoutTip('商户名称不能为空')
		}else{
			 qid = merchname;
	         $.ajax({
	      		url: "<c:url value='/sys/manage/merchant/details?qid='/>"+encodeURI(qid),
	      		type:'POST',
	      		success:function(result){
	      			var merchType = $("#merchType").val(result.merchType);
	      			var devAcct = $("#devAcct").val(result.signAcct);
	          		var devAcctName = $("#devAcctName").val(result.setAcctName);
	          		var phoneNo = $("#phoneNo").val(result.telNo);
	          		var posMerch = $("#posMerch").val(result.merchCode);
	          		var devBank = $("#devBank").val(result.merchBank);
	          		var signDate = $("#signDate").val(result.approveDate); 
	      		}
	      		});
		}

	});
});
	// 数据提交
	function submit() {
		var devCode = $("#devCode").val();
		var devIp = $("#devIp").val();
		var devType = $("#devType").val();
		var devState = $("select option:selected").val();
		var devDesc = $("#devDesc").val();
		var devAcct = $("#devAcct").val();
		var devAcctName = $("#devAcctName").val();
		var devModel = $("#devModel").val();
		var psamNo = $("#psamNo").val();
		var phoneNo = $("#phoneNo").val();
		var posMerch = $("#posMerch").val();
		var merchType = $("#merchType").val();
		var merchName = $("#merchName").val();
		var signDate1 = $("#signDate").val();
		var devBank = $("#devBank").val();
		/* if (!(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/.test(signDate1))) {
			message('提示', '签约日期格式为：2015/09/09');
			signDate1 = '';
			$("#signDate").focus();
		} else  */
		if (devCode.length < 1) {
			showTimeoutTip('设备ID不能为空');
			devCode = '';
			$("#devCode").focus();
		} else if (devType.length < 1) {
			showTimeoutTip('设备类型不能为空');
			devType = '';
			$("#devType").focus();
		} else  {
			$.ajax({
				url : CONTEXT_PATH + "/sys/manage/posDev/modify",
				method : "GET",
				data : {
					devCode : devCode,
					devIp : devIp,
					devType : devType,
					devState : devState,
					devDesc : devDesc,
					devAcct : devAcct,
					devAcctName : devAcctName,
					devModel : devModel,
					psamNo : psamNo,
					phoneNo : phoneNo,
					posMerch : posMerch,
					merchType : merchType,
					merchName : merchName,
					signDate1 : signDate1,
					devBank : devBank,
				},
				dataType : "json",
				success : function(result) {
					reset();
					alert(result.msg);
				}
			});

		}
	}
	// 重置
	function reset() {
		var devCode = $("#devCode").val("");
		var devIp = $("#devIp").val("");
		var devType = $("#devType").val("");
		var devState = $("#devState").val("");
		var devDesc = $("#devDesc").val("");
		var devAcct = $("#devAcct").val("");
		var devAcctName = $("#devAcctName").val("");
		var devModel = $("#devModel").val("");
		var psamNo = $("#psamNo").val("");
		var phoneNo = $("#phoneNo").val("");
		var posMerch = $("#posMerch").val("");
		var merchType = $("#merchType").val("");
		var merchName = $("#merchName").val("");
		var signDate = $("#signDate").val("");
		var devBank = $("#devBank").val("");
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
	<!-- view_source_begin -->
	<%-- <form id="formId" action="<c:url value='/sys/company/modify'/>" method="post">  --%>
	<div id="nav_cont">
		<form action="#" id="posDev">
			<table class="grid_layout">
			<tr>
					<td>商户编号：<span style="color: red; font-size: 14px">*</span></td>
					<td><input name="merchName" id="merchName" /></td>

					<td><span class="errorImg"></span><span class="errorMsg"></span></td>
					<td>商户类型：</td>
					<td><input name="merchType" id="merchType" class="edit" disabled="true"/></td>
				</tr>
				<tr>
					<td width="80px">设备ID：<span
						style="color: red; font-size: 14px">*</span></td>
					<td><input name="devCode" id="devCode" /></td>
					<td width="30px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td width="80px">设备IP：</td>
					<td><input name="devIp" id="devIp" /></td>
				</tr>
				<tr>
					<td>设备类型：<span style="color: red; font-size: 14px">*</span></td>
					<td><input name="devType" id="devType" /></td>
					<td><span class="errorImg"></span><span class="errorMsg"></span></td>
					<td>设备状态：</td>
					<td><select name="devState"><option value="1">开通</option><option value="2">冻结</option><option value="3">注销</option></td>
				</tr>
				<tr>
					<td>设备描述：</td>
					<td colspan="4"><input name="devDesc" id="devDesc" /></td>
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
					<td width="80px">账户：</td>
					<td><input name="devAcct" id="devAcct" class="edit" disabled="true"/></td>
					<td><span class="errorImg"></span><span class="errorMsg"></span></td>
					<td width="108px">账户名称：</td>
					<td><input name="devAcctName" id="devAcctName" class="edit" disabled="true"/></td>
				</tr>
				<tr>
					<td>联系电话：</td>
					<td><input name="phoneNo" id="phoneNo" class="edit" disabled="true"/></td>
					<td><span class="errorImg"></span><span class="errorMsg"></span></td>
					<td>pos商户：</td>
					<td><input name="posMerch" id="posMerch" class="edit" disabled="true"/></td>
				</tr>
				<tr>
					<td>分行号：</td>
					<td><input name="devBank" id="devBank" class="edit" disabled="true"/></td>
					<td><span class="errorImg"></span><span class="errorMsg"></span></td>
					<td>签约日期：</td>
					<td><input name="signDate" id="signDate" class="edit" disabled="true"/></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="omcombo-ct"
		style="position: absolute; display: none; left: 0;">
		<table id="target-table"></table>
	</div>
	<div class="toolbar">
		<button id="submit" onclick="submit()">提交</button>
		<button id="reset" type="reset" onclick="reset()">重置</button>
	</div>
	<div class="separator"></div>
	<!-- </form> -->

</body>
</html>