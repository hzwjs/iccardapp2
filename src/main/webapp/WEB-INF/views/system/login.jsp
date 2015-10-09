<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<TITLE>欢迎您登录张家港农村商业银行--IC卡应用系统</TITLE>
<c:import url="base.jsp"></c:import>
<style type="text/css">
button {
	background: #3299CC;
	padding-top: 3px;
	border-top: 1px solid #708090;
	border-right: 1px solid #708090;
	border-bottom: 1px solid #708090;
	border-left: 1px solid #708090;
	width: 120px;
	height: auto;
	font-size: 10pt;
	text-align: center;
}
</style>
<script>

	$(function() {
		$("#loginSubmit").click(function() {
			var loginname = $("#loginname").val();
			var password = $("#password").val();

			if (loginname.length < 4) {
				message('提示','操作员号的长度应不少于四位');
				loginname = '';
				$("#loginname").focus();
			}else if (password.length < 4) {
				message('提示','密码的长度应不少于四位');
				password = '';
				$("#password").focus();
			}else if (!(/^[A-Za-z0-9]+$/.test(password))) {
				message('提示','密码只能由英文字母和数字组成');
				password = '';
				$("#password").focus();
			}else{
				$.ajax({
					url : "<c:url value='/sys/login'/>",
					method : "POST",
					data : {
						operator : loginname,
						pwd : password
					},
					success : function(result) {
						if (result.code == 0) {
							window.location.href = "<c:url value='/sys/toHome'/>";
						} else {
							alert(result.msg);
						}
					}
				})
			}
		})
	});
	
	
	// IE兼容
	
	
	$(function() {
		// Invoke the plugin
		$('input, textarea').placeholder({
			customClass : 'my-placeholder'
		});
		// That’s it, really.
		// Now display a message if the browser supports placeholder natively
		var html;
		if ($.fn.placeholder.input && $.fn.placeholder.textarea) {
			html = '<strong>Your current browser natively supports <code>placeholder</code> for <code>input</code> and <code>textarea</code> elements.</strong> The plugin won’t run in this case, since it’s not needed. If you want to test the plugin, use an older browser ;)';
		} else if ($.fn.placeholder.input) {
			html = '<strong>Your current browser natively supports <code>placeholder</code> for <code>input</code> elements, but not for <code>textarea</code> elements.</strong> The plugin will only do its thang on the <code>textarea</code>s.';
		}
		if (html) {
			$('<p class="note">' + html + '</p>').insertAfter('form');
		}
	});
</script>
</head>
<body>
	<TABLE cellSpacing=0 cellPadding=0 width=804 align=center border=0>
		<TBODY>
			<TR>
				<TD width=10>
					<TABLE height=500 cellSpacing=0 cellPadding=0 width=10
						background="<c:url value='/images/loginleftbj.jpg'/>" border=0>
						<TBODY>
							<TR>
								<TD height=14><img height=14
									src="<c:url value='/images/loginbj1.jpg'/>" width=10 /></TD>
							</TR>
							<TR>
								<TD>&nbsp;</TD>
							</TR>
						</TBODY>
					</TABLE>
				</TD>
				<TD vAlign=top><TABLE height=80 cellSpacing=0 cellPadding=0
						width="100%" background="<c:url value='/images/logintopbj.jpg'/>"
						border=0>
						<TBODY>
							<TR>
								<TD vAlign=top width="40%"><DIV align=center>
										<img height=78 src="<c:url value='/images/loginlogo.PNG'/>"
											width=264 />
									</DIV></TD>
								<TD width="28%">&nbsp;</TD>
								<TD width="32%"><TABLE cellSpacing=0 cellPadding=0
										width="100%" border=0>
										<TBODY>
											<TR>
												<TD>&nbsp;</TD>
											</TR>
											<TR>
												<TD align="left"><DIV align=center class="pt14-blue"
														style="">张家港农商行IC卡应用系统</DIV></TD>
											</TR>
										</TBODY>
									</TABLE></TD>
							</TR>
						</TBODY>
					</TABLE>
					<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
						<TBODY>
							<TR>
								<TD><DIV align=center>
										<img src="<c:url value='/images/fkcxbanner.jpg'/>" width="765"
											height="100">
									</DIV></TD>
							</TR>
							<TR>
								<TD height=5></TD>
							</TR>
						</TBODY>
					</TABLE>
					<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
						<TBODY>
							<TR>
								<TD vAlign=top width=400><TABLE height=195 cellSpacing=0
										cellPadding=0 width="100%" border=0>
										<TBODY>
											<TR>
												<TD height=5>&nbsp;</TD>
											</TR>
											<TR>
												<TD height="256" colspan="2" align="center">
													<TABLE height=25 cellSpacing=0 cellPadding=0 width=296
														align=center border=0>
														<TBODY>
															<TR>
																<TD height=28><SPAN class=STYLE5>注意事项: </SPAN></TD>
															</TR>

															<TR>
																<TD style="LINE-HEIGHT: 24px">系统功能包括：操作员管理、商户管理、机构管理、</TD>
															</TR>
															<TR>
																<TD style="LINE-HEIGHT: 24px">&nbsp;&nbsp;&nbsp;帐务管理、统计报表等。</TD>
															</TR>
															<TR>
																<TD height=20>&nbsp;</TD>
															</TR>
														</TBODY>
													</TABLE>



													<TABLE height=1 cellSpacing=0 cellPadding=0 width="75%"
														align=center border=0>
														<TBODY>
															<TR>
																<TD bgColor=#adadad height=1></TD>
															</TR>
														</TBODY>
													</TABLE>
												</TD>
											</TR>
										</TBODY>
									</TABLE></TD>
								<TD vAlign=top><TABLE cellSpacing=0 cellPadding=0 width=360
										border=0>
										<TBODY>
											<TR>
												<TD id=qywy-putongLoginhead style="DISPLAY: block" width=110><IMG
													id=qywy-normalImg style="CURSOR: hand" height=33
													src="<c:url value='/images/putonglogin-bt1.jpg'/>"
													width=110 border=0 name=qywy-normalImg></TD>
												<TD bgcolor="#5595D2" id=khpt-putongLoginhead><IMG
													id=qywy-certImg style="CURSOR: hand" height=33
													src="<c:url value='/images/sa.jpg'/>" width=183 border=0
													name=qywy-certImg></TD>
												<TD width="121"
													background="<c:url value = 'images/loginmenubj.jpg'/>">&nbsp;</TD>
											</TR>
										</TBODY>
									</TABLE>
									<TABLE height=200 cellSpacing=0 cellPadding=0 width=384
										border=0>
										<TBODY>
											<TR>
												<TD width=360 height="200" vAlign=top
													background=images/loginbj.jpg><TABLE height=20
														cellSpacing=0 cellPadding=0 width=275 border=0>
														<TBODY>
															<TR>
																<TD>&nbsp;</TD>
															</TR>
														</TBODY>
													</TABLE>

													<TABLE height=80 cellSpacing=0 cellPadding=0 width=268
														align=center border=0>
														<TBODY>
															<TR>
																<TD width="1" class=blue14>&nbsp;</TD>
																<TD width="84" height=25 class=login>登录名：</TD>
																<TD width="173" height=25><span
																	style="margin-right: 10px; float: left; margin: 0; padding: 0; line-height: 34px; line-width: 152px;">
																		<input type="text" id="loginname" tabindex="100"
																		placeholder="您的用户名/手机号/邮箱"
																		style="width: 152px; height: 34px; line-height: normal; border-color: #d5d5d5; border-radius: 3px; padding: 2px 3px; border: 1px #bbb solid; margin: 0;">
																</span></TD>
															</TR>
															<TR>
																<TD class=blue14></TD>
																<TD class=login>登陆密码：</TD>
																<TD><span
																	style="margin-right: 10px; float: left; margin: 0; padding: 0; line-height: 34px; line-width: 152px;">
																		<input type="password" id="password" tabindex="101"
																		placeholder="您的密码"
																		style="width: 152px; height: 34px; line-height: normal; border-color: #d5d5d5; border-radius: 3px; padding: 2px 3px; border: 1px #bbb solid; margin: 0;">
																</span></TD>
															</TR>
														</TBODY>
													</TABLE>


													<TABLE height=30 cellSpacing=0 cellPadding=0 width=168
														align=center border=0>
														<TBODY>
															<TR>
																<TD>
																	<DIV align=right>
																		<!-- 	<a id="loginSubmit"> <span
																			style="border-radius: 2px; width: 65px; height: 37px; background-color: #3299CC; float: left; margin-left: 110px; line-height: 37px; text-align: center; font-weight: bold; color: #ffffff">
																				登录 </span>
																		</a> -->
																		<button id="loginSubmit">登录</button>
																	</DIV>
																</TD>
															</TR>
														</TBODY>
													</TABLE></TD>
												<TD vAlign=top id=qywy-bannerbj style="DISPLAY: block"><TABLE
														height=153 cellSpacing=0 cellPadding=0 width="100%"
														background=images/qywyloginbannerbj.jpg border=0>
														<TBODY>
															<TR>
																<TD>&nbsp;</TD>
															</TR>
														</TBODY>
													</TABLE></TD>
											</TR>
										</TBODY>
									</TABLE>
									<TABLE height=3 cellSpacing=0 cellPadding=0 width=360 border=0>
										<TBODY>
											<TR>
												<TD><IMG height=3
													src="<c:url value='/loginbottombj.jpg'/>" width=360></TD>
											</TR>
										</TBODY>
									</TABLE></TD>
							</TR>
						</TBODY>
					</TABLE>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="25" align="right">张家港农村商业银行</td>
							<td width="20" align="right">&nbsp;</td>
						</tr>
					</table></TD>
				<TD width=10>
					<TABLE height=500 cellSpacing=0 cellPadding=0 width=10
						background=images/loginrightbj.jpg border=0>
						<TBODY>
							<TR>
								<TD height=14><IMG height=14
									src="<c:url value='/images/loginbj2.jpg'/>" width=10></TD>
							</TR>
							<TR>
								<TD>&nbsp;</TD>
							</TR>
						</TBODY>
					</TABLE>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	<TABLE height=18 cellSpacing=0 cellPadding=0 width=804 align=center
		background="<c:url value = '/images/loginfootbj.jpg'/>" border=0>
		<TBODY>
			<TR>
				<TD width=20><IMG height=18
					src="<c:url value='/images/loginbj3.jpg'/>" width=20></TD>
				<TD>&nbsp;</TD>
				<TD width=20><IMG height=18
					src="<c:url value='/images/loginbj4.jpg'/>" width=20></TD>
			</TR>
		</TBODY>
	</TABLE>

	</script>
</body>
</html>
