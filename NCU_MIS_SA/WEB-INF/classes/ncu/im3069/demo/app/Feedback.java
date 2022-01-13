package ncu.im3069.demo.app;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.json.*;

public class Feedback {

    /** id，文章編號 */
    private int id;

    /** id，使用者ID */
    private String userID;

    /** id，報修ID */
    private String fixID;

    /** id，原因 */
    private String reason;
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
	public Feedback(String userID, String fixID, String reason ) {
		this.userID = userID;
		this.fixID=fixID;
		this.reason=reason;
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
	public Feedback(int id,String userID, String fixID, String reason,Timestamp created,Timestamp updated_at) {
		this.id = id;
		this.userID = userID;
		this.fixID=fixID;
		this.reason=reason;
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
	public String getFixID() {
		return this.fixID;
	}
	public String getReason(){
		return this.reason;
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
        jso.put("fixID", getFixID());
        jso.put("reason", getReason());
        jso.put("created", getCreatedTime());
        jso.put("modified", getUpdatedTime());
        return jso;
    }
}
