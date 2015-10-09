<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商户信息登记</title>
<c:import url="../system/base.jsp"></c:import>

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
	width: auto;
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
</style>
<script type="text/javascript">
	$(document).ready(function() {

		$('.container').omCalendar();

	});

	// 数据提交
	function submit() {

		var merchZl = $("select option:selected").val();
		var merchName = $("#merchName").val();
		var merchType = $("#merchType").val();
		var approveDate1 = $("#approveDate").val();

		var signAcct = $("#signAcct").val();
		var setAcctName = $("#setAcctName").val();
		var merchBank = $("#merchBank").val();
		var merchDesc = $("#merchDesc").val();

		var postCode = $("#postCode").val();
		var regCode = $("#regCode").val();
		var taxNo = $("#taxNo").val();
		var orgNo = $("#orgNo").val();

		var manager = $("#manager").val();
		var telNo = $("#telNo").val();
		var busScope = $("#busScope").val();
		var state = $("select option:selected").val();

		var areaCode = $("#areaCode").val();
		var shortName = $("#shortName").val();
		var branch = $("#branch").val();
		var branchName = $("#branchName").val();

		var tradeType = $("select option:selected").val();
		var isthk = $("select option:selected").val();
		var forgnFlag = $("select option:selected").val();
		var fxjb = $("select option:selected").val();

		var legalPersonName = $("#legalPersonName").val();
		var legalPersonId = $("#legalPersonId").val();
		var terminalMobileNo = $("#terminalMobileNo").val();
		var terminalFixedNo = $("#terminalFixedNo").val();

		var custManager = $("#custManager").val();
		var custManagerNo = $("#custManagerNo").val();
		var custManagerPhone = $("#custManagerPhone").val();
		var isCollect = $("select option:selected").val();

		var isReal = $("select option:selected").val();
		var rate = $("#rate").val();
		var rateDiscountDateBegin1 = $("#rateDiscountDateBegin").val();
		var rateDiscountDateEnd1 = $("#rateDiscountDateEnd").val();

		var atmLmt = $("#atmLmt").val();
		var cshLmt = $("#cshLmt").val();
		var tsfLmt = $("#tsfLmt").val();
		var bindphone = $("#bindphone").val();

		var atmDayTotl = $("#atmDayTotl").val();
		var cshDayTotl = $("#cshDayTotl").val();
		var tsfDayTotl = $("#tsfDayTotl").val();
		if (merchName.length < 1) {
			message('提示', '商户名称不能为空');
			merchName = '';
			$("#merchName").focus();
		}else if (merchBank.length < 1) {
			message('提示', '开户银行不能为空');
			merchBank = '';
			$("#merchBank").focus();
		}else if (approveDate1.length < 1) {
			message('提示', '申请日期不能为空');
			approveDate1 = '';
			$("#approveDate").focus();
		} else if(!(/^((((19|20)\d{2})-(0?(1|[3-9])|1[012])-(0?[1-9]|[12]\d|30))|(((19|20)\d{2})-(0?[13578]|1[02])-31)|(((19|20)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-29))$/).test(approveDate1)){
			showTimeoutTip("日期格式不对")
		}else if (!(/(\d{1}\.\d{2})+$/.test(rate))) {
			message('提示', '优惠折率格式为:0.00');
			rate = '';
			$("#rate").focus();
		}else if (!(/(\d{1,14}\.\d{2})+$/.test(atmLmt))) {
			message('提示', '交易每笔限额格式为:0.00');
			atmLmt = '';
			$("#atmLmt").focus();
		} else if (!(/(\d{1,14}\.\d{2})+$/.test(cshLmt))) {
			message('提示', '现金交易每笔限额格式为:0.00');
			cshLmt = '';
			$("#cshLmt").focus();
		} 
		else if (!(/(\d{1,14}\.\d{2})+$/.test(tsfLmt))) {
			message('提示', '转账交易每笔限额格式为:0.00');
			tsfLmt = '';
			$("#tsfLmt").focus();
		} 
		else if (!(/(\d{1,14}\.\d{2})+$/.test(atmDayTotl))) {
			message('提示', '交易日限额格式为:0.00');
			atmDayTotl = '';
			$("#atmDayTotl").focus();
		} 
		else if (!(/(\d{1,14}\.\d{2})+$/.test(cshDayTotl))) {
			message('提示', '现金交易日限额格式为:0.00');
			cshDayTotl = '';
			$("#cshDayTotl").focus();
		} 
		else if (!(/(\d{1,14}\.\d{2})+$/.test(tsfDayTotl))) {
			message('提示', '转账交易日限额格式为:0.00');
			tsfDayTotl = '';
			$("#tsfDayTotl").focus();
		} else if (postCode.length > 6) {
			message('提示', '行政村的长度应小于6位');
			postCode = '';
			$("#postCode").focus();
		}else{
			$.ajax({
				url : CONTEXT_PATH + "/sys/manage/merchant/modify",
				method : "GET",
				data : {
					merchZl : merchZl,
					merchName : merchName,
					merchType : merchType,
					approveDate1 : approveDate1,

					signAcct : signAcct,
					setAcctName : setAcctName,
					merchBank : merchBank,
					merchDesc : merchDesc,

					postCode : postCode,
					regCode : regCode,
					taxNo : taxNo,
					orgNo : orgNo,

					manager : manager,
					telNo : telNo,
					busScope : busScope,
					state : state,

					areaCode : areaCode,
					shortName : shortName,
					branch : branch,
					branchName : branchName,

					tradeType : tradeType,
					isthk : isthk,
					forgnFlag : forgnFlag,
					fxjb : fxjb,

					legalPersonName : legalPersonName,
					legalPersonId : legalPersonId,
					terminalMobileNo : terminalMobileNo,
					terminalFixedNo : terminalFixedNo,

					custManager : custManager,
					custManagerNo : custManagerNo,
					custManagerPhone : custManagerPhone,
					isCollect : isCollect,

					isReal : isReal,
					rate : rate,
					rateDiscountDateBegin1 : rateDiscountDateBegin1,
					rateDiscountDateEnd1 : rateDiscountDateEnd1,

					atmLmt : atmLmt,
					cshLmt : cshLmt,
					tsfLmt : tsfLmt,
					bindphone : bindphone,

					atmDayTotl : atmDayTotl,
					cshDayTotl : cshDayTotl,
					tsfDayTotl : tsfDayTotl,
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
		<form action="#" id="merch">
			<table class="grid_layout">
				<tr>
					<td>商户种类：<span style="color: red; font-size: 14px">*</span></td>
					<td><select name="merchZl">
							<option value="1">传统pos商户</option>
							<option value="2">助农取款商户</option>
							<option value="3">特约商户</option>
							<option value="4">理财商户</option>
							<option value="5">业主收款商户</option>
							<option value="6">银商pos商户</option>
						</select>
					</td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>商户名称：<span style="color: red; font-size: 14px">*</span></td>
					<td><input name="merchName" id="merchName" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>商户类型(mcc码)：</td>
					<td><input name="merchType" id="merchType" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>申请时间：<span style="color: red; font-size: 14px">*</span></td>
					<td><input id="approveDate" class="container"></input></td>
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
					<td>开户银行：<span style="color:red;font-size:14px">*</span></td>
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
					<td><select name="state">
						<option value="1">开通</option>
						<option value="2">冻结</option>
						<option value="3">注销</option>
					</select>
					</td>
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
					<td><select name="tradeType">
						<option value="1">转账</option>
						<option value="2">消费</option>
						<option value="3">代收付</option>
					</select>
					</td>
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
					<td><select name="fxjb">
						<option value="1">低风险</option>
						<option value="2">中风险</option>
						<option value="3">高风险</option>
					</select>
					</td>
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
					<td>优惠折率：<span style="color:red;font-size:14px">*</span></td>
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
					<td>交易每笔限额：<span style="color:red;font-size:14px">*</span></td>
					<td><input name="atmLmt" id="atmLmt" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>现金交易每笔限额：<span style="color:red;font-size:14px">*</span></td>
					<td><input name="cshLmt" id="cshLmt" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>转账交易每笔限额：<span style="color:red;font-size:14px">*</span></td>
					<td><input name="tsfLmt" id="tsfLmt" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>绑定电话：</td>
					<td><input name="bindphone" id="bindphone" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
				</tr>
				<tr>
					<td>交易日限额：<span style="color:red;font-size:14px">*</span></td>
					<td><input name="atmDayTotl" id="atmDayTotl" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>现金交易日限额：<span style="color:red;font-size:14px">*</span></td>
					<td><input name="cshDayTotl" id="cshDayTotl" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
					<td>转账交易日限额：<span style="color:red;font-size:14px">*</span></td>
					<td><input name="tsfDayTotl" id="tsfDayTotl" /></td>
					<td width="20px"><span class="errorImg"></span><span
						class="errorMsg"></span></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="toolbar">
		<button id="submit" onclick="submit()">提交</button>
		<button id="reset" type="reset" onclick="reset()">重置</button>
	</div>
	<div class="separator"></div>
	<!-- </form> -->

</body>
</html>