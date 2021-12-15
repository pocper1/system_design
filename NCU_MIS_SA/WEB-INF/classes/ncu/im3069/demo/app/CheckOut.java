package ncu.im3069.demo.app;

import org.json.*;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class Member
 * Member類別（class）具有會員所需要之屬性與方法，並且儲存與會員相關之商業判斷邏輯<br>
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class CheckOut {
    
    /** id，會員編號 */
    private int id;
    
    /** email，會員電子郵件信箱 */
    private String dorm;
    
    /** name，會員姓名 */
    private String room;
    
    /** password，會員密碼 */
    private String bed;
    
    private String passORnot;
    
    
    /** mh，MemberHelper之物件與Member相關之資料庫方法（Sigleton） */
    private CheckOutHelper ch =  CheckOutHelper.getHelper();
    
    /**
     * 實例化（Instantiates）一個新的（new）Member物件<br>
     * 採用多載（overload）方法進行，此建構子用於建立會員資料時，產生一名新的會員
     *
     * @param email 會員電子信箱
     * @param password 會員密碼
     * @param name 會員姓名
     */
    public CheckOut(String dorm, String room, String bed,String passORnot) {
        this.dorm = dorm;
        this.room = room;
        this.bed = bed;
        this.passORnot = passORnot;
        update();
    }
    
    public CheckOut(int id, String dorm, String room, String bed,String passORnot) {
    	this.id = id;
        this.dorm = dorm;
        this.room = room;
        this.bed = bed;
        this.passORnot = passORnot;
        update();
    }

    public CheckOut(int id,String passORnot) {
    	this.id = id;
        this.passORnot = passORnot;
        update();
    }

    
    
    /**
     * 取得會員之編號
     *
     * @return the id 回傳會員編號
     */
    public int getID() {
        return this.id;
    }

    /**
     * 取得會員之電子郵件信箱
     *
     * @return the email 回傳會員電子郵件信箱
     */
    public String getDorm() {
        return this.dorm;
    }
    
    /**
     * 取得會員之姓名
     *
     * @return the name 回傳會員姓名
     */
    public String getRoom() {
        return this.room;
    }

    /**
     * 取得會員之密碼
     *
     * @return the password 回傳會員密碼
     */
    public String getBed() {
        return this.bed;
    }
    
    public String getPassORnot() {
        return this.passORnot;
    }
    
    /**
     * 更新會員資料
     *
     * @return the JSON object 回傳SQL更新之結果與相關封裝之資料
     */
    public JSONObject update() {
        /** 新建一個JSONObject用以儲存更新後之資料 */
        JSONObject data = new JSONObject();
        data = ch.update(this);
        return data;
    }
    
    /**
     * 取得該名會員所有資料
     *
     * @return the data 取得該名會員之所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {
        /** 透過JSONObject將該名會員所需之資料全部進行封裝*/ 
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("dorm", getDorm());
        jso.put("room", getRoom());
        jso.put("bed", getBed());
        jso.put("passORnot", getPassORnot());

        return jso;
    }
    


}