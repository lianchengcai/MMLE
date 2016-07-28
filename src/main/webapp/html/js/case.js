$(document).ready(function() {
		$("#edit").hide();
		$("#addNew").hide();
		query();
	});
function result(code) {
	if (code == 1) {
		alert("已修改");
		query();
	}
	if (code==101) {
		alert("失败，该类别名称已存在！");
	}
	if (code==0) {
		alert("失败!");
	}
}
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
//num传入的数字，n需要的字符长度
function PrefixInteger(num, n) {
    return (Array(n).join(0) + num).slice(-n);
}
	function del(caseId) {
	    if (confirm("你确定删除吗？")) {  
	    	var data = new Object();
			var cas = new Object();
			data.cas = cas;
			cas.caseId = caseId;
			$.ajax({
				url : "http://127.0.0.1:8082/mmle/deleteCaseInfo.do",
				type : "post",
				async : false,
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : "json",
				success : function(json) {
					if (json.code==1) {
						alert("已删除");
						query();
					}
				}
			});
	    }
    }  
	
	function saveq() {
		var data = new Object();
		var cas = new Object();
		data.cas = cas;
		cas.caseId = $("#caseId").val();
		cas.caseType = new Object();
		cas.caseType.typeId=$("#case_type ").val().replace(/\s+/g,"");
		cas.caseName = $("#caseName").val().replace(/\s+/g,"");
		cas.violateRule=$("#violateRule").val().replace(/\s+/g,"");
		cas.basisPunishment=$("#basisPunishment").val().replace(/\s+/g,"");
		cas.typePunishment=$("#typePunishment").val().replace(/\s+/g,"");
		if (cas.caseName==""||cas.violateRule==""||cas.basisPunishment==""||cas.typePunishment=="") {
			alert("请填写完整信息!");
			return false
		}else {
			$.ajax({
				url : "http://127.0.0.1:8082/mmle/updateCaseInfo.do",
				type : "post",
				async : false,
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : "json",
				success : function(json) {
					if (json.code==1) {
						alert("保存成功！");
						query();
					}
				}
			});
		}
	}
	
	function addNew() {
		$("#list").hide();
		$("#addNew").show();
		$.ajax({
			url : "http://127.0.0.1:8082/mmle/getCaseType.do",
			type : "post",
			async : false,
			contentType : "application/json",
			//data : JSON.stringify(data),
			dataType : "json",
			success : function(json) {
			//	alert(JSON.stringify(json));
				$("#caseType").empty();//先清空
				for (var i = 0; i < json.caseTypes.length; i++) {
					var option = $("<option>").text(json.caseTypes[i].name).val(json.caseTypes[i].typeId);
					$("#caseType").append(option);
				}
				$("#caseType").val(json.caseTypes[0].typeId);
			}
		});
	}
	function saveN() {
 		var data = new Object();
		data.cas = new Object();
		data.cas.caseType = new Object();
		data.cas.caseType.typeId = $("#caseType").val().replace(/\s+/g,"");
		data.cas.caseName = $("#case_name").val().replace(/\s+/g,"");
		data.cas.violateRule=$("#violate_rule").val().replace(/\s+/g,"");
		data.cas.basisPunishment=$("#basis_punishment").val().replace(/\s+/g,"");
		data.cas.typePunishment=$("#type_punishment").val().replace(/\s+/g,"");
//		if (data.cas.caseType.typeId==null&&data.cas.caseType.typeId==""&&data.cas.caseName==null&&data.cas.caseName==""&&data.cas.violateRule==null&&data.cas.violateRule==""&&data.cas.basisPunishment==null&&data.cas.basisPunishment==""&&data.cas.typePunishment==null&&data.cas.typePunishment=="") {
		if (data.cas.caseName==""||data.cas.violateRule==""||data.cas.basisPunishment==""||data.cas.typePunishment=="") {
			alert("请填写完整信息!");
			return false
		}else {
			$.ajax({
				url : "http://127.0.0.1:8082/mmle/addCaseInfo.do",
				type : "post",
				async : false,
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : "json",
				success : function(json) {
					if (json.code==1) {
						alert("添加成功");
						query();
					}else {
						alert("添加失败");
					}
				}
			});
		}
	}

	function edit(caseId) {
		$("#list").hide();
		$("#edit").show();
		var data = new Object();
		var cas = new Object();
		data.cas = cas;
		cas.caseId = caseId;
	    //这里需要注意的是，prompt有两个参数，前面是提示的话，后面是当对话框出来后，在对话框里的默认值  
			$.ajax({
				url : "http://127.0.0.1:8082/mmle/getCaseInfo.do",
				type : "post",
				async : false,
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : "json",
				success : function(json) {
					//alert(JSON.stringify(json));
					var cases = json.cases;
					cas = cases[0];
					var id = PrefixInteger(cas.caseId,5);
					$("#caseId").val(id);
					var caseTypes = json.caseTypes;
					$("#case_type").empty();//先清空
					for (var i = 0; i < caseTypes.length; i++) {
						var option = $("<option>").text(caseTypes[i].name).val(caseTypes[i].typeId);
						$("#case_type").append(option);
					}
					$("#case_type ").val(cas.caseType.typeId);
					//$("#case_type option[text=cas.caseType.name]").attr("selected", true);
					//$("#case_type").find("option[text='cas.caseType.name']").attr("selected","selected");
					$("#caseName").val(cas.caseName);
					$("#violateRule").val(cas.violateRule);
					$("#basisPunishment").val(cas.basisPunishment);
					$("#typePunishment").val(cas.typePunishment);
				}
			});
	}
	function query() {
		$("#list").show();
		$("#edit").hide();
		$("#addNew").hide();
		var data = new Object();
		data.currentPage = $("#currentPage").text();
		data.size = 2;
		$.ajax({
			url : "http://127.0.0.1:8082/mmle/getCaseInfo.do",
			type : "post",
			async : false,
			contentType : "application/json",
			data : JSON.stringify(data),
			dataType : "json",
			success : function(json) {
//				alert(JSON.stringify(json));
//				alert(json.caseTypes.length);
				var cases = json.cases;
				if (cases.length==0) {
					$("#TableData").html("");
					alert("没有查到数据！");
				}else{
				var html = "";
				for (var i = 0; i < cases.length; i++) {
					var cas = cases[i];
					var caseType = cas.caseType;
					var id = PrefixInteger(cas.caseId,5);
					html += ("<tr class='TableDetail1 template' align='center'>");
					html += ("<td>" + id + "</td>");
					html += ("<td>" + caseType.name + "</td>");
					html += ("<td>" + cas.caseName + "</td>");
					html += ("<td>");
					html += ("<a onclick='edit(" + cas.caseId + ")'>编辑</a>");
						html += ("&nbsp;");
						html += ("<a onclick='del(" + cas.caseId + ")'>删除</a>");
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