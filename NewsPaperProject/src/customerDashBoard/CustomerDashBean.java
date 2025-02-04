package customerDashBoard;

public class CustomerDashBean {

String cname;
  String cmobile;
  String selPapers;
  String carea;
 
  public CustomerDashBean() {};
public CustomerDashBean(String cname, String cmobile, String carea,String cemail, String caddress) {
	this.cname = cname;
	this.cmobile = cmobile;
	this.carea = carea;
	this.cemail = cemail;
	this.caddress = caddress;
	
}
public CustomerDashBean(String cname, String selPapers) {
	this.cname = cname;
	this.selPapers = selPapers;
	
	
}
public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCmobile() {
		return cmobile;
	}
	public void setCmobile(String cmobile) {
		this.cmobile = cmobile;
	}
	public String getSelPapers() {
		return selPapers;
	}
	public void setSelPapers(String selPapers) {
		this.selPapers = selPapers;
	}
	public String getCarea() {
		return carea;
	}
	public void setCarea(String carea) {
		this.carea = carea;
	}
	 public String getCemail() {
			return cemail;
		}
		public void setCemail(String cemail) {
			this.cemail = cemail;
		}
		public String getCaddress() {
			return caddress;
		}
		public void setCaddress(String caddress) {
			this.caddress = caddress;
		}
		String cemail;
		  String caddress;
}
