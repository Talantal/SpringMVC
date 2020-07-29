<%--
  Created by IntelliJ IDEA.
  User: talant潘泰荣
  Date: 2020/7/3
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/default/easyui.css">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/icon.css">

    <%--下面三个js文件必须是按顺序进行，不能搞乱顺序--%>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/classse.js"></script>

    <script type="text/javascript">

        $(function () {

            initclassse();

        });

    </script>

</head>

<body>

<div id="tab"></div>

</body>

</html>
