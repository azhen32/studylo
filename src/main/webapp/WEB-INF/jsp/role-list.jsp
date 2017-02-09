<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="easyui-datagrid" id="contentList"
       data-options="toolbar:contentListToolbar,singleSelect:false,collapsible:true,pagination:true,method:'get',pageSize:30,url:'/user/role/list'">
    <thead>
    <tr>
        <th data-options="field:'id',width:30">ID</th>
        <th data-options="field:'name',width:120">角色名</th>
        <th data-options="field:'state',width:100">状态</th>
    </tr>
    </thead>
</table>

<div id="roleAddWindow" class="easyui-window" title="添加用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/page/role-add'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="itemEditWindow" class="easyui-window" title="编辑用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/page/role-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>
    function getSelectionsIds(){
        var itemList = $("#itemList");
        var sels = itemList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].id);
        }
        ids = ids.join(",");
        return ids;
    }

    var contentListToolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
            $("#roleAddWindow").window({
                onLoad :function(){
                    $("#roleAddForm").form();
                }
            }).window("open");
        }
    }];
</script>
