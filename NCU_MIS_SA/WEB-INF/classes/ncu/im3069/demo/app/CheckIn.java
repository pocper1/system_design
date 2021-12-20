package ncu.im3069.demo.app;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

import org.json.*;

public class CheckIn {

    private int id;

    private String name;

    private String email;

    private String phone;
    
    private String dorm;
    
    private String roomNo;
    
    private String bedNo;
    
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

  
    public String getEmail() {
        return this.email;
    }
    
	public void setEmail(String email) {
		this.email = email;
	}
    
	public void setPhone(String phone) {
		this.phone=phone;
	}
	
	public String getPhone() {
		return this.phone;
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
    
    
    private ArrayList<Member> roommateAL = new ArrayList<Member>();
    
    private CheckinHelper ch =  CheckinHelper.getHelper();

    public CheckIn(String name, String email, String phone, String dorm, String roomNo, String bedNo) {
        this.setName(name);
        this.email = email;
        this.phone = phone;
        this.dorm = dorm;
        this.bedNo = bedNo;
        this.create = Timestamp.valueOf(LocalDateTime.now());
        this.modify = Timestamp.valueOf(LocalDateTime.now());
    }

//    public void addOrderProduct(Product pd, int quantity) {
//        this.list.add(new OrderItem(pd, quantity));
//    }
//
//
//    private void getOrderProductFromDB() {
//        ArrayList<OrderItem> data = oph.getOrderProductByOrderId(this.id);
//        this.list = data;
//    }

    /**
     * 取得訂單基本資料
     *
     * @return JSONObject 取得訂單基本資料
     */
    
    public JSONObject getRoommateData() {
		JSONObject jso = new JSONObject();
		jso.put("id", getId());
		jso.put("name", getName());
		jso.put("email", getEmail());
		jso.put("phone", getPhone());
		jso.put("dorm", getDormNo());
		jso.put("roomNo", getRoomNo());
		jso.put("bedNo", getBedNo());

		
		return jso;
    	
    }

    /**
     * 取得訂單產品資料
     *
     * @return JSONArray 取得訂單產品資料
     */
//    public JSONArray getOrderProductData() {
//        JSONArray result = new JSONArray();
//
//        for(int i=0 ; i < this.list.size() ; i++) {
//            result.put(this.list.get(i).getData());
//        }
//
//        return result;
//    }
//
//    /**
//     * 取得訂單所有資訊
//     *
//     * @return JSONObject 取得訂單所有資訊
//     */
//    public JSONObject getOrderAllInfo() {
//        JSONObject jso = new JSONObject();
//        jso.put("order_info", getOrderData());
//        jso.put("product_info", getOrderProductData());
//
//        return jso;
//    }
//
//    /**
//     * 設定訂單產品編號
//     */
//    public void setOrderProductId(JSONArray data) {
//        for(int i=0 ; i < this.list.size() ; i++) {
//            this.list.get(i).setId((int) data.getLong(i));
//        }
//    }
//


}
