package ncu.im3069.demo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import ncu.im3069.tools.JsonReader;

import ncu.im3069.demo.app.DiscussionHelper;
import ncu.im3069.demo.app.Discussion;

/**
 * Servlet implementation class DiscussionController
 */
@WebServlet("/api/discussion.do")
public class DiscussionController extends HttpServlet {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
	/** ph，DiscussionHelper 之物件與 Discussion 相關之資料庫方法（Sigleton） */
	private DiscussionHelper ph =  DiscussionHelper.getHelper();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiscussionController() {
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
            resp.put("message", "所有討論資料取得成功");
            resp.put("response", query);
    
            /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
            jsr.response(resp, response);
        }
        else {
            /** 透過MemberHelper物件的getByID()方法自資料庫取回該名會員之資料，回傳之資料為JSONObject物件 */
            JSONObject query = ph.getByID(id);
            
            /** 新建一個JSONObject用於將回傳之資料進行封裝 */
            JSONObject resp = new JSONObject();
            resp.put("status", "200");
            resp.put("message", "討論資料取得成功");
            resp.put("response", query);
    
            /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
            jsr.response(resp, response);
        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 /** 透過 JsonReader 類別將 Request 之 JSON 格式資料解析並取回 */
	        JsonReader jsr = new JsonReader(request);
	        JSONObject jso = jsr.getObject();
	
	        /** 取出經解析到 JSONObject 之 Request 參數 */

	        String article_title 	= jso.getString("article_title");
	        String article_content 	= jso.getString("article_content");
	        int author 				= jso.getInt("author");
	       
	        /** 建立一個新的討論物件 */
	        Discussion dis = new Discussion(article_title, article_content, author);

	   
	        /** 透過 DiscussionHelper 物件的 create() 方法新建一筆訂單至資料庫 */
	        JSONObject result = ph.create(dis);
	        System.out.println("this is response:"+ result);
	        /** 設定回傳回來的訂單編號與訂單細項編號 */
	        dis.setID((int) result.getLong("article_id"));
	        // od.setOrderProductId(result.getJSONArray("order_product_id"));
	        

	        /** 新建一個 JSONObject 用於將回傳之資料進行封裝 */
	        JSONObject resp = new JSONObject();
	        resp.put("status", "200");
	        resp.put("message", "訂單新增成功！");
	        resp.put("response", ph.getAll());

	        /** 透過 JsonReader 物件回傳到前端（以 JSONObject 方式） */
	        jsr.response(resp, response);
	}

	 public void doDelete(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException {
		 		
		        /** 透過JsonReader類別將Request之JSON格式資料解析並取回 */
		        JsonReader jsr = new JsonReader(request);
		        JSONObject jso = jsr.getObject();
		        
		        /** 取出經解析到JSONObject之Request參數 */
		        int id = jso.getInt("id");
		        
		        /** 透過MemberHelper物件的deleteByID()方法至資料庫刪除該名會員，回傳之資料為JSONObject物件 */
		        JSONObject query = ph.deleteByID(id);
		        
		        /** 新建一個JSONObject用於將回傳之資料進行封裝 */
		        JSONObject resp = new JSONObject();
		        resp.put("status", "200");
		        resp.put("message", "移除文章成功！");
		        resp.put("response", query);

		        /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
		        jsr.response(resp, response);
		    }
}
