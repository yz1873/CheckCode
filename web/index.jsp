<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/9 0009
  Time: 下午 8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>验证码的制作</title>
    <style type="text/css">
      .box{
        width:450px;
        height: 150px;
        margin: 50px auto;
        border: double;
      }
      input{
        width: 70px;
      }
      ul{
        list-style: none;
        padding-left: 0px;
      }
      .textbox{
        text-align: center;
        margin-top: 25px;
      }
      .btbox{
        text-align: center;
        margin-top: 25px;
      }
    </style>
    <script type="text/javascript">
      function reloadCode(){
        var time = new Date().getTime(); //加入时间参数，缓存才会认为是不同请求
        document.getElementById("imagecode").src = "<%=request.getContextPath()%>/servlet/ImageServlet?d="+time;//点击时重新请求servlet获取新的图片
      }
    </script>
  </head>
  <body>
    <div class="box">
      <form class="checkbox" action="<%=request.getContextPath()%>/servlet/CheckServlet" method="get">
        <ul>
          <li class="textbox">
            验证码：<input type="text" name="checkcode"/>   //验证码输入框
            <img alt="验证码" id="imagecode" src="<%=request.getContextPath()%>/servlet/ImageServlet"/>
            <a href="javascript:reloadCode();">看不清楚</a>
          </li>
          <li class="btbox">
            <input class="bt" type="submit" value="提交">
          </li>
        </ul>
      </form>
    </div>
  </body>
</html>
