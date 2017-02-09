<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="itemList" title="用户列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/user/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'id',width:60">用户ID</th>
        <th data-options="field:'nickname',width:200">昵称</th>
        <th data-options="field:'email',width:100">邮箱</th>
        <th data-options="field:'phone',width:100">电话</th>
        <th data-options="field:'state',width:60,align:'center',formatter:AZUtil.formatItemStatus">状态</th>
        <th data-options="field:'createTime',width:130,align:'center',formatter:AZUtil.formatDateTime">创建日期</th>
        <th data-options="field:'updateTime',width:130,align:'center',formatter:AZUtil.formatDateTime">更新日期</th>
    </tr>
    </thead>
</table>
<div id="userAddWindow" class="easyui-window" title="添加用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/page/user-add'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="itemEditWindow" class="easyui-window" title="编辑用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/page/user-edit'" style="width:80%;height:80%;padding:10px;">
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

    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
            $("#userAddWindow").window({
                onLoad :function(){
                    $("#userAddForm").form();
                }
            }).window("open");
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','必须选择一个用户才能编辑!');
                return ;
            }
            if(ids.indexOf(',') > 0){
                $.messager.alert('提示','只能选择一个用户!');
                return ;
            }

            $("#itemEditWindow").window({
                //加载回调函数
                onLoad :function(){
                    //回显数据
                    var data = $("#itemList").datagrid("getSelections")[0];
                    $("#itemeEditForm").form("load",data);
                }
            }).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','未选中用户!');
                return ;
            }
            $.messager.confirm('确认','确定删除ID为 '+ids+' 的用户吗？',function(r){
                if (r){
                    var params = {"ids":ids};
                    $.post("/user/delete",params, function(data){
                        if(data.status == 200){
                            $.messager.alert('提示','删除用户成功!',undefined,function(){
                                $("#itemList").datagrid("reload");
                            });
                        }
                    });
                }
            });
        }
    },'-',{
        text:'启用',
        iconCls:'icon-remove',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','未选中用户!');
                return ;
            }
            $.messager.confirm('确认','确定启用ID为 '+ids+' 的用户吗？',function(r){
                if (r){
                    var params = {"ids":ids};
                    $.post("/user/enable",params, function(data){
                        if(data.status == 200){
                            $.messager.alert('提示','用户激活成功!',undefined,function(){
                                $("#itemList").datagrid("reload");
                            });
                        }
                    });
                }
            });
        }
    },{
        text:'禁用',
        iconCls:'icon-remove',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','未选中用户!');
                return ;
            }
            $.messager.confirm('确认','禁用ID为 '+ids+' 的用户吗？',function(r){
                if (r){
                    var params = {"ids":ids};
                    $.post("/user/disable",params, function(data){
                        if(data.status == 200){
                            $.messager.alert('提示','用户禁用成功!',undefined,function(){
                                $("#itemList").datagrid("reload");
                            });
                        }
                    });
                }
            });
        }
    }];
</script>
