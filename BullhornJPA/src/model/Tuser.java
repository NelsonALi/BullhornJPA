package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TUSERS database table.
 * 
 */
@Entity
@Table(name="TUSERS", schema="testuserdb")
@NamedQuery(name="Tuser.findAll", query="SELECT t FROM Tuser t")
public class Tuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TUSERS_SEQ")
    @SequenceGenerator(schema="testuserdb", name="TUSERS_SEQ", sequenceName="TUSERS_SEQ", allocationSize=1)
	private long id;

	@Temporal(TemporalType.DATE)
	private Date joindate;

	private String loginname;

	private String motto;

	//bi-directional many-to-one association to T
	@OneToMany(mappedBy="tuser")
	private List<T> ts;

	public Tuser() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getJoindate() {
		return this.joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getMotto() {
		return this.motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public List<T> getTs() {
		return this.ts;
	}

	public void setTs(List<T> ts) {
		this.ts = ts;
	}

	public T addT(T t) {
		getTs().add(t);
		t.setTuser(this);

		return t;
	}

	public T removeT(T t) {
		getTs().remove(t);
		t.setTuser(null);

		return t;
	}

}