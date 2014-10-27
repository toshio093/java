<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="emp" uri="/WEB-INF/tld/taglib.tld" %>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>

<%! Map<String ,String>[] userFilters = new Map[2] ;%>
<%! Map<String ,String> userFilter1 = new HashMap<String ,String>();%>
<%! Map<String ,String> userFilter2 = new HashMap<String ,String>();%>
<% userFilter1.put("layerCode", "1");
   userFilter2.put("layerCode", "2");
   userFilter2.put("pstnCode", "55");
   userFilters[0] = userFilter1;
   userFilters[1] = userFilter2;%>

<html>
<head>
<title>Echo Tag</title>
</head>
<body>
<br/>
<%= userFilters %>
<%= userFilter1 %>
<%= userFilter2 %>
<br/>

<h1>Echo Test</h1>

<p>
<emp:search>
<%
if(userFilters.length >= 0) {
  out.println("<jsp:body>");
  out.println("<userFilters>");
  for ( Map<String, String> userFilter : userFilters) {
    out.println("<userFilter>");
    if(userFilter.get("layerCode") != null) {
    	out.println("<layerCode>");%>
    	<!--  out.print(userFilter.get("layerCode"));-->
    	<%= userFilter1.get("layerCode")%>
    	<% out.println("</layerCode>");
    }
    if(userFilter.get("pstnCode") != null) {
    	out.println("<pstnCode>");
    	out.println(userFilter.get("pstnCode"));
    	out.println("</pstnCode>");
    }
    out.println("</userFilter>");
  }
  out.println("</userFilters>");
  out.println("</jsp:body>");
}
%>
</emp:search>
</p>
</body>
</html>

