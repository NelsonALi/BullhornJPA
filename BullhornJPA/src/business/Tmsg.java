package business;

import java.util.Date;

public class Tmsg {
	private String msg;
	private String pFlag = " ";  // "@": private post;   " ": public post
	private Date msgTime; //A time stamp down to second
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getpFlag() {
		return pFlag;
	}
	public void setpFlag(String pFlag) {
		this.pFlag = pFlag;
	}
	public Date getMsgTime() {
		return msgTime;
	}
	public void setMsgTime(Date msgTime) {
		this.msgTime = msgTime;
	}
	
	
}
