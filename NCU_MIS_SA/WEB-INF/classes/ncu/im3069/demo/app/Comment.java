package ncu.im3069.demo.app;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

import org.json.*;

public class Comment {

    /** id，留言編號 */
    private int id;

    /** discussion_id，留言之文章編號 */
    private String discussion_id;
    
    /** user_id，留言之使用者編號 */
    private String user_id;
    
    /** content，留言 */
    private String content;

    /** created_at，留言創建時間 */
    private Timestamp created_at;

    /** updated_at，留言修改時間 */
    private Timestamp updated_at;


    /**
     * 實例化（Instantiates）一個新的（new）Comment 物件<br>
     * 採用多載（overload）方法進行，此建構子用於建立留言資料時，產生一個新的留言
     *
     * @param id 留言編號
    
     */
    public Comment(int id) {
        this.id= id;
    }

    /**
     * 實例化（Instantiates）一個新的（new）Comment 物件<br>
     * 採用多載（overload）方法進行，此建構子用於建立留言資料時，新增一個留言
     *
     * @param user_id 使用者編號
     * @param content 文章內容
     * @param created_at 留言創建時間
     * @param updated_at 留言修改時間
     */
    public Comment(String discussion_id, String user_id, String content) {
    	this.discussion_id = discussion_id;
    	this.user_id = user_id;
        this.content = content;
    }
    
   
    /**
     * 實例化（Instantiates）一個新的（new）Comment 物件<br>
     * 採用多載（overload）方法進行，此建構子用於編輯留言資料時，編輯一個留言
     *
     * @param user_id 使用者編號
     * @param content 文章內容
     * @param created_at 留言創建時間
     * @param updated_at 留言修改時間
     */
    public Comment(int id, String discussion_id, String user_id, String content, Timestamp updated_at) {
    	this.id = id;
    	this.discussion_id = discussion_id;
    	this.user_id = user_id;
        this.content = content;
        this.updated_at = Timestamp.valueOf(LocalDateTime.now());
    }
 
    /**
     * 實例化（Instantiates）一個搜尋（search）Comment 物件<br>
     * 採用多載（overload）方法進行，此建構子用於編輯留言資料時，編輯一個留言
     *
     * @param user_id 使用者編號
     * @param content 文章內容
     * @param created_at 留言創建時間
     * @param updated_at 留言修改時間
     */
    public Comment(int ct_id, String discussion_id, String user_id, String content) {
    	this.discussion_id = discussion_id;
    	this.id = ct_id;
    	this.user_id = user_id;
        this.content = content;
       
    }
    /**
     * 設定留言編號
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * 取得留言編號
     *
     * @return int 回傳留言編號
     */
    public int getID() {
        return this.id;
    }

    /**
     * 取得使用者編號
     *
     * @return String 回傳留言之使用者編號
     */
    public String getDiscussionID() {
        return this.discussion_id;
    }
    
    /**
     * 取得使用者編號
     *
     * @return int 回傳留言之使用者編號
     */
    public String getUserID() {
        return this.user_id;
    }
    
    /**
     * 取得留言內容
     *
     * @return String 回傳訂單會員的名
     */
    public String getContent() {
        return this.content;
    }

    /**
     * 取得訂單創建時間
     *
     * @return Timestamp 回傳文章創建時間
     */
    public Timestamp getCreatedTime() {
        return this.created_at;
    }

    /**
     * 取得訂單修改時間
     *
     * @return Timestamp 回傳文章修改時間
     */
    public Timestamp getUpdatedTime() {
        return this.updated_at;
    }


    /**
     * 取得訂單基本資料
     *
     * @return JSONObject 取得訂單基本資料
     */
    public JSONObject getCommentData() {
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("discussion_id", getDiscussionID());
        jso.put("user_id", getUserID());
        jso.put("content", getContent());
        jso.put("created_at", getCreatedTime());
        jso.put("updated_at", getUpdatedTime());

        return jso;
    }

}
