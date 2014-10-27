package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ash.dto.Emp;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EmpSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpSelectServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String deptName = request.getParameter("deptName");
		List<Emp> empList = new UserMock().getUsersList(deptName);

		//json生成
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(empList);

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(json);
		System.out.println("=============================");

		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
