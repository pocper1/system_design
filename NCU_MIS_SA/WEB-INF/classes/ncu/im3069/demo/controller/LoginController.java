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
@WebServlet("/api/login.do")
public class LoginController extends HttpServlet {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
	/** ph，FixHelper 之物件與 Fix 相關之資料庫方法（Sigleton） */
	private MemberHelper mh =  MemberHelper.getHelper();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
	        JSONObject jso = jsr.getObject();
	
	        /** 取出經解析到 JSONObject 之 Request 參數 */

	        

     		String email = jso.getString("email");
  	      	String password = jso.getString("password");
	        /** 建立一個新的討論物件 */
		 
//	        response.setCharacterEncoding("UTF-8");
//	        response.setContentType("text/html;charset=UTF-8");
//	        PrintWriter out = response.getWriter();
//	        request.setCharacterEncoding("UTF-8");
//	        request.getRequestDispatcher("login.html").include(request, response);

//	        String username = request.getParameter("username");
//	        String password = request.getParameter("password");
	        if (email == null) {
	            email = "";
	        }
	        if (password == null) {
	            password = "";
	        }

	        /** 新建一個 JSONObject 用於將回傳之資料進行封裝 */


	        JSONObject rs = mh.getByEmail(email,password);

        	System.out.println(rs.get("data"));
        	
        	if(rs.getJSONArray("data").length()!=0) {
        		System.out.println("成功登入");
        		System.out.println(rs.getJSONArray("data").get(0));
//        		String a = (JSONObject)rs.getJSONArray("data").get(0).toString();
        		String name=((JSONObject) rs.getJSONArray("data").get(0)).get("name").toString();
        		String role=((JSONObject) rs.getJSONArray("data").get(0)).get("role").toString();
		        System.out.println(name);
		        System.out.println(role);
	            HttpSession session1 = request.getSession();
	            session1.setAttribute("name", name);
	            session1.setAttribute("email", email);
	            session1.setAttribute("role", role);
            
        	}else {
        		System.out.println("沒有帳號");
        	}
        	
	        HttpSession session = request.getSession(false);
	        if (session != null) {
	            String Session_name = (String) session.getAttribute("name");
	            String Session_email = (String) session.getAttribute("email");
	            String Session_role = (String) session.getAttribute("role");
	            System.out.print("您好, " + Session_name + " 歡迎您來到個人資訊中心！ role:"+Session_role+", email:"+Session_email);
	        } else {
	            System.out.print("請登入系統！");
	            request.getRequestDispatcher("login.html").include(request, response);
	        }
	        
	        JSONObject resp = new JSONObject();
	        resp.put("status", "200");
	        resp.put("message", "報修新增成功！");
            resp.put("response", rs);

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
       		System.out.println("\ncall get");
        	JsonReader jsr = new JsonReader(request);
            /** 新建一個JSONObject用於將回傳之資料進行封裝 */
            JSONObject a = new JSONObject();

	        HttpSession session = request.getSession(false);
	        if (session != null) {
	            String Session_name = (String) session.getAttribute("name");
	            String Session_email = (String) session.getAttribute("email");
	            String Session_role = (String) session.getAttribute("role");
	            if(Session_name!="") {
		            a.put("name", Session_name);
		            a.put("email", Session_email);
		            a.put("role", Session_role);
	            	a.put("status", "login");
	            }else {
	            	a.put("status", "not login");
	            }
	            System.out.print(Session_name + "  role:"+Session_role+", email:"+Session_email);
	        } else {
	            System.out.print("未建立帳號!");
            	a.put("status", "not login");
	        }
            JSONObject resp = new JSONObject();
            resp.put("status", "200");
            resp.put("message", "取得登入狀態成功");
            resp.put("response", a);
    
            /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
            jsr.response(resp, response);

	}
}
