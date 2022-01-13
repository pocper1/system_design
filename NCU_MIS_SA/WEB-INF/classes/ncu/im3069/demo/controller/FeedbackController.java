package ncu.im3069.demo.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import ncu.im3069.tools.JsonReader;

import ncu.im3069.demo.app.FeedbackHelper;
import ncu.im3069.demo.app.Feedback;

/**
 * Servlet implementation class FixController
 */
@WebServlet("/api/feedback.do")
public class FeedbackController extends HttpServlet {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
	/** ph，FixHelper 之物件與 Fix 相關之資料庫方法（Sigleton） */
	private FeedbackHelper ph =  FeedbackHelper.getHelper();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackController() {
        super(); 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /**
     * 處理 Http Method 請求 GET 方法（新增資料）
     *
     * @param request Servlet 請求之 HttpServletRequest 之 Request 物件（前端到後端）
     * @param response Servlet 回傳之 HttpServletResponse 之 Response 物件（後端到前端）
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/** 透過JsonReader類別將Request之JSON格式資料解析並取回 */
        JsonReader jsr = new JsonReader(request);
        /** 若直接透過前端AJAX之data以key=value之字串方式進行傳遞參數，可以直接由此方法取回資料 */
        String id = jsr.getParameter("id");

        // JSONObject resp = new JSONObject();
        /** 判斷該字串是否存在，若存在代表要取回購物車內產品之資料，否則代表要取回全部資料庫內產品之資料 */
        /** 判斷該字串是否存在，若存在代表要取回個別會員之資料，否則代表要取回全部資料庫內會員之資料 */
        if (id.isEmpty()) {
            /** 透過MemberHelper物件之getAll()方法取回所有會員之資料，回傳之資料為JSONObject物件 */
            JSONObject query = ph.getAll();
            
            /** 新建一個JSONObject用於將回傳之資料進行封裝 */
            JSONObject resp = new JSONObject();
            resp.put("status", "200");
            resp.put("message", "所有問題回報資料取得成功");
            resp.put("response", query);
    
            /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
            jsr.response(resp, response);
        }
        else {
            /** 透過MemberHelper物件的getByID()方法自資料庫取回該名會員之資料，回傳之資料為JSONObject物件 */
        	System.out.println(id);
            JSONObject query = ph.getByFixID(id);
            System.out.println(query);
            /** 新建一個JSONObject用於將回傳之資料進行封裝 */
            JSONObject resp = new JSONObject();
            resp.put("status", "200");
            resp.put("message", "資料取得成功");
            resp.put("response", query);
    
            /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
            jsr.response(resp, response);
        }

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 /** 透過 JsonReader 類別將 Request 之 JSON 格式資料解析並取回 */
       JsonReader jsr = new JsonReader(request);
       JSONObject jso = jsr.getObject();

       /** 取出經解析到 JSONObject 之 Request 參數 */
       	String userID = jso.getString("userID");
 	      	String fixID = jso.getString("fixID");
 	      	String reason = jso.getString("reason");
       /** 建立一個新的討論物件 */

       Feedback feedback = new Feedback(userID, fixID,reason);

  
       /** 透過 FixHelper 物件的 create() 方法新建一筆訂單至資料庫 */
       JSONObject result = ph.create(feedback);
       System.out.println("this is response:"+ result);
       /** 設定回傳回來的訂單編號與訂單細項編號 */
       feedback.setID((int) result.getLong("feedback_id"));
       // od.setOrderProductId(result.getJSONArray("order_product_id"));
       

       /** 新建一個 JSONObject 用於將回傳之資料進行封裝 */
       JSONObject resp = new JSONObject();
       resp.put("status", "200");
       resp.put("message", "反饋新增成功！");
       resp.put("response", ph.getAll());

       /** 透過 JsonReader 物件回傳到前端（以 JSONObject 方式） */
       jsr.response(resp, response);
}

}
