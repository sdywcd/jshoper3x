package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the table_t database table.
 * 
 */
@Entity
@Table(name="table_t")
@NamedQuery(name="TableT.findAll", query="SELECT t FROM TableT t")
public class TableT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String tableid;
	private int androidDevicesCount;
	private Date createtime;
	private String creatorid;
	private int floor;
	private int nop;
	private String note;
	private int rnop;
	private String roomName;
	private String tableNumber;
	private String tablestate;

	public TableT() {
	}


	@Id
	public String getTableid() {
		return this.tableid;
	}

	public void setTableid(String tableid) {
		this.tableid = tableid;
	}


	@Column(name="ANDROID_DEVICES_COUNT")
	public int getAndroidDevicesCount() {
		return this.androidDevicesCount;
	}

	public void setAndroidDevicesCount(int androidDevicesCount) {
		this.androidDevicesCount = androidDevicesCount;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	public int getFloor() {
		return this.floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}


	public int getNop() {
		return this.nop;
	}

	public void setNop(int nop) {
		this.nop = nop;
	}


	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	public int getRnop() {
		return this.rnop;
	}

	public void setRnop(int rnop) {
		this.rnop = rnop;
	}


	@Column(name="ROOM_NAME")
	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}


	@Column(name="TABLE_NUMBER")
	public String getTableNumber() {
		return this.tableNumber;
	}

	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}


	public String getTablestate() {
		return this.tablestate;
	}

	public void setTablestate(String tablestate) {
		this.tablestate = tablestate;
	}

}