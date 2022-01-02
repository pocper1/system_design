package ncu.im3069.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import ncu.im3069.tools.JsonReader;

import ncu.im3069.demo.app.MemberHelper;
import ncu.im3069.demo.app.Member;
/**
 * Servlet implementation class FixController
 */
@WebServlet("/api/logout.do")
public class LogoutController extends HttpServlet {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
	/** ph，FixHelper 之物件與 Fix 相關之資料庫方法（Sigleton） */
	private MemberHelper mh =  MemberHelper.getHelper();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
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
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 

	        JsonReader jsr = new JsonReader(request);
	
	        /** 取出經解析到 JSONObject 之 Request 參數 */

	  

	        /** 新建一個 JSONObject 用於將回傳之資料進行封裝 */

	        HttpSession session = request.getSession();
	        // 清除資料
	        session.invalidate();
	        System.out.print("您已成功登出退出系統!");
	        
	        JSONObject resp = new JSONObject();
	        resp.put("status", "200");
	        resp.put("message", "登出系統成功！");

	        /** 透過 JsonReader 物件回傳到前端（以 JSONObject 方式） */
	        jsr.response(resp, response);
	        
//	        System.out.println(username);
//	        if (username.equals("admin") && password.equals("admin123")) {
//	            out.print("Welcome, " + username);
//	            HttpSession session = request.getSession();
//	            session.setAttribute("username", username);
//	            session.setAttribute("nickname", "蘇小牛");
//	            session.setAttribute("age", "21");
//	        } else {
//	            out.print("<font style='color:rec;'>對不起，使用者名或密碼錯誤!</font>");
//	            request.getRequestDispatcher("login.html").include(request, response);
//	        }
//	        out.close();
	    }
}
