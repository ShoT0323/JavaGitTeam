package dto;

public class LendLocker {
	private int lockerno;
	private String stuff1;
	private String stuff2;
	private String stuff3;
	private int open;
	public LendLocker(int lockerno, String stuff1, String stuff2, String stuff3, int open) {
		super();
		this.lockerno = lockerno;
		this.stuff1 = stuff1;
		this.stuff2 = stuff2;
		this.stuff3 = stuff3;
		this.open = open;
	}
	public int getLockerno() {
		return lockerno;
	}
	public void setLockerno(int lockerno) {
		this.lockerno = lockerno;
	}
	public String getStuff1() {
		return stuff1;
	}
	public void setStuff1(String stuff1) {
		this.stuff1 = stuff1;
	}
	public String getStuff2() {
		return stuff2;
	}
	public void setStuff2(String stuff2) {
		this.stuff2 = stuff2;
	}
	public String getStuff3() {
		return stuff3;
	}
	public void setStuff3(String stuff3) {
		this.stuff3 = stuff3;
	}
	public int getOpen() {
		return open;
	}
	public void setOpen(int open) {
		this.open = open;
	}
	
	
	

	
}
