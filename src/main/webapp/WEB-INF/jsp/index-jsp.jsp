<%@ page contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<%@ include file="head.jspf" %>
<body>
<div class="container">
  <div class="pb-2 mt-4 mb-3 border-bottom">
    <h1><spring:message code="example.title"/> - JSP</h1>
  </div>
  <c:forEach items="${presentations}" var="item">
    <div class="card mb-3 shadow-sm rounded">
      <div class="card-header">
        <h5 class="card-title"><c:out value="${item.title}"/> - <c:out value="${item.speakerName}"/></h5>
      </div>
      <div class="card-body">
          <c:out value="${item.summary}" escapeXml="false"/>
      </div>
    </div>
  </c:forEach>
</div>
<%@ include file="scripts.jspf" %>
</body>
</html>
