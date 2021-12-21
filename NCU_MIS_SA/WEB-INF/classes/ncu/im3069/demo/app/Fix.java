package ncu.im3069.demo.app;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.graalvm.compiler.lir.amd64.AMD64MathSinOp;
import org.json.*;

public class Fix {

    /** id，文章編號 */
    private int id;

    /** id，使用者ID */
    private String userID;

    /** id，大樓 */
    private String dorm;

    /** id，樓層 */
    private String floor;
    private String roomNo;
    private String category;
    private String item;
    private String detail;
    private int inRoom;
    private String reserve;
    private String progress;
    
    /** id，建立時間 */
    private Timestamp created;
    
    /** id，更新時間 */
    private Timestamp modified;
    /**
     * 實例化（Instantiates）一個新的（new）Product 物件<br>
     * 採用多載（overload）方法進行，此建構子用於新增產品時
     *
     * @param id 產品編號
     */
//	public Discussion(int id) {
//		this.id = id;
//	}

    /**
     * 實例化（Instantiates）一個新的（new）Discussion 物件<br>
     * 採用多載（overload）方法進行，此建構子用於新增產品時
     *
     * @param userID 使用者ID
     * @param dorm 大樓
     * @param floor 樓層
     * @param roomNo 房號
     * @param category 種類
     * @param item 項目
     * @param detail 細項
     * @param inRoom 入寢維修
     * @param reserve 預約時段
     * @param progress 進度
     */
	public Fix(String userID, String dorm, String floor, String roomNo, String category, String item,String detail,int inRoom,String reserve) {
		this.userID = userID;
		this.dorm = dorm;
		this.floor= floor;
		this.roomNo=roomNo;
		this.category=category;
		this.item=item;
		this.detail=detail;
		this.inRoom=inRoom;
		this.reserve=reserve;
		this.progress="0";
		this.created = Timestamp.valueOf(LocalDateTime.now());
        this.modified = Timestamp.valueOf(LocalDateTime.now());
	}

    /**
     * 實例化（Instantiates）一個新的（new）Discussion 物件<br>
     * 採用多載（overload）方法進行，此建構子用於修改產品時
     *
     * @param id 報修編號
     * @param userID 使用者ID
     * @param dorm 大樓
     * @param floor 樓層
     * @param roomNo 房號
     * @param category 種類
     * @param item 項目
     * @param detail 細項
     * @param inRoom 入寢維修
     * @param reserve 預約時段
     * @param progress 進度
     */
	public Fix(int id,String userID, String dorm, String floor, String roomNo, String category, String item,String detail,int inRoom,String reserve,String progress,Timestamp created,Timestamp updated_at) {
		this.id = id;
		this.userID = userID;
		this.dorm = dorm;
		this.floor= floor;
		this.roomNo=roomNo;
		this.category=category;
		this.item=item;
		this.detail=detail;
		this.inRoom=inRoom;
		this.reserve=reserve;
		this.progress=progress;
		this.created = created;
		this.modified = Timestamp.valueOf(LocalDateTime.now());
	}

	/**
     * 設定報修編號
     */
    public void setID(int id) {
        this.id = id;
    }
	public int getID() {
		return this.id;
	}
	public String getUserID() {
		return this.userID;
	}
	public String getDorm() {
		return this.dorm;
	}
	public String getRoomNo(){
		return this.roomNo;
	}
	public String getFloor() {
		return this.floor;
	}
	public String getCategory() {
		return this.category;
	}
	public String getItem() {
		return this.item;
	}
	public String getDetail() {
		return this.detail;
	}
	public int getInRoom() {
		return this.inRoom;
	}
	public String getReserve() {
		return this.reserve;
	}
	public String getProgress() {
		return this.progress;
	}
	public Timestamp getCreatedTime() {
        return this.created;
    }
    public Timestamp getUpdatedTime() {
        return this.modified;
    }
    /**
     * 取得報修資訊
     *
     * @return JSONObject 回傳產品資訊
     */
	public JSONObject getData() {
        /** 透過JSONObject將該項產品所需之資料全部進行封裝*/
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("userID", getUserID());
        jso.put("dorm", getDorm());
        jso.put("roomNo", getRoomNo());
        jso.put("floor", getFloor());
        jso.put("category", getCategory());
        jso.put("item", getItem());
        jso.put("detail", getDetail());
        jso.put("inRoom", getInRoom());
        jso.put("reserve", getReserve());
        jso.put("progress", getProgress());
        jso.put("created", getCreatedTime());
        jso.put("modified", getUpdatedTime());
        return jso;
    }
}
