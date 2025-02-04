package HawkerTable;

public class HawkerTableBean {
   String hname;
   String nmobile;
   String doj;
   String alloaddress;
public HawkerTableBean(String hname, String nmobile, String doj, String alloaddress) {
	super();
	this.hname = hname;
	this.nmobile = nmobile;
	this.doj = doj;
	this.alloaddress = alloaddress;
}
public String getHname() {
	return hname;
}
public void setHname(String hname) {
	this.hname = hname;
}
public String getNmobile() {
	return nmobile;
}
public void setNmobile(String nmobile) {
	this.nmobile = nmobile;
}
public String getDoj() {
	return doj;
}
public void setDoj(String doj) {
	this.doj = doj;
}
public String getAlloaddress() {
	return alloaddress;
}
public void setAlloaddress(String alloaddress) {
	this.alloaddress = alloaddress;
}
 	
}
