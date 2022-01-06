package ncu.im3069.demo.app;
import java.sql.Timestamp;
import org.json.*;
import java.time.LocalDateTime;

public class CheckIn {

    private int id;
    
    private String userID;

    private String name;
    
    private String email;
    
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Timestamp getCreate() {
		return create;
	}
	
	public void setCreate() {
		this.create=Timestamp.valueOf(LocalDateTime.now());
	}
	
	public Timestamp getModify() {
		return modify;
	}
	
	public void setModify() {
		this.create=Timestamp.valueOf(LocalDateTime.now());
	}

    
    
    
    private CheckInHelper ch =  CheckInHelper.getHelper();
    
    public CheckIn(int id,String userID,String email, String name, String dorm, String roomNo, String bedNo,String checkInStat,  boolean isDamaged, Timestamp created, Timestamp modified) {
    	this.id=id;
    	this.userID=userID;
    	this.email=email;
        this.name=name;
        this.dorm = dorm;
        this.roomNo=roomNo;
        this.bedNo = bedNo;
        this.checkInStat=checkInStat;
        this.isDamaged = isDamaged;
        this.create = Timestamp.valueOf(LocalDateTime.now());
        this.modify = Timestamp.valueOf(LocalDateTime.now());
        update();
    }
     
  //String userID, String name, String dorm, String roomNo, String bedNo, boolean isDamaged

    public CheckIn(String userID, String name,String email, String dorm, String roomNo, String bedNo,String checkInStat, boolean isDamaged, Timestamp created, Timestamp modified) {
    	this.userID=userID;
        this.name=name;
        this.email=email;
        this.dorm = dorm;
        this.roomNo=roomNo;
        this.bedNo = bedNo;
        this.isDamaged = isDamaged;
        this.checkInStat= checkInStat;
        this.create = Timestamp.valueOf(LocalDateTime.now());
        this.modify = Timestamp.valueOf(LocalDateTime.now());
        update();
    }
    
    public CheckIn(String userID,String checkInStat, boolean isDamaged, Timestamp modified) {
    	this.userID=userID;
    	this.checkInStat=checkInStat;
        this.isDamaged = isDamaged;
        this.modify = Timestamp.valueOf(LocalDateTime.now());
        update();
    }
    
//    public CheckIn(String dorm, String roomNo, String bedNo,String checkInStat, boolean isDamaged) {
//    	this.dorm=dorm;
//    	this.roomNo=roomNo;
//    	this.bedNo=bedNo;
//    	this.checkInStat=checkInStat;
//    	this.isDamaged=isDamaged;
//    	update();
//    }

    
    public CheckIn(String userID, String name, String dorm, String room, String bed, String checkInStat,
			boolean isDamaged2) {
    	this.userID=userID;
    	this.name=name;
    	this.dorm = dorm;
    	this.roomNo=room;
    	this.bedNo = bed;
    	this.checkInStat= checkInStat;
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
		jso.put("email", getEmail());
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
