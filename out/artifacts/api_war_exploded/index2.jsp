<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %><%--
  Created by IntelliJ IDEA.
  User: yyj
  Date: 2021-08-10
  Time: 오후 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="style.css" rel="stylesheet" type="text/css">
    <style>
        h1 {
            color:navy; font-size:32px;
        }
    </style>
    <title>버스 정류장</title>
</head>
<body>
<form>
    <div>
        <table border="1" cellpadding="5px">
            <thead>
            <tr>
                <h1>버스 정류장 승하차 인원 통계</h1>
                <th bgcolor="#7fffd4">mobileId</th>
                <th bgcolor="#7fffd4">stationId</th>
                <th bgcolor="#7fffd4">stationName</th>
                <th bgcolor="#7fffd4">searchDate</th>
                <th bgcolor="#7fffd4">location</th>
                <th bgcolor="#7fffd4">5시</th>
                <th bgcolor="#7fffd4">6시</th>
                <th bgcolor="#7fffd4">7시</th>
                <th bgcolor="#7fffd4">8시</th>
                <th bgcolor="#7fffd4">9시</th>
                <th bgcolor="#7fffd4">10시</th>
                <th bgcolor="#7fffd4">11시</th>
                <th bgcolor="#7fffd4">12시</th>
                <th bgcolor="#7fffd4">13시</th>
                <th bgcolor="#7fffd4">14시</th>
                <th bgcolor="#7fffd4">15시</th>
                <th bgcolor="#7fffd4">16시</th>
                <th bgcolor="#7fffd4">17시</th>
                <th bgcolor="#7fffd4">18시</th>
                <th bgcolor="#7fffd4">19시</th>
                <th bgcolor="#7fffd4">20시</th>
                <th bgcolor="#7fffd4">21시</th>
                <th bgcolor="#7fffd4">22시</th>
                <th bgcolor="#7fffd4">23시</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="row" items="${list}">
            <tr>
                <td>${row.mobileId}</td>
                <td>${row.stationId}</td>
                <td>${row.stationName}</td>
                <td>${row.searchDate}</td>
                <td>${row.location}</td>
                <td>${row.hour_5}</td>
                <td>${row.hour_6}</td>
                <td>${row.hour_7}</td>
                <td>${row.hour_8}</td>
                <td>${row.hour_9}</td>
                <td>${row.hour_10}</td>
                <td>${row.hour_11}</td>
                <td>${row.hour_12}</td>
                <td>${row.hour_13}</td>
                <td>${row.hour_14}</td>
                <td>${row.hour_15}</td>
                <td>${row.hour_16}</td>
                <td>${row.hour_17}</td>
                <td>${row.hour_18}</td>
                <td>${row.hour_19}</td>
                <td>${row.hour_20}</td>
                <td>${row.hour_21}</td>
                <td>${row.hour_22}</td>
                <td>${row.hour_23}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</form>
</body>
</html>
