package ncu.im3069.demo.app;
import java.util.Calendar;

import org.json.JSONObject;

//TODO: Auto-generated Javadoc
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

public class BulletinBoard {
	
	/**之後可能會再宣告一個變數是用來儲存創造公佈欄的人是誰，而剛好實務上我們限制只有管理員可以創建公佈欄，所以這個變數應該就是用來儲存 創建公佈欄的管理員**/
	
	/** id 公佈欄編號 */
	private int id;
	
	/** title，公告欄標題 */
	private String topic;
	
	/**content，公告欄內容 */
	private String content;
	
	/** login_times，更新時間的分鐘數 */
    private int login_times;
    
    /** bh，BulletinBoardHelper之物件與BulletinBoard相關之資料庫方法（Sigleton） */
    private BulletinBoardHelper bh = BulletinBoardHelper.getHelper();
    
    /**
     * 實例化（Instantiates）一個新的（new）BulletinBoard物件<br>
     * 採用多載（overload）方法進行，此建構子用於建立會員資料時，產生一名新的會員
     *
     * @param topic 公佈欄標題
     * @param content 公佈欄內容
     */
    public BulletinBoard(String topic, String content) {
        this.topic = topic;
        this.content = content;
        update();
    }
	
	/**
     * 實例化（Instantiates）一個新的（new）BulletinBoard物件<br>
     * 採用多載（overload）方法進行，此建構子用於更新公佈欄資料時，產生一個公佈欄同時需要去資料庫檢索原有更新時間分鐘數
     *
     * @param id 公佈欄編號
     * @param topic 公告欄標題
     * @param content 公告欄內容
     */
	public BulletinBoard(int id, String topic, String content){
		this.id = id;
		this.topic = topic;
		this.content = content;
		/** 取回原有資料庫內該名會員之更新時間分鐘數與組別 */
        getLoginTimesStatus();
	}
	
	/**
     * 實例化（Instantiates）一個新的（new）BulletinBoard物件<br>
     * 採用多載（overload）方法進行，此建構子用於查詢公佈欄資料時，將每一筆資料新增為一個公佈欄物件
     *
     * @param id 公佈欄編號
     * @param topic 公告欄標題
     * @param content 公告欄內容
     * @param login_times 更新時間的分鐘數
     */
    public BulletinBoard(int id, String topic, String content, int login_times) {
    	this.id = id;
    	this.topic = topic;
    	this.content =content;
    	this.login_times = login_times;
    }
	
	/**
     * 取得公佈欄之編號
     *
     * @return the id 回傳公佈欄編號
     */
    public int getID() {
        return this.id;
    }
	
	/**
     * 取得管理員的公告欄標題
     *
     * @return the title 回傳管理員的公告欄標題
     */
	public String getTopic() {
		return this.topic;
	}
	
	/**
     * 取得管理員的公告欄內容
     *
     * @return the content 回傳管理員的公告欄內容
     */
	public String getContent() {
		return this.content;
	}
	
	/**
     * 取得更新資料時間之分鐘數
     *
     * @return the login times 回傳更新資料時間之分鐘數
     */
    public int getLoginTimes() {
        return this.login_times;
    }
    
    /**
     * 更新公佈欄資料
     *
     * @return the JSON object 回傳SQL更新之結果與相關封裝之資料
     */
    public JSONObject update() {
        /** 新建一個JSONObject用以儲存更新後之資料 */
        JSONObject data = new JSONObject();
        /** 取得更新資料時間（即現在之時間）之分鐘數 */
        Calendar calendar = Calendar.getInstance();
        this.login_times = calendar.get(Calendar.MINUTE);
        
        /** 檢查該公佈欄是否已經在資料庫 */
        if(this.id != 0) {
            /** 若有則將目前更新後之資料更新至資料庫中 */
            bh.updateLoginTimes(this);
            /** 透過MemberHelper物件，更新目前之會員資料置資料庫中 */
            data = bh.update(this);
        }
        
        return data;
    }
    
    /**
     * 取得該公佈欄所有資料
     *
     * @return the data 取得該布告欄之所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {
        /** 透過JSONObject將該名會員所需之資料全部進行封裝*/ 
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("topic", getTopic());
        jso.put("content", getContent());
        jso.put("login_times", getLoginTimes());
        
        return jso;
    }
    
    /**
     * 取得資料庫內之更新資料時間分鐘數
     *
     */
    private void getLoginTimesStatus() {
        /** 透過BulletinBoardHelper物件，取得儲存於資料庫的更新時間分鐘數與會員組別 */
        JSONObject data = bh.getLoginTimesStatus(this);
        /** 將資料庫所儲存該公佈欄之相關資料指派至BulletinBoard物件之屬性 */
        this.login_times = data.getInt("login_times");
    }
}
