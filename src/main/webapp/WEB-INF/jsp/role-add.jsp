<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="easyui-panel" title="Nested Panel" data-options="width:'100%',minHeight:500,noheader:true,border:false" style="padding:10px;">
	<div class="easyui-layout" data-options="fit:true">
		<div id = "authTree" data-options="region:'west',split:false" style="width:250px;padding:5px">

		</div>
		<div style="padding:10px 10px 10px 10px">
			<form id="roleAddForm" class="itemForm" method="post">
				<table cellpadding="5">
					<tr>
						<td>权限名:</td>
						<td><input class="easyui-textbox" type="text" name="nickname" data-options="required:true" style="width: 280px;"></td>
					</tr>
				</table>
				<input type="hidden" name="authIds"/>
			</form>
			<div style="padding:5px">
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		$("#authTree").panel({
			href : "/page/auth-category"
		});
	});

	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#roleAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}

		var paramJson = [];
		$("#roleAddForm .params li").each(function(i,e){
			var trs = $(e).find("tr");
			var group = trs.eq(0).text();
			var ps = [];
			for(var i = 1;i<trs.length;i++){
				var tr = trs.eq(i);
				ps.push({
					"k" : $.trim(tr.find("td").eq(0).find("span").text()),
					"v" : $.trim(tr.find("input").val())
				});
			}
			paramJson.push({
				"group" : group,
				"params": ps
			});
		});
		//把json对象转换成字符串
		paramJson = JSON.stringify(paramJson);
		$("#roleAddForm [name=itemParams]").val(paramJson);

		$.post("/user/role/save",$("#roleAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增角色成功!');
			}
		});
	}

	function clearForm(){
		$('#roleAddForm').form('reset');
	}
</script>
