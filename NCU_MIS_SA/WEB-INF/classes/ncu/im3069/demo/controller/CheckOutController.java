package ncu.im3069.demo.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.json.*;
import ncu.im3069.demo.app.CheckOut;
import ncu.im3069.demo.app.CheckOutHelper;
import ncu.im3069.tools.JsonReader;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class MemberController<br>
 * MemberController嚙踝蕭嚙瞌嚙稽class嚙稷嚙瘩嚙緯嚙諄抬蕭B嚙緲Member嚙踝蕭嚙踝蕭嚙踝蕭Http嚙請求嚙稽Request嚙稷嚙璀嚙羯嚙踝蕭HttpServlet
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */
@WebServlet("/api/check_out.do")
public class CheckOutController extends HttpServlet {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** mh嚙璀MemberHelper嚙踝蕭嚙踝蕭嚙踝蕭PMember嚙踝蕭嚙踝蕭嚙踝蕭嚙踝蕭w嚙踝蕭k嚙稽Sigleton嚙稷 */
    private CheckOutHelper ch =  CheckOutHelper.getHelper();
    
    /**
     * 嚙畿嚙緲Http Method嚙請求POST嚙踝蕭k嚙稽嚙編嚙磕嚙踝蕭^
     *
     * @param request Servlet嚙請求嚙踝蕭HttpServletRequest嚙踝蕭Request嚙踝蕭嚙踝蕭]嚙箴嚙豎剁蕭嚙豎）
     * @param response Servlet嚙稷嚙褒歹蕭HttpServletResponse嚙踝蕭Response嚙踝蕭嚙踝蕭]嚙踝蕭搢嚙箴嚙豎）
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        /** 嚙緲嚙盤JsonReader嚙踝蕭嚙瞌嚙瞇Request嚙踝蕭JSON嚙賣式嚙踝蕭悛R嚙衛剁蕭嚙稷 */
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();
        
        String passORnot="NotPass";
        /** 嚙踝蕭嚙碼嚙篇嚙諸析嚙踝蕭JSONObject嚙踝蕭Request嚙諸潘蕭 */
        String name = jso.getString("UserId");
        String dorm = jso.getString("dorm");
        String room = jso.getString("room");
        String bed = jso.getString("bed");

        
        /** 嚙諍立一嚙諉新嚙踝蕭嚙罵嚙踝蕭嚙踝蕭嚙踝蕭 */
        CheckOut c = new CheckOut(name, dorm, room, bed, passORnot);
        
        /** 嚙踝蕭嚙踝蕭邠d嚙瞌嚙稻嚙踝蕭嚙踝蕭鴐堆蕭躑A嚙磐嚙踝蕭嚙篁嚙稷嚙褒選蕭嚙羯嚙確嚙踝蕭 */
        JSONObject resp = new JSONObject();
        if(!ch.checkDuplicate(c)) {
        	ch.create(c);
        	resp.put("status", "200");}
        else {resp.put("status", "250");}
         
         
            /** 嚙編嚙諍一嚙踝蕭JSONObject嚙諄抬蕭N嚙稷嚙褒歹蕭嚙踝蕭i嚙踝蕭妐嚙� */

         
            
            /** 嚙緲嚙盤JsonReader嚙踝蕭嚙踝蕭^嚙褒剁蕭e嚙豎（嚙瘡JSONObject嚙質式嚙稷 */
         jsr.response(resp, response);
        

    }

    /**
     * 嚙畿嚙緲Http Method嚙請求GET嚙踝蕭k嚙稽嚙踝蕭嚙緻嚙踝蕭^
     *
     * @param request Servlet嚙請求嚙踝蕭HttpServletRequest嚙踝蕭Request嚙踝蕭嚙踝蕭]嚙箴嚙豎剁蕭嚙豎）
     * @param response Servlet嚙稷嚙褒歹蕭HttpServletResponse嚙踝蕭Response嚙踝蕭嚙踝蕭]嚙踝蕭搢嚙箴嚙豎）
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        /** 嚙緲嚙盤JsonReader嚙踝蕭嚙瞌嚙瞇Request嚙踝蕭JSON嚙賣式嚙踝蕭悛R嚙衛剁蕭嚙稷 */
        JsonReader jsr = new JsonReader(request);
        /** 嚙磐嚙踝蕭嚙踝蕭嚙緲嚙盤嚙箴嚙踝蕭AJAX嚙踝蕭data嚙瘡key=value嚙踝蕭嚙緝嚙踝蕭閬∴蕭i嚙踝蕭嚙踝蕭捊A嚙箠嚙瘡嚙踝蕭嚙踝蕭嚙諸佗蕭嚙踝蕭k嚙踝蕭嚙稷嚙踝蕭嚙� */
        String name = jsr.getParameter("UserId");
        System.out.println(name);
        /** 嚙瞑嚙稻嚙諉字嚙踝蕭O嚙稻嚙編嚙箭嚙璀嚙磐嚙編嚙箭嚙瞇嚙踝蕭n嚙踝蕭嚙稷嚙諉別嚙罵嚙踝蕭嚙踝蕭嚙踝蕭A嚙稻嚙篁嚙瞇嚙踝蕭n嚙踝蕭嚙稷嚙踝蕭嚙踝蕭嚙踝蕭w嚙踝蕭嚙罵嚙踝蕭嚙踝蕭嚙踝蕭嚙� */
        if (name.isEmpty()) {
            /** 嚙緲嚙盤MemberHelper嚙踝蕭嚙踝蕭getAll()嚙踝蕭k嚙踝蕭嚙稷嚙課佗蕭嚙罵嚙踝蕭嚙踝蕭嚙踝蕭A嚙稷嚙褒歹蕭嚙踝蕭嚙皚SONObject嚙踝蕭嚙踝蕭 */
            JSONObject query = ch.getAll();
            System.out.println("2");
            /** 嚙編嚙諍一嚙踝蕭JSONObject嚙諄抬蕭N嚙稷嚙褒歹蕭嚙踝蕭i嚙踝蕭妐嚙� */
            JSONObject resp = new JSONObject();
            resp.put("status", "200");
            resp.put("response", query);
            /** 嚙緲嚙盤JsonReader嚙踝蕭嚙踝蕭^嚙褒剁蕭e嚙豎（嚙瘡JSONObject嚙質式嚙稷 */
            jsr.response(resp, response);
        }
        else {
            /** 嚙緲嚙盤MemberHelper嚙踝蕭嚙踝蕭getByID()嚙踝蕭k嚙諛賂蕭w嚙踝蕭嚙稷嚙諉名嚙罵嚙踝蕭嚙踝蕭嚙踝蕭A嚙稷嚙褒歹蕭嚙踝蕭嚙皚SONObject嚙踝蕭嚙踝蕭 */
            JSONObject query = ch.getByname(name);
            /** 嚙編嚙諍一嚙踝蕭JSONObject嚙諄抬蕭N嚙稷嚙褒歹蕭嚙踝蕭i嚙踝蕭妐嚙� */
            JSONObject resp = new JSONObject();
            resp.put("status", "200");
            resp.put("response", query);
            System.out.println(query);
            System.out.println("3");
            /** 嚙緲嚙盤JsonReader嚙踝蕭嚙踝蕭^嚙褒剁蕭e嚙豎（嚙瘡JSONObject嚙質式嚙稷 */
            jsr.response(resp, response);
        }
    }

    /**
     * 嚙畿嚙緲Http Method嚙請求DELETE嚙踝蕭k嚙稽嚙磋嚙踝蕭嚙稷
     *
     * @param request Servlet嚙請求嚙踝蕭HttpServletRequest嚙踝蕭Request嚙踝蕭嚙踝蕭]嚙箴嚙豎剁蕭嚙豎）
     * @param response Servlet嚙稷嚙褒歹蕭HttpServletResponse嚙踝蕭Response嚙踝蕭嚙踝蕭]嚙踝蕭搢嚙箴嚙豎）
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */


    /**
     * 嚙畿嚙緲Http Method嚙請求PUT嚙踝蕭k嚙稽嚙踝蕭s嚙稷
     *
     * @param request Servlet嚙請求嚙踝蕭HttpServletRequest嚙踝蕭Request嚙踝蕭嚙踝蕭]嚙箴嚙豎剁蕭嚙豎）
     * @param response Servlet嚙稷嚙褒歹蕭HttpServletResponse嚙踝蕭Response嚙踝蕭嚙踝蕭]嚙踝蕭搢嚙箴嚙豎）
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doPut(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        /** 嚙緲嚙盤JsonReader嚙踝蕭嚙瞌嚙瞇Request嚙踝蕭JSON嚙賣式嚙踝蕭悛R嚙衛剁蕭嚙稷 */
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();
        
        /** 嚙踝蕭嚙碼嚙篇嚙諸析嚙踝蕭JSONObject嚙踝蕭Request嚙諸潘蕭 */
        int id = jso.getInt("id");
 
        String passORnot = "Pass";

        /** 嚙緲嚙盤嚙褒入嚙踝蕭嚙諸數，嚙編嚙諍一嚙諉以嚙緻嚙褒參數歹蕭嚙罵嚙踝蕭Member嚙踝蕭嚙踝蕭 */
        CheckOut c = new CheckOut(id, passORnot);
        
        /** 嚙緲嚙盤Member嚙踝蕭嚙踝蕭update()嚙踝蕭k嚙豌賂蕭w嚙踝蕭s嚙諉名嚙罵嚙踝蕭嚙踝蕭A嚙稷嚙褒歹蕭嚙踝蕭嚙皚SONObject嚙踝蕭嚙踝蕭 */
        JSONObject data = c.update();
        
        /** 嚙編嚙諍一嚙踝蕭JSONObject嚙諄抬蕭N嚙稷嚙褒歹蕭嚙踝蕭i嚙踝蕭妐嚙� */
        JSONObject resp = new JSONObject();
        resp.put("status", "200");
        resp.put("response", data);
        
        /** 嚙緲嚙盤JsonReader嚙踝蕭嚙踝蕭^嚙褒剁蕭e嚙豎（嚙瘡JSONObject嚙質式嚙稷 */
        jsr.response(resp, response);
    }
    
}