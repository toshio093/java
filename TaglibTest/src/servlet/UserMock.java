package servlet;

import java.util.ArrayList;
import java.util.List;

import jp.ash.dto.Dept;
import jp.ash.dto.Emp;

public class UserMock {

	Dept dept0 = new Dept("ITP", "0");
	Dept dept1 = new Dept("BSD", "1");
	Dept dept2 = new Dept("総務", "2");
	Dept dept3 = new Dept("管理", "3");

	public UserMock() {
	}

	public List<Emp> getUsersList(String deptName) {
		//List<Emp> emps = new ArrayList<Emp>();
		List<Emp> emps = new ArrayList<Emp>();
		if (Integer.parseInt(deptName) == 0) {
			Emp emp1 = new Emp("pit1", "ITP1", dept0,"部長", "1");
			Emp emp2 = new Emp("pit2", "ITP2", dept0,"部長", "1");
			emps.add(emp1);
			emps.add(emp2);
		}else if (Integer.parseInt(deptName) == 1) {
			Emp emp1 = new Emp("pit3", "BSD1", dept1,"部長", "1");
			Emp emp2 = new Emp("pit4", "BSD2", dept1,"部長", "1");
			emps.add(emp1);
			emps.add(emp2);
		}else if (Integer.parseInt(deptName) == 2) {
			Emp emp1 = new Emp("pit5", "総務1", dept2,"部長", "1");
			Emp emp2 = new Emp("pit6", "総務2", dept2,"部長", "1");
			emps.add(emp1);
			emps.add(emp2);
		}else if (Integer.parseInt(deptName) == 3) {
			Emp emp1 = new Emp("pit7", "管理1", dept3,"部長", "1");
			Emp emp2 = new Emp("pit8", "管理2", dept3,"部長", "1");
			emps.add(emp1);
			emps.add(emp2);
		}
		//EmpList empList = new EmpList(emps);
		//return empList;
		return emps;
	}

}

