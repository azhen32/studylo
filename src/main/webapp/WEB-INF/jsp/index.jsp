<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Moocs后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="css/taotao.css" />
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript">
       /* function addTab(title, url){
            if ($('#tabs').tabs('exists', title)){
                $('#tabs').tabs('select', title);
            } else {
                var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
                $('#tabs').tabs('add',{
                    title:title,
                    content:content,
                    closable:true
                });
            }
        }*/
       $(function(){
           $('#menu').tree({
               onClick: function(node){
                   if($('#menu').tree("isLeaf",node.target)){
                       var tabs = $("#tabs");
                       var tab = tabs.tabs("getTab",node.text);
                       if(tab){
                           tabs.tabs("select",node.text);
                       }else{
                           tabs.tabs('add',{
                               title:node.text,
                               href: node.attributes.url,
                               closable:true,
                               bodyCls:"content"
                           });
                       }
                   }
               }
           });
       });
    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'west',title:'菜单',split:true" style="width:180px;">
    <div title="系统配置" selected="true" >
        <ul id="menu" class="easyui-tree" >
            <li>
                <span>系统配置</span>
                <ul id="tt2" class="easyui-tree" >
                    <li>
                        <span>用户相关</span>
                        <ul id="tt3" class="easyui-tree" >
                            <%--<li><a  onclick="addTab('用户管理','http://www.baidu.com')"><span>用户管理</span></a></li>--%>
                                <li data-options="attributes:{'url':'user-list'}">用户管理</li>
                            <li><a onclick="addTab('角色管理','http://www.bing.com')"><span>角色管理</span></a></li>
                            <li><a onclick="addTab('权限管理','http://www.csdn.com')"><span>权限管理</span></a></li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>

</div>
<div id="mainPanel" data-options="region:'center'">
    <div id="tabs" class="easyui-tabs" fit="true" border="false">
        <div title="首页" style="padding:20px;">

        </div>
    </div>
</div>
</body>
</html>