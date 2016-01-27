<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="utf-8">
  <title>MyEmp List</title>
</head>
<body>
<div align="center">
  <h1>ORACLEJAVA CONNUMITY EMP LIST</h1>
  <table boarder="1">
    <th>empno</th>
    <th>ename</th>
    <th>addr</th>
    <c:forEach var="myemp" items="${emplist}" varStatus="status">
      <tr>
        <td>${myemp.empno}</td>
        <td>${myemp.ename}</td>
        <td>${myemp.addr}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
