package ncu.im3069.demo.app;

import java.sql.*;
import java.time.LocalDateTime;
import org.json.*;

import ncu.im3069.demo.util.DBMgr;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class MemberHelper<br>
 * MemberHelper���O�]class�^�D�n�޲z�Ҧ��PMember�����P��Ʈw����k�]method�^
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class CheckOutHelper {
    
    /**
     * ��Ҥơ]Instantiates�^�@�ӷs���]new�^MemberHelper����<br>
     * �ĥ�Singleton���ݭn�z�Lnew
     */
    private CheckOutHelper() {
        
    }
    
    /** �R�A�ܼơA�x�sMemberHelper���� */
    private static CheckOutHelper ch;
    
    /** �x�sJDBC��Ʈw�s�u */
    private Connection conn = null;
    
    /** �x�sJDBC�w�ǳƤ�SQL���O */
    private PreparedStatement pres = null;
    
    /**
     * �R�A��k<br>
     * ��@Singleton�]��ҼҦ��^�A�Ȥ��\�إߤ@��MemberHelper����
     *
     * @return the helper �^��MemberHelper����
     */
    public static CheckOutHelper getHelper() {
        /** Singleton�ˬd�O�_�w�g��MemberHelper����A�Y�L�hnew�@�ӡA�Y���h�����^�� */
        if(ch == null) ch = new CheckOutHelper();
        
        return ch;
    }
    
    /**
     * �z�L�|���s���]ID�^�R���|��
     *
     * @param id �|���s��
     * @return the JSONObject �^��SQL���浲�G
     */

    public JSONObject getAll() {
        /** �s�ؤ@�� Member ���� m �ܼơA�Ω�����C�@��d�ߦ^���|����� */
        CheckOut c = null;
        /** �Ω��x�s�Ҧ��˯��^���|���A�HJSONArray�覡�x�s */
        JSONArray jsa = new JSONArray();
        /** �O����ڰ��椧SQL���O */
        String exexcute_sql = "";
        /** �����{���}�l����ɶ� */
        long start_time = System.nanoTime();
        /** ����SQL�`��� */
        int row = 0;
        /** �x�sJDBC�˯���Ʈw��^�Ǥ����G�A�H pointer �覡���ʨ�U�@����� */
        ResultSet rs = null;
        
        try {
            /** ���o��Ʈw���s�u */
            conn = DBMgr.getConnection();
            /** SQL���O */
            String sql = "SELECT * FROM `missa`.`check_out`";
            
            /** �N�ѼƦ^���SQL���O���A�Y�L�h���Υu�ݭn���� prepareStatement */
            pres = conn.prepareStatement(sql);
            /** ����d�ߤ�SQL���O�ðO����^�Ǥ���� */
            rs = pres.executeQuery();

            /** �����u����檺SQL���O�A�æL�X **/
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);
            
            /** �z�L while �j�鲾��pointer�A���o�C�@���^�Ǹ�� */
            while(rs.next()) {
                /** �C����@���j���ܦ��@����� */
                row += 1;
                
                /** �N ResultSet ����ƨ��X */
                int id = rs.getInt("id");
                String name=rs.getString("name");
                String dorm = rs.getString("dorm");
                String room = rs.getString("room");
                String bed = rs.getString("bed");
                String passORnot = rs.getString("passORnot");
                
                /** �N�C�@���|����Ʋ��ͤ@�W�sMember���� */
                c = new CheckOut(id, name,dorm, room, bed ,passORnot);
                /** ���X�ӦW�|������ƨëʸ˦� JSONsonArray �� */
                jsa.put(c.getData());
            }

        } catch (SQLException e) {
            /** �L�XJDBC SQL���O���~ **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** �Y���~�h�L�X���~�T�� */
            e.printStackTrace();
        } finally {
            /** �����s�u������Ҧ���Ʈw�������귽 **/
            DBMgr.close(rs, pres, conn);
        }
        
        /** �����{����������ɶ� */
        long end_time = System.nanoTime();
        /** �����{������ɶ� */
        long duration = (end_time - start_time);
        
        /** �NSQL���O�B��O�ɶ��B�v�T��ƻP�Ҧ��|����Ƥ�JSONArray�A�ʸ˦�JSONObject�^�� */
        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("row", row);
        response.put("time", duration);
        response.put("data", jsa);

        return response;
    }
    
    /**
     * �z�L�|���s���]ID�^���o�|�����
     *
     * @param id �|���s��
     * @return the JSON object �^��SQL���浲�G�P�ӷ|���s�����|�����
     */
    public JSONObject getByname(String name) {
        /** �s�ؤ@�� Member ���� m �ܼơA�Ω�����C�@��d�ߦ^���|����� */
        String status="notfound";
        /** �x�sJDBC�˯���Ʈw��^�Ǥ����G�A�H pointer �覡���ʨ�U�@����� */
        ResultSet rs = null;
        
        try {
            /** ���o��Ʈw���s�u */
            conn = DBMgr.getConnection();
            /** SQL���O */
            String sql = "SELECT `passORnot` FROM `missa`.`check_out` WHERE `name` = ? LIMIT 1";
            
            /** �N�ѼƦ^���SQL���O�� */
            pres = conn.prepareStatement(sql);
            pres.setString(1, name);
            /** ����d�ߤ�SQL���O�ðO����^�Ǥ���� */
            rs = pres.executeQuery();
            if(rs.next()) {
            	status = rs.getString("passORnot");
            }
            
        } catch (SQLException e) {
            /** �L�XJDBC SQL���O���~ **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** �Y���~�h�L�X���~�T�� */
            e.printStackTrace();
        } finally {
            /** �����s�u������Ҧ���Ʈw�������귽 **/
            DBMgr.close(rs, pres, conn);
        }
        
        /** �����{����������ɶ� */

        /** �����{������ɶ� */

        
        /** �NSQL���O�B��O�ɶ��B�v�T��ƻP�Ҧ��|����Ƥ�JSONArray�A�ʸ˦�JSONObject�^�� */
        JSONObject response = new JSONObject();
        response.put("passORnot", status);
        System.out.println("4");
        System.out.println(status);
        return response;
    }
    
    /**
     * ���o�ӦW�|������s�ɶ��P���ݤ��|���էO
     *
     * @param m �@�W�|����Member����
     * @return the JSON object �^�ǸӦW�|������s�ɶ��P���ݲէO�]�HJSONObject�i��ʸˡ^
     */

    /**
     * �ˬd�ӦW�|�����q�l�l��H�c�O�_���Ƶ��U
     *
     * @param m �@�W�|����Member����
     * @return boolean �Y���Ƶ��U�^��False�A�Y�ӫH�c���s�b�h�^��True
     */
    public boolean checkDuplicate(CheckOut c){
        /** ����SQL�`��ơA�Y���u-1�v�N���Ʈw�˯��|������ */
        int row = -1;
        /** �x�sJDBC�˯���Ʈw��^�Ǥ����G�A�H pointer �覡���ʨ�U�@����� */
        ResultSet rs = null;
        
        try {
            /** ���o��Ʈw���s�u */
            conn = DBMgr.getConnection();
            /** SQL���O */
            String sql = "SELECT count(*) FROM `missa`.`check_out` WHERE `name` = ? AND `dorm` = ? AND `room` = ? AND `bed` = ?";
            
            /** ���o�һݤ��Ѽ� */
            String name=c.getName();
            String dorm = c.getDorm();
            String room = c.getRoom();
            String bed = c.getBed();
            
            /** �N�ѼƦ^���SQL���O�� */
            pres = conn.prepareStatement(sql);
            pres.setString(1, name);
            pres.setString(2, dorm);
            pres.setString(3, room);
            pres.setString(4, bed);
            /** ����d�ߤ�SQL���O�ðO����^�Ǥ���� */
            rs = pres.executeQuery();

            /** �����в����̫�@�C�A���o�ثe���X��b��Ʈw�� */
            rs.next();
            row = rs.getInt("count(*)");
            System.out.print(row);

        } catch (SQLException e) {
            /** �L�XJDBC SQL���O���~ **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** �Y���~�h�L�X���~�T�� */
            e.printStackTrace();
        } finally {
            /** �����s�u������Ҧ���Ʈw�������귽 **/
            DBMgr.close(rs, pres, conn);
        }
        
        /** 
         * �P�_�O�_�w�g���@���ӹq�l�l��H�c�����
         * �Y�L�@���h�^��False�A�_�h�^��True 
         */
        return (row == 0) ? false : true;
    }
    
    /**
     * �إ߸ӦW�|���ܸ�Ʈw
     *
     * @param m �@�W�|����Member����
     * @return the JSON object �^��SQL���O���椧���G
     */
    public JSONObject create(CheckOut c) {
        /** �O����ڰ��椧SQL���O */
        String exexcute_sql = "";
        /** �����{���}�l����ɶ� */
        long start_time = System.nanoTime();
        /** ����SQL�`��� */
        int row = 0;
        
        try {
            /** ���o��Ʈw���s�u */
            conn = DBMgr.getConnection();
            /** SQL���O */
            String sql = "INSERT INTO `missa`.`check_out`(`name`, `dorm`, `room`, `bed`, `created` ,`passORnot`)"
                    + " VALUES(?, ?, ?, ?, ?, ?)";
            
            /** ���o�һݤ��Ѽ� */
            String name=c.getName();
            String dorm = c.getDorm();
            String room = c.getRoom();
            String bed = c.getBed();
            String passORnot = c.getPassORnot();
            /** �N�ѼƦ^���SQL���O�� */
            pres = conn.prepareStatement(sql);
            pres.setString(1, name);
            pres.setString(2, dorm);
            pres.setString(3, room);
            pres.setString(4, bed);
            pres.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            pres.setString(6, passORnot);

            
            /** ����s�W��SQL���O�ðO���v�T����� */
            row = pres.executeUpdate();
            
            /** �����u����檺SQL���O�A�æL�X **/
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);

        } catch (SQLException e) {
            /** �L�XJDBC SQL���O���~ **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** �Y���~�h�L�X���~�T�� */
            e.printStackTrace();
        } finally {
            /** �����s�u������Ҧ���Ʈw�������귽 **/
            DBMgr.close(pres, conn);
        }

        /** �����{����������ɶ� */
        long end_time = System.nanoTime();
        /** �����{������ɶ� */
        long duration = (end_time - start_time);

        /** �NSQL���O�B��O�ɶ��P�v�T��ơA�ʸ˦�JSONObject�^�� */
        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("time", duration);
        response.put("row", row);

        return response;
    }
    public JSONObject update(CheckOut c) {
        /** �����^�Ǥ���� */
        JSONArray jsa = new JSONArray();
        /** �O����ڰ��椧SQL���O */
        String exexcute_sql = "";
        /** �����{���}�l����ɶ� */
        int row = 0;
        
        try {
            /** ���o��Ʈw���s�u */
            conn = DBMgr.getConnection();
            /** SQL���O */
            String sql = "Update `missa`.`check_out` SET `passORnot` = ? WHERE `id` = ?";
            /** ���o�һݤ��Ѽ� */
            int id = c.getID();
            String passORnot = c.getPassORnot();
            
            /** �N�ѼƦ^���SQL���O�� */
            pres = conn.prepareStatement(sql);
            pres.setString(1, passORnot);
            pres.setInt(2, id);
            row = pres.executeUpdate();
            /** �����u����檺SQL���O�A�æL�X **/
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);

        } catch (SQLException e) {
            /** �L�XJDBC SQL���O���~ **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** �Y���~�h�L�X���~�T�� */
            e.printStackTrace();
        } finally {
            /** �����s�u������Ҧ���Ʈw�������귽 **/
            DBMgr.close(pres, conn);
        }
                
        /** �NSQL���O�B��O�ɶ��P�v�T��ơA�ʸ˦�JSONObject�^�� */
        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("row", row);
        response.put("data", jsa);

        return response;
    }    

}
