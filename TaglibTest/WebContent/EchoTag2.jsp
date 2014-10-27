<%@ page contentType="text/html; charset=Shift_JIS" %>
<%@ taglib prefix="emp" uri="/WEB-INF/tld/taglib.tld" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>

<html>
<head>
<title>EchoTag2.jsp</title>
</head>
<body>

<h1>EchoTag2.jsp</h1>

<p>
<emp:search>
<jsp:body>
  <userFilters>
    <logic:iterate id="userFilter" name="userFilters" >
      <userFilter>
        <logic:notEmpty name="userFilter" property="layerCode">
          <layerCode>
            <bean:write name="userFilter" property="layerCode"/>
          </layerCode>
        </logic:notEmpty>
        <logic:notEmpty name="userFilter" property="pstnCodes">
          <logic:iterate id="pstnCode" name="userFilter" property="pstnCodes" >
            <pstnCode>
              <bean:write name="pstnCode"/>
            </pstnCode>
          </logic:iterate>
        </logic:notEmpty>
      </userFilter>
    </logic:iterate>
  </userFilters>
</jsp:body>
</emp:search>
</p>
</body>
</html>
