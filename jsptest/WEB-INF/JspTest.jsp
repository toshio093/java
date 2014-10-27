<%@ page contentType="text/html; charset=Shift_JIS" %>
<%@ taglib prefix="emp" uri="/WEB-INF/tld/taglib.tld" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JspTest</title>
</head>
<body>

<h1>JspTest.jsp</h1>

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