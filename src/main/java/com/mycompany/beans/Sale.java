package com.mycompany.beans;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Sale {
	@Id
	private int sid;
	private int pid;
	private int cid;
	private long quant;
	private Date sdate;
	private long total_amt;
	
	public Sale() {}
	
	@Override
	public String toString() {
		return "Sale [sid=" + sid + ", pid=" + pid + ", cid=" + cid + ", quant=" + quant + ", sdate=" + sdate
				+ ", total_amt=" + total_amt + "]";
	}

	public Sale(int sid, int pid, int cid, long quant, Date sdate, long total_amt) {
		this.sid = sid;
		this.pid = pid; //fk
		this.cid = cid; //fk
		this.quant = quant;
		this.sdate = sdate;
		this.total_amt = total_amt;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public long getQuant() {
		return quant;
	}
	public void setQuant(long quant) {
		this.quant = quant;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public long getTotal_amt() {
		return total_amt;
	}
	public void setTotal_amt(long total_amt) {
		this.total_amt = total_amt;
	}
	
}
