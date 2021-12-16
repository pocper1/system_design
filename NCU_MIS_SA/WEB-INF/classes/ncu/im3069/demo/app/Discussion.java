package ncu.im3069.demo.app;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.json.*;

public class Discussion {

    /** id，文章編號 */
    private int id;

    /** id，文章標題 */
    private String article_title;

    /** id，文章內容 */
    private String article_content;

    /** id，會員編號 */
    private int author;
    
    /** id，建立時間 */
    private Timestamp created_at;
    
    /** id，更新時間 */
    private Timestamp updated_at;
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
     * @param article_title 文章標題
     * @param article_content 文章內容
     * @param author 文章作者
     */
	public Discussion(String article_title, String article_content, int author) {
		this.article_title = article_title;
		this.article_content = article_content;
		this.author = author;
		this.created_at = Timestamp.valueOf(LocalDateTime.now());
        this.updated_at = Timestamp.valueOf(LocalDateTime.now());
	}

    /**
     * 實例化（Instantiates）一個新的（new）Discussion 物件<br>
     * 採用多載（overload）方法進行，此建構子用於修改產品時
     *
     * @param id 文章編號
     * @param article_title 文章標題 
     * @param article_content 文章內容
     * @param author 文章作者
     */
	public Discussion(int id, String article_title, String article_content, int author, Timestamp updated_at) {
		this.id = id;
		this.article_title = article_title;
		this.article_content = article_content;
		this.author = author;
		this.updated_at = Timestamp.valueOf(LocalDateTime.now());
	}

	/**
     * 設定討論編號
     */
    public void setID(int id) {
        this.id = id;
    }
    
    /**
     * 取得討論編號
     *
     * @return INT 回傳產品編號
     */
	public int getID() {
		return this.id;
	}

    /**
     * 取得產品名稱
     *
     * @return String 回傳文章標題
     */
	public String getTitle() {
		return this.article_title;
	}

    /**
     * 取得產品價格
     *
     * @return String 回傳文章內容
     */
	public String getContent() {
		return this.article_content;
	}

    /**
     * 取得產品圖片
     *
     * @return INT 回傳文章作者
     */
	public int getAuthor() {
		return this.author;
	}


	public Timestamp getCreatedTime() {
        return this.created_at;
    }

    /**
     * 取得訂單修改時間
     *
     * @return Timestamp 回傳訂單修改時間
     */
    public Timestamp getUpdatedTime() {
        return this.updated_at;
    }
    
    /**
     * 取得產品資訊
     *
     * @return JSONObject 回傳產品資訊
     */
	public JSONObject getData() {
        /** 透過JSONObject將該項產品所需之資料全部進行封裝*/
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("article_title", getTitle());
        jso.put("article_content", getContent());
        jso.put("author", getAuthor());
        
        return jso;
    }
}
