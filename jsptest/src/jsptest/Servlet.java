package jsptest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsptest.dto.UserFilter;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class Servlet extends Action{

	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse response) {

		//userFilterせっと
		List<UserFilter> userFilters = new ArrayList<UserFilter>() ;
		List<String> pstns = Arrays.asList("pstn1", "pstn2");
		UserFilter userFilter1 = new UserFilter(pstns,"1");
		UserFilter userFilter2 = new UserFilter(null,"5");
		userFilters.add(userFilter1);
		userFilters.add(userFilter2);

		req.setAttribute("userFilters", userFilters);
	    return mapping.findForward("success");
	}


}