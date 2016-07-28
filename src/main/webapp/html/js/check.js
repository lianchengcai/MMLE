$(document).ready(function() {
	$("#detail").hide();
	$("#change").hide();
	query();
});

function first() {
	var currentPage =$("#currentPage").text();
	if (currentPage!= 1) {
		$("#currentPage").text(1);
		query();
	} else {
		alert("当前页为首页");
	}
}
function up() {
	var currentPage =$("#currentPage").text();
	if (currentPage!= 1) {
		$("#currentPage").text(+currentPage-1);
		query();
	} else {
		alert("当前页为首页");
	}
}
function down() {
	var currentPage =$("#currentPage").text();
	if (currentPage!= $("#totalPage").text()) {
		$("#currentPage").text(+currentPage+1);
		query();
	} else {
		alert("当前页为最后一页");
	}
}
function last() {
	var currentPage =$("#currentPage").text();
	if (currentPage!= $("#totalPage").text()) {
		$("#currentPage").text($("#totalPage").text());
		query();
	} else {
		alert("当前页为最后一页");
	}
}
function find(checkId) {
	var data = new Object();
	var check = new Object();
	data.check = check;
	check.checkId = checkId;
	$("#list").hide();
	$("#detail").show();
	$.ajax({
		url : "http://127.0.0.1:8082/mmle/getCheck.do",
		type : "post",
		async : false,
		contentType : "application/json",
		data : JSON.stringify(data),
		dataType : "json",
		success : function(json) {
			var checks = json.checks;
			check = checks[0];
			var boatImage = check.boatImage;
			var manImage = check.manImage;
			if (boatImage != null) {
				$("#boatImage").attr("src", "../../" + boatImage);
			}
			if (manImage != null) {
				$("#manImage").attr("src", "../../" + manImage);
			}
			$("#type").val(check.type);
			$("#boat").val(check.boat.boatName);
			$("#checkMan").val(check.checkMan);
			$("#checkTime").val(check.checkTime);
			$("#title1").val(check.title);
			if (check.nationality) {
				$("#nationality").val("是");
			} else {
				$("#nationality").val("否");
			}
			if (check.boatCheck) {
				$("#boatCheck").val("是");
			} else {
				$("#boatCheck").val("否");
			}
			if (check.fishing) {
				$("#fishing").val("是");
			} else {
				$("#fishing").val("否");
			}
			if (check.sailing) {
				$("#sailing").val("是");
			} else {
				$("#sailing").val("否");
			}
			if (check.boater) {
				$("#boater").val("是");
			} else {
				$("#boater").val("否");
			}
			if (check.chiefEngineer) {
				$("#chiefEngineer").val("是");
			} else {
				$("#chiefEngineer").val("否");
			}
			if (check.satelliteNavigation) {
				$("#satelliteNavigation").val("是");
			} else {
				$("#satelliteNavigation").val("否");
			}
			if (check.radar) {
				$("#radar").val("是");
			} else {
				$("#radar").val("否");
			}
			if (check.ssb) {
				$("#ssb").val("是");
			} else {
				$("#ssb").val("否");
			}
			if (check.compass) {
				$("#compass").val("是");
			} else {
				$("#compass").val("否");
			}
		}
	});
}
function change(checkId) {
	var data = new Object();
	var check = new Object();
	data.check = check;
	check.checkId = checkId;
	$("#list").hide();
	$("#change").show();
	$.ajax({
		url : "http://127.0.0.1:8082/mmle/getCheck.do",
		type : "post",
		async : false,
		contentType : "application/json",
		data : JSON.stringify(data),
		dataType : "json",
		success : function(json) {
			var checks = json.checks;
			check = checks[0];
			var boat = check.boat;
			var cas = check.cas;
			$("#boat1").text(boat.boatName);
			$("#boat3").text(boat.boatName);
			$("#content1").text(check.content);
			$("#rule").text(cas.violateRule);
			$("#base").text(cas.basisPunishment);
			$("#content2").text(check.content);
			var dt = new Date();
			var y = dt.getFullYear();
			var h = dt.getMonth() + 1;
			var m = dt.getDate();
			$("#time").html(y + "年" + h + "月" + m + "日");
		}
	});
}
function query() {
	var data = new Object();
	data.currentPage = $("#currentPage").text();
	data.size = 14;
	var type = $("#type_but").val();
	var title = $("#title_but").val();
	var checkMan = $("#check_man_but").val();
	var check = new Object();
	data.check = check;
	if (type != null && type != "") {
		check.type = type;
		data.currentPage=1;
	}
	if (title != null && title != "") {
		check.title = title;
		data.currentPage=1;
	}
	if (checkMan != null && checkMan != "") {
		check.checkMan = checkMan;
		data.currentPage=1;
	}
	$
			.ajax({
				url : "http://127.0.0.1:8082/mmle/getCheck.do",
				type : "post",
				async : false,
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : "json",
				success : function(json) {
					if (json.checks.length==0) {
						$("#TableData").html("");
						alert("没有查到数据！");
					}else{
//					alert(JSON.stringify(json));
//					alert(json.checks.length);
					var checks = json.checks;
					var html = "";
					for (var i = 0; i < checks.length; i++) {
						var boat = checks[i].boat;
						html += ("<tr class='TableDetail1 template' align='center'>");
						html += ("<td>" + checks[i].type + "</td>");
						if (boat != null) {
							if (boat.boatName != null)
								html += ("<td>" + boat.boatName + "</td>");
						} else {
							html += ("<td></td>");
						}
						html += ("<td>" + checks[i].title + "</td>");
						html += ("<td>" + checks[i].checkMan + "</td>");
						html += ("<td>" + checks[i].content + "</td>");
						html += ("<td>" + checks[i].location + "</td>");
						html += ("<td>" + checks[i].checkTime + "</td>");
						html += ("<td>");
						html += ("<a onclick='find(" + checks[i].checkId + ")'>查看详情</a>");
						if (!checks[i].state) {
							html += ("&nbsp;");
							html += ("<a onclick='change(" + checks[i].checkId + ")'>查看通知单</a>");
						}
						html += ("</td>");
						html += ("</tr>");
					}
					$("#TableData").html(html);
					$("#currentPage").text(json.currentPage);
					$("#totalPage").text(json.totalPage);
					$("#totalPage").hide();
				}
				}
			})
}