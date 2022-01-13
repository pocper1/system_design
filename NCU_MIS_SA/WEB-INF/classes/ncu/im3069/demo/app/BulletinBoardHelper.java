package ncu.im3069.demo.app;

import java.sql.*;
import java.time.LocalDateTime;
import org.json.*;

import ncu.im3069.demo.util.DBMgr;

//TODO: Auto-generated Javadoc
/**
* <p>
* The Class BulletinBoardHelper<br>
* BulletinBoardHelper���O�]class�^�D�n�޲z�Ҧ��PBulletinBoard�����P��Ʈw����k�]method�^
* </p>
* 
* @author IPLab
* @version 1.0.0
* @since 1.0.0
*/

public class BulletinBoardHelper {
	
	/**
     * ��Ҥơ]Instantiates�^�@�ӷs���]new�^BulletinBoardHelper����<br>
     * �ĥ�Singleton���ݭn�z�Lnew
     */
    private BulletinBoardHelper() {
        
    }
    
    /** �R�A�ܼơA�x�sMemberHelper���� */
    private static BulletinBoardHelper bh;
    
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
    public static BulletinBoardHelper getHelper() {
        /** Singleton�ˬd�O�_�w�g��MemberHelper����A�Y�L�hnew�@�ӡA�Y���h�����^�� */
        if(bh == null) bh = new BulletinBoardHelper();
        
        return bh;
    }
    
    /**
     * �z�L���G��s���]ID�^�R�����G��
     *
     * �������\�� -> �R�����G��
     *
     * @param id ���G��s��
     * @return the JSONObject �^��SQL���浲�G
     */
    public JSONObject deleteByID(int id) {
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
            String sql = "DELETE FROM `missa`.`bulletinboard` WHERE `id` = ? LIMIT 1";
            
            /** �N�ѼƦ^���SQL���O�� */
            pres = conn.prepareStatement(sql);
            pres.setInt(1, id);
            /** ����R����SQL���O�ðO���v�T����� */
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
            DBMgr.close(rs, pres, conn);
        }

        /** �����{����������ɶ� */
        long end_time = System.nanoTime();
        /** �����{������ɶ� */
        long duration = (end_time - start_time);
        
        /** �NSQL���O�B��O�ɶ��P�v�T��ơA�ʸ˦�JSONObject�^�� */
        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("row", row);
        response.put("time", duration);

        return response;
    }
    
    /**
     * ���^�Ҧ����G����
     *
     * @return the JSONObject �^��SQL���浲�G�P�۸�Ʈw���^���Ҧ����
     */
    public JSONObject getAll() {
        /** �s�ؤ@�� BulletinBoard ���� b �ܼơA�Ω�����C�@��d�ߦ^���|����� */
        BulletinBoard b  = null;
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
            String sql = "SELECT * FROM `missa`.`bulletinboard`";
            
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
                int bulletinboard_id = rs.getInt("id");
                String topic = rs.getString("topic");
                String content = rs.getString("content");
                int login_times = rs.getInt("login_times");
                String modify_times = rs.getString("modified");
                /** �N�C�@�����G���Ʋ��ͤ@�W�sBulletinBoard���� */
                b = new BulletinBoard(bulletinboard_id, topic, content, login_times,modify_times);
                /** ���X�ӦW�|������ƨëʸ˦� JSONsonArray �� */
                jsa.put(b.getData());
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
     * �z�L���G��s���]ID�^���o���G����
     *
     * @param id ���G��s��
     * @return the JSON object �^��SQL���浲�G�P�ӷ|���s�����|�����
     */
    public JSONObject getByID(String id) {
        /** �s�ؤ@�� BulletinBoard ���� b �ܼơA�Ω�����C�@��d�ߦ^���|����� */
        BulletinBoard b = null;
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
            String sql = "SELECT * FROM `missa`.`bulletinboard` WHERE `id` = ? LIMIT 1";
            
            /** �N�ѼƦ^���SQL���O�� */
            pres = conn.prepareStatement(sql);
            pres.setString(1, id);
            /** ����d�ߤ�SQL���O�ðO����^�Ǥ���� */
            rs = pres.executeQuery();

            /** �����u����檺SQL���O�A�æL�X **/
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);
            
            /** �z�L while �j�鲾��pointer�A���o�C�@���^�Ǹ�� */
            /** ���T�ӻ���Ʈw�u�|���@���ӷ|���s������ơA�]�����i�H���Ψϥ� while �j�� */
            while(rs.next()) {
                /** �C����@���j���ܦ��@����� */
                row += 1;
                
                /** �N ResultSet ����ƨ��X */
                int bulletinboard_id = rs.getInt("id");
                String topic = rs.getString("topic");
                String content = rs.getString("content");
                int login_times = rs.getInt("login_times");
                
                /** �N�C�@���|����Ʋ��ͤ@�W�sMember���� */
                b = new BulletinBoard(bulletinboard_id, topic, content, login_times);
                /** ���X�ӦW�|������ƨëʸ˦� JSONsonArray �� */
                jsa.put(b.getData());
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
     * ���o�Ӥ��G�椧��s�ɶ�
     *
     * @param b �@�W�|����BulletinBoard����
     * @return the JSON object �^�ǸӤ��G�椧��s�ɶ��]�HJSONObject�i��ʸˡ^
     */
    public JSONObject getLoginTimesStatus(BulletinBoard b) {
        /** �Ω��x�s�ӦW�|�����˯�����s�ɶ������ƻP�|���էO����� */
        JSONObject jso = new JSONObject();
        /** �x�sJDBC�˯���Ʈw��^�Ǥ����G�A�H pointer �覡���ʨ�U�@����� */
        ResultSet rs = null;

        try {
            /** ���o��Ʈw���s�u */
            conn = DBMgr.getConnection();
            /** SQL���O */
            String sql = "SELECT * FROM `missa`.`bulletinboard` WHERE `id` = ? LIMIT 1";
            
            /** �N�ѼƦ^���SQL���O�� */
            pres = conn.prepareStatement(sql);
            pres.setInt(1, b.getID());
            /** ����d�ߤ�SQL���O�ðO����^�Ǥ���� */
            rs = pres.executeQuery();
            
            /** �z�L while �j�鲾��pointer�A���o�C�@���^�Ǹ�� */
            /** ���T�ӻ���Ʈw�u�|���@���ӹq�l�l�󤧸�ơA�]�����i�H���Ψϥ� while�j�� */
            while(rs.next()) {
                /** �N ResultSet ����ƨ��X */
                int login_times = rs.getInt("login_times");
                /** �N��ʸ˦�JSONObject��� */
                jso.put("login_times", login_times);
                // jso.put("status", status); �]���S��status�ҥH���γo�@��A�����ѱ��A����A�ӧ��
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

        return jso;
    }
    
    /**
     * �إ߸Ӥ��G��ܸ�Ʈw	(�������\�� -> �s�W���G��)
     *
     * @param b �@�Ӥ��G�椧BulletinBoard����
     * @return the JSON object �^��SQL���O���椧���G
     */
    public JSONObject create(BulletinBoard b) {
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
            String sql = "INSERT INTO `missa`.`bulletinboard`(`topic`, `content`, `modified`, `created`, `login_times`)"
                    + " VALUES(?, ?, ?, ?, ?)";
            
            /** ���o�һݤ��Ѽ� */
            String topic = b.getTopic();
            String content = b.getContent();
            int login_times = b.getLoginTimes();
            
            /** �N�ѼƦ^���SQL���O�� */
            pres = conn.prepareStatement(sql);
            pres.setString(1, topic);
            pres.setString(2, content);
            pres.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            pres.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            pres.setInt(5, login_times);
            
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
    
    /**
     * ��s�@���G�椧���G����   �M��O�Τ��G��s���h�䪺(WHERE 'id' = ?)->�Ѧ�line139
     *
     * �������\�� -> �ק綠�G�� (�i�H��s���D�A�]�i�H��s���e)
     *
     * @param b �@�W���G�椧BulletinBoard����
     * @return the JSONObject �^��SQL���O���浲�G�P���椧���
     */
    public JSONObject update(BulletinBoard b) {
        /** �����^�Ǥ���� */
        JSONArray jsa = new JSONArray();
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
            String sql = "Update `missa`.`bulletinboard` SET `topic` = ? ,`content` = ? , `modified` = ? WHERE `id` = ?";
            /** ���o�һݤ��Ѽ� */
            int id = b.getID();
            String topic = b.getTopic();
            String content = b.getContent();
            
            /** �N�ѼƦ^���SQL���O�� */
            pres = conn.prepareStatement(sql);
            pres.setString(1, topic);
            pres.setString(2, content);
            pres.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            pres.setInt(4, id);
            /** �����s��SQL���O�ðO���v�T����� */
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
        response.put("row", row);
        response.put("time", duration);
        response.put("data", jsa);
        
        return response;
    }
    
    /**
     * ��s���G���s��Ƥ�������
     *
     * @param b �@�W�|����BulletinBoard����
     */
    public void updateLoginTimes(BulletinBoard b) {
        /** ��s�ɶ��������� */
        int new_times = b.getLoginTimes();
        
        /** �O����ڰ��椧SQL���O */
        String exexcute_sql = "";
        
        try {
            /** ���o��Ʈw���s�u */
            conn = DBMgr.getConnection();
            /** SQL���O */
            String sql = "Update `missa`.`bulletinboard` SET `login_times` = ? WHERE `id` = ?";
            /** ���o�|���s�� */
            int id = b.getID();
            
            /** �N�ѼƦ^���SQL���O�� */
            pres = conn.prepareStatement(sql);
            pres.setInt(1, new_times);
            pres.setInt(2, id);
            /** �����s��SQL���O */
            pres.executeUpdate();

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
    }
}
