package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the TS database table.
 * 
 */
@Entity
@Table(name="TS", schema="testuserdb")
@NamedQuery(name="T.findAll", query="SELECT t FROM T t")
public class T implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String msg;

	private Timestamp msgdate;

	private String pflag;

	//bi-directional many-to-one association to Tuser
	@ManyToOne
	private Tuser tuser;

	public T() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Timestamp getMsgdate() {
		return this.msgdate;
	}

	public void setMsgdate(Timestamp msgdate) {
		this.msgdate = msgdate;
	}

	public String getPflag() {
		return this.pflag;
	}

	public void setPflag(String pflag) {
		this.pflag = pflag;
	}

	public Tuser getTuser() {
		return this.tuser;
	}

	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}

}