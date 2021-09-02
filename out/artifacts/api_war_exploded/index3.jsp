<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %><%--
<%--
  Created by IntelliJ IDEA.
  User: yyj
  Date: 2021-08-11
  Time: 오후 5:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="style.css" rel="stylesheet" type="text/css">
    <style>
        h1 {
            color: navy;
            font-family: "휴먼모음T";
        }
        table{
            border: gray;
            font-family: "휴먼모음T";
        }
        th {
            font-size: 1.5rem;
        }
        td{
            color: whitesmoke;
            background-color: darkblue;
            text-align: center;
        }
        td:hover{
            color: yellow;
        }
        #key {
            color: whitesmoke;
            background-color: darkgreen;
        }
        #stationId {
            background-color: limegreen;
        }
        #stationName {
            background-color: dodgerblue;
        }
        </style>
    <title>정류장 검색 결과</title>
</head>
<body>
<form>
    <div>
        <h1>대구 북구 동천동</h1>
        <table border="1">
            <tr>
                <th id="stationId">정류장 아이디</th>
                <th id="stationName">정류장 이름</th>
            </tr>
            <tbody>
            <c:forEach var="row" items="${result}">
                <tr>
                    <td id="key">${row.key}</td>
                    <td>${row.value}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</form>
</body>
</html>
