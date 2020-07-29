<%--
  Created by IntelliJ IDEA.
  User: talant潘泰荣
  Date: 2020/7/2
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>管理员的管理页面</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/default/easyui.css">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/icon.css">

    <%--下面三个js文件必须是按顺序进行，不能搞乱顺序--%>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">

        $(function () {

            /*jquery easyui的代码在这里写*/

        });

    </script>

</head>

<body class="easyui-layout" >

    <%--这是北边的区域用于显示系统的主标题--%>

    <div data-options="region:'north',split:true"
         style="mapping-left:10px; height:100px;font-size:46px;text-align: center;">基于ssm教材征订系统设计与应用
    </div>

    <%--这是南边的区域用于显示系统的版权相关的信息--%>

    <div data-options="region:'south',split:true" style="height:60px;"></div>

    <!-- 布局中的东边区域去掉    <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>    -->

    <%--这是西边的区域用于作为系统的侧边导航--%>

    <div data-options="region:'west',title:'管理员操作导航',split:true" style="width:210px;">


    </div>

    <%--这是中间区域用于显示我们操作中心--%>

    <div data-options="region:'center',title:'中心界面'" style="padding:5px;background:#eee;">

        <%--显示区域--%>

        <div id="tab"></div>

    </div>
</body>
</html>
