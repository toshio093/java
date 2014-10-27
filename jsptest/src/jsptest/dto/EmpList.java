package jsptest.dto;

import java.util.List;

public class EmpList {
	List<Emp> emps;

	public EmpList() {
		super();
	}

	public EmpList(List<Emp> emps) {
		super();
		this.emps = emps;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}


}