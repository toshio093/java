package jsptest.dto;



public class Emp {
	String empId;
	String name;
	Dept dept;
	String yakusyoku;
	String layerCode;

	public Emp() {
	}

	public Emp(String empId, String name, Dept dept, String yakusyoku, String layerCode) {
		super();
		this.empId = empId;
		this.name = name;
		this.dept = dept;
		this.yakusyoku = yakusyoku;
		this.layerCode = layerCode;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getYakusyoku() {
		return yakusyoku;
	}

	public void setYakusyoku(String yakusyoku) {
		this.yakusyoku = yakusyoku;
	}

	public String getLayerCode() {
		return layerCode;
	}

	public void setLayerCode(String layerCode) {
		this.layerCode = layerCode;
	}



}
