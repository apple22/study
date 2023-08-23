package egovframework.example.sample.service;

public class DeptVO {
	
	//객체지향 : 캡슐화 (접근지정자 세팅);
private String deptno;
private String dname;
private String Loc;


public String getDeptno() {
	return deptno;
}

public void setDeptno(String deptno) {
	this.deptno = deptno;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public String getLoc() {
	return Loc;
}
public void setLoc(String Loc) {
	this.Loc = Loc;
}

}
