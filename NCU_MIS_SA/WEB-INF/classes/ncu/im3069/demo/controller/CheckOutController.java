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
 * MemberController���O�]class�^�D�n�Ω�B�zMember������Http�ШD�]Request�^�A�~��HttpServlet
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
    
    /** mh�AMemberHelper������PMember��������Ʈw��k�]Sigleton�^ */
    private CheckOutHelper ch =  CheckOutHelper.getHelper();
    
    /**
     * �B�zHttp Method�ШDPOST��k�]�s�W��ơ^
     *
     * @param request Servlet�ШD��HttpServletRequest��Request����]�e�ݨ��ݡ^
     * @param response Servlet�^�Ǥ�HttpServletResponse��Response����]��ݨ�e�ݡ^
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        /** �z�LJsonReader���O�NRequest��JSON�榡��ƸѪR�è��^ */
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();
        
        String passORnot="NotPass";
        /** ���X�g�ѪR��JSONObject��Request�Ѽ� */
        String name = jso.getString("UserId");
        String dorm = jso.getString("dorm");
        String room = jso.getString("room");
        String bed = jso.getString("bed");

        
        /** �إߤ@�ӷs���|������ */
        CheckOut c = new CheckOut(name, dorm, room, bed, passORnot);
        
        /** ����ˬd�O�_����쬰�ŭȡA�Y���h�^�ǿ��~�T�� */
        JSONObject resp = new JSONObject();
        if(!ch.checkDuplicate(c)) {
        	ch.create(c);
        	resp.put("status", "250");}
        else {resp.put("status", "250");}
         
         
            /** �s�ؤ@��JSONObject�Ω�N�^�Ǥ���ƶi��ʸ� */

         
            
            /** �z�LJsonReader����^�Ǩ�e�ݡ]�HJSONObject�覡�^ */
         jsr.response(resp, response);
        

    }

    /**
     * �B�zHttp Method�ШDGET��k�]���o��ơ^
     *
     * @param request Servlet�ШD��HttpServletRequest��Request����]�e�ݨ��ݡ^
     * @param response Servlet�^�Ǥ�HttpServletResponse��Response����]��ݨ�e�ݡ^
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        /** �z�LJsonReader���O�NRequest��JSON�榡��ƸѪR�è��^ */
        JsonReader jsr = new JsonReader(request);
        /** �Y�����z�L�e��AJAX��data�Hkey=value���r��覡�i��ǻ��ѼơA�i�H�����Ѧ���k���^��� */
        String name = jsr.getParameter("UserId");
        System.out.println(name);
        /** �P�_�Ӧr��O�_�s�b�A�Y�s�b�N��n���^�ӧO�|������ơA�_�h�N��n���^������Ʈw���|������� */
        if (name.isEmpty()) {
            /** �z�LMemberHelper����getAll()��k���^�Ҧ��|������ơA�^�Ǥ���Ƭ�JSONObject���� */
            JSONObject query = ch.getAll();
            System.out.println("2");
            /** �s�ؤ@��JSONObject�Ω�N�^�Ǥ���ƶi��ʸ� */
            JSONObject resp = new JSONObject();
            resp.put("status", "200");
            resp.put("response", query);
            /** �z�LJsonReader����^�Ǩ�e�ݡ]�HJSONObject�覡�^ */
            jsr.response(resp, response);
        }
        else {
            /** �z�LMemberHelper����getByID()��k�۸�Ʈw���^�ӦW�|������ơA�^�Ǥ���Ƭ�JSONObject���� */
            JSONObject query = ch.getByname(name);
            /** �s�ؤ@��JSONObject�Ω�N�^�Ǥ���ƶi��ʸ� */
            JSONObject resp = new JSONObject();
            resp.put("status", "200");
            resp.put("response", query);
            System.out.println(query);
            System.out.println("3");
            /** �z�LJsonReader����^�Ǩ�e�ݡ]�HJSONObject�覡�^ */
            jsr.response(resp, response);
        }
    }

    /**
     * �B�zHttp Method�ШDDELETE��k�]�R���^
     *
     * @param request Servlet�ШD��HttpServletRequest��Request����]�e�ݨ��ݡ^
     * @param response Servlet�^�Ǥ�HttpServletResponse��Response����]��ݨ�e�ݡ^
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */


    /**
     * �B�zHttp Method�ШDPUT��k�]��s�^
     *
     * @param request Servlet�ШD��HttpServletRequest��Request����]�e�ݨ��ݡ^
     * @param response Servlet�^�Ǥ�HttpServletResponse��Response����]��ݨ�e�ݡ^
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doPut(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        /** �z�LJsonReader���O�NRequest��JSON�榡��ƸѪR�è��^ */
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();
        
        /** ���X�g�ѪR��JSONObject��Request�Ѽ� */
        int id = jso.getInt("id");
 
        String passORnot = "Pass";

        /** �z�L�ǤJ���ѼơA�s�ؤ@�ӥH�o�ǰѼƤ��|��Member���� */
        CheckOut c = new CheckOut(id, passORnot);
        
        /** �z�LMember����update()��k�ܸ�Ʈw��s�ӦW�|����ơA�^�Ǥ���Ƭ�JSONObject���� */
        JSONObject data = c.update();
        
        /** �s�ؤ@��JSONObject�Ω�N�^�Ǥ���ƶi��ʸ� */
        JSONObject resp = new JSONObject();
        resp.put("status", "200");
        resp.put("response", data);
        
        /** �z�LJsonReader����^�Ǩ�e�ݡ]�HJSONObject�覡�^ */
        jsr.response(resp, response);
    }
    
}