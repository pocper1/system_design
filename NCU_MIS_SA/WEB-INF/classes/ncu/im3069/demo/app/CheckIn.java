package ncu.im3069.demo.app;
import java.sql.Timestamp;
import org.json.*;
import java.time.LocalDateTime;

public class CheckIn {

    private int id;
    
    private String userID;

    private String name;
    
    private String dorm;
    
    private String roomNo;
    
    private String bedNo;
    
    private boolean isDamaged;
    
    private String checkInStat;
    
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
    
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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
	
	public String getCheckInStat() {
		return checkInStat;
	}

	public void setCheckInStat(String checkInStat) {
		this.checkInStat = checkInStat;
	}


    
    
    
    private CheckInHelper ch =  CheckInHelper.getHelper();
    
    public CheckIn(int id,String userID, String name, String dorm, String roomNo, String bedNo,String checkInStat,  boolean isDamaged, Timestamp created, Timestamp modified) {
    	this.id=id;
    	this.userID=userID;
        this.name=name;
        this.dorm = dorm;
        this.roomNo=roomNo;
        this.bedNo = bedNo;
        this.checkInStat=checkInStat;
        this.isDamaged = isDamaged;
        this.create = created;
        this.modify = Timestamp.valueOf(LocalDateTime.now());
        update();
    }
    
  //String userID, String name, String dorm, String roomNo, String bedNo, boolean isDamaged
    
    public CheckIn(String userID, String name, String dorm, String roomNo, String bedNo, String checkInStat, boolean isDamaged) {
    	this.userID=userID;
        this.name=name;
        this.dorm = dorm;
        this.roomNo=roomNo;
        this.bedNo = bedNo;
        this.checkInStat=checkInStat;
        this.isDamaged = isDamaged;
        update();
    }

    public CheckIn(String userID, String name, String dorm, String roomNo, String bedNo,String checkInStat, boolean isDamaged, Timestamp created, Timestamp updated_at) {
    	this.userID=userID;
        this.name=name;
        this.dorm = dorm;
        this.roomNo=roomNo;
        this.bedNo = bedNo;
        this.isDamaged = isDamaged;
        this.checkInStat= checkInStat;
        this.create = Timestamp.valueOf(LocalDateTime.now());
        this.modify = Timestamp.valueOf(LocalDateTime.now());
        update();
    }
    
    public CheckIn(int id,String checkInStat, boolean isDamaged) {
    	this.id = id;
    	this.checkInStat=checkInStat;
        this.isDamaged = isDamaged;
        update();
    }
    
    public CheckIn(String dorm, String roomNo, String bedNo,String checkInStat, boolean isDamaged) {
    	this.dorm=dorm;
    	this.roomNo=roomNo;
    	this.bedNo=bedNo;
    	this.checkInStat=checkInStat;
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
		jso.put("user_id", getUserID());
		jso.put("name", getName());
		jso.put("dorm_no", getDormNo());
		jso.put("room_no", getRoomNo());
		jso.put("bed_no", getBedNo());
		jso.put("check_in_stat", getCheckInStat());
		jso.put("is_damaged", getIsDamaged());
		jso.put("create_time", getCreateTime());
		jso.put("modify_time", getModifyTime());

		return jso;
    	
    }





}
