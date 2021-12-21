package ncu.im3069.demo.app;
import java.sql.Timestamp;
import org.json.*;
import java.time.LocalDateTime;
import java.util.*;

import org.json.*;

public class CheckIn {

    private int id;

    private String name;
    
    private String dorm;
    
    private String roomNo;
    
    private String bedNo;
    
    private boolean isDamaged;
    
    /** create，訂單創建時間 */
    private Timestamp create;

    /** modify，訂單修改時間 */
    private Timestamp modify;
    
    
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    
	public String getDormNo() {
		return dorm;
	}

	public void setDormNo(String dorm) {
		this.dorm = dorm;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getBedNo() {
		return bedNo;
	}

	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}
	
    public Timestamp getCreateTime() {
        return this.create;
    }
	
	public Timestamp getModifyTime() {
	        return this.modify;
	}
	
	public boolean getIsDamaged() {
		return isDamaged;
	}

	public void setDamaged(boolean isDamaged) {
		this.isDamaged = isDamaged;
	}
    
    
    
    private CheckInHelper ch =  CheckInHelper.getHelper();
    
    public CheckIn(int id, String name, String dorm, String roomNo, String bedNo, boolean isDamaged) {
    	this.id=id;
        this.name=name;
        this.dorm = dorm;
        this.bedNo = bedNo;
        this.isDamaged = isDamaged;
        this.create = Timestamp.valueOf(LocalDateTime.now());
        this.modify = Timestamp.valueOf(LocalDateTime.now());
        update();
    }

    public CheckIn(String name, String dorm, String roomNo, String bedNo, boolean isDamaged) {
        this.name=name;
        this.dorm = dorm;
        this.bedNo = bedNo;
        this.isDamaged = isDamaged;
        this.create = Timestamp.valueOf(LocalDateTime.now());
        this.modify = Timestamp.valueOf(LocalDateTime.now());
        update();
    }
    
    public CheckIn(int id,boolean isDamaged) {
    	this.id = id;
        this.isDamaged = isDamaged;
        update();
    }
    
    public CheckIn(String dorm, String roomNo, String bedNo, boolean isDamaged) {
    	this.dorm=dorm;
    	this.roomNo=roomNo;
    	this.bedNo=bedNo;
    	this.isDamaged=isDamaged;
    	update();
    }

    
    public JSONObject update() {
        JSONObject data = new JSONObject();
        data = ch.update(this);
        return data;
    }

    public JSONObject getData() {
		JSONObject jso = new JSONObject();
		jso.put("id", getId());
		jso.put("name", getName());
		jso.put("dorm", getDormNo());
		jso.put("roomNo", getRoomNo());
		jso.put("bedNo", getBedNo());
		jso.put("isDamaged", getIsDamaged());

		return jso;
    	
    }


}
