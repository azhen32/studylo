<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
    <a id="openBtn" class="easyui-linkbutton" data-options="iconCls:'icon-add'">展开</a>
    <a id="closeBtn" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">关闭</a>
    <!-- 树型控件 -->
    <ul id="contentCategory" class="easyui-tree">
    </ul>
</div>
<!-- 右键菜单 -->
<div id="contentCategoryMenu" class="easyui-menu" style="width:120px;" data-options="onClick:menuHandler"> <!-- 菜单点击事件 -->
    <div data-options="iconCls:'icon-add',name:'add'">添加</div>
    <div data-options="iconCls:'icon-edit',name:'rename'">重命名</div>
    <div class="menu-sep"></div>
    <div data-options="iconCls:'icon-remove',name:'delete'">删除</div>
</div>
<script type="text/javascript">
    function setParentChecked(node) {
        console.log(node);
    }

    function getSelectionsIds(){
        var contentCategory = $("#contentCategory");
        var sels = contentCategory.tree('getChecked','checked');
        console.log(sels);
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].id);
        }
        ids = ids.join(",");
        return ids;
    }

    function openTree(node) {
        node = $(node);
        //console.log(node.tree('options'));
      /*  var options = $(node.tree('options'));
        options.attr('state','open');*/
        node.tree('expandAll');

        //var $childs = node.tree('getChildren');
        //console.log($childs);
        /*for(var i = 0, len = $childs.length; i < len; i ++) {
            openTree($childs[i]);
        }*/
    }

    function closeTree(node) {
        node = $(node);
        node.tree('collapseAll');
    }

    $(function(){

        $("#openBtn").bind('click',function () {
           openTree($("#contentCategory"));
        });
        $("#contentCategory").tree({
            url : '/user/role/authority/list',
            animate: true,
            checkbox: true,
            method : "GET",
            onCheck: function (node,checked) {
                setParentChecked(node);
                //console.log(getSelectionsIds());
            },
            onContextMenu: function(e,node){
                e.preventDefault();
                $(this).tree('select',node.target);
                $('#contentCategoryMenu').menu('show',{
                    <!-- 右键菜单显示位置 -->
                    left: e.pageX,
                    top: e.pageY
                });
            },
            onAfterEdit : function(node){
                var _tree = $(this);
                if(node.id == 0){
                    // 新增节点
                    $.post("/user/role/authority/create",{parentId:node.parentId,displayName:node.text},function(data){
                        if(data.status == 200){
                            _tree.tree("update",{
                                target : node.target,
                                id : data.data.id
                            });
                        }else{
                            $.messager.alert('提示','创建'+node.text+' 分类失败!');
                        }
                    });
                }else{
                    $.post("/user/role/authority/update",{id:node.id,displayName:node.text});
                }
            }
        });
    });
    function menuHandler(item){
        var tree = $("#contentCategory");
        var node = tree.tree("getSelected");
        if(item.name === "add"){
            tree.tree('append', {
                parent: (node?node.target:null),
                data: [{
                    text: '新建分类',
                    id : 0,
                    parentId : node.id
                }]
            });
            var _node = tree.tree('find',0);
            tree.tree("select",_node.target).tree('beginEdit',_node.target);
        }else if(item.name === "rename"){
            tree.tree('beginEdit',node.target);
        }else if(item.name === "delete"){
            $.messager.confirm('确认','确定删除名为 '+node.text+' 的分类吗？',function(r){
                if(r){
                    $.post("/user/role/authority/delete",{parentId:node.parentId,id:node.id},function(){
                        tree.tree("remove",node.target);
                    });
                }
            });
        }
    }
</script>