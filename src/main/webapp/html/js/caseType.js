$(document).ready(function() {
		alert("123");
		query();
	});
	function del(typeId) {
		alert(typeId);
	    if (confirm("你确定删除吗？")) {  
	    	var data = new Object();
			var caseType = new Object();
			data.caseType = caseType;
			caseType.typeId = typeId;
			$.ajax({
				url : "http://127.0.0.1:8082/mmle/deleteCaseType.do",
				type : "post",
				async : false,
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : "json",
				success : function(json) {
					alert(JSON.stringify(json));
					if (json.code==1) {
						alert("已删除");
						query();
					}
				}
			});
	    }
    }  
	
	function addNew() {
		var data = new Object();
		var caseType = new Object();
		data.caseType = caseType;
	    var name = prompt("请输入修改的内容", ""); //将输入的内容赋给变量 name ，  
	    //这里需要注意的是，prompt有两个参数，前面是提示的话，后面是当对话框出来后，在对话框里的默认值  
	    if (name.replace(/\s+/g,""))//如果返回的有内容  
	    {  
	    	data.caseType.name = name;
			$.ajax({
				url : "http://127.0.0.1:8082/mmle/addCaseType.do",
				type : "post",
				async : false,
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : "json",
				success : function(json) {
					alert(JSON.stringify(json));
					if (json.code==1) {
						alert("已添加");
						query();
					}
				}
			});
	       } else {
			alert("请输入增加的内容！");
		} 
	  
	}
	function edit(typeId) {
		alert(typeId);
		var data = new Object();
		var caseType = new Object();
		data.caseType = caseType;
		caseType.typeId = typeId;
	    var name = prompt("请输入修改的内容", ""); //将输入的内容赋给变量 name ，  
	    //这里需要注意的是，prompt有两个参数，前面是提示的话，后面是当对话框出来后，在对话框里的默认值  
	    if (name.replace(/\s+/g,""))//返回的内容并去掉空格
	    {  
	    	data.caseType.name = name;
			$.ajax({
				url : "http://127.0.0.1:8082/mmle/updateCaseType.do",
				type : "post",
				async : false,
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : "json",
				success : function(json) {
					alert(JSON.stringify(json));
					if (json.code==1) {
						alert("已修改");
						query();
					}
				}
			});
	       } else {
			alert("请输入修改的内容！");
		} 
	  
	}
	function query() {
		alert("查询");
		$.ajax({
			url : "http://127.0.0.1:8082/mmle/getCaseType.do",
			type : "post",
			async : false,
			contentType : "application/json",
			dataType : "json",
			success : function(json) {
				alert(JSON.stringify(json));
				alert(json.caseTypes.length);
				var caseTypes = json.caseTypes;
				var html = "";
				for (var i = 0; i < caseTypes.length; i++) {
					var caseType = caseTypes[i].caseType;
					html += ("<tr class='TableDetail1 template' align='center'>");
					html += ("<td>" + caseTypes[i].name + "</td>");
					html += ("<td>");
					html += ("<a onclick='del(" + caseTypes[i].typeId + ")'>删除</a>");
						html += ("&nbsp;");
						html += ("<a onclick='edit(" + caseTypes[i].typeId + ")'>修改</a>");
					html += ("</td>");
					html += ("</tr>");
				}
				$("#TableData").html(html);
			}
		})
	}