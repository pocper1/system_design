package ncu.im3069.demo.app;

import java.sql.*;
import java.time.LocalDateTime;
import org.json.*;

import ncu.im3069.demo.util.DBMgr;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class MemberHelper<br>
 * MemberHelper嚙踝蕭嚙瞌嚙稽class嚙稷嚙瘩嚙緯嚙豬理嚙課佗蕭嚙瞑Member嚙踝蕭嚙踝蕭嚙瞑嚙踝蕭w嚙踝蕭嚙踝蕭k嚙稽method嚙稷
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class CheckOutHelper {
    
    /**
     * 嚙踝蕭狺]Instantiates嚙稷嚙瑾嚙諉新嚙踝蕭嚙稽new嚙稷MemberHelper嚙踝蕭嚙踝蕭<br>
     * 嚙衝伐蕭Singleton嚙踝蕭嚙豎要嚙緲嚙盤new
     */
    private CheckOutHelper() {
        
    }
    
    /** 嚙磋嚙璀嚙豌數，嚙綞嚙編MemberHelper嚙踝蕭嚙踝蕭 */
    private static CheckOutHelper ch;
    
    /** 嚙綞嚙編JDBC嚙踝蕭w嚙編嚙線 */
    private Connection conn = null;
    
    /** 嚙綞嚙編JDBC嚙緩嚙褒備歹蕭SQL嚙踝蕭嚙瞌 */
    private PreparedStatement pres = null;
    
    /**
     * 嚙磋嚙璀嚙踝蕭k<br>
     * 嚙踝蕭@Singleton嚙稽嚙踝蕭瓞狾嚙踝蕭^嚙璀嚙褓歹蕭嚙穀嚙諍立一嚙踝蕭MemberHelper嚙踝蕭嚙踝蕭
     *
     * @return the helper 嚙稷嚙踝蕭MemberHelper嚙踝蕭嚙踝蕭
     */
    public static CheckOutHelper getHelper() {
        /** Singleton嚙誼查嚙瞌嚙稻嚙緩嚙篇嚙踝蕭MemberHelper嚙踝蕭嚙踝蕭A嚙磐嚙盤嚙篁new嚙瑾嚙諉，嚙磐嚙踝蕭嚙篁嚙踝蕭嚙踝蕭嚙稷嚙踝蕭 */
        if(ch == null) ch = new CheckOutHelper();
        
        return ch;
    }
    
    /**
     * 嚙緲嚙盤嚙罵嚙踝蕭嚙編嚙踝蕭嚙稽ID嚙稷嚙磋嚙踝蕭嚙罵嚙踝蕭
     *
     * @param id 嚙罵嚙踝蕭嚙編嚙踝蕭
     * @return the JSONObject 嚙稷嚙踝蕭SQL嚙踝蕭嚙賣結嚙瘦
     */

    public JSONObject getAll() {
        /** 嚙編嚙諍一嚙踝蕭 Member 嚙踝蕭嚙踝蕭 m 嚙豌數，嚙諄抬蕭嚙踝蕭嚙踝蕭C嚙瑾嚙踝蕭d嚙賠回嚙踝蕭嚙罵嚙踝蕭嚙踝蕭嚙� */
        CheckOut c = null;
        /** 嚙諄抬蕭嚙綞嚙編嚙課佗蕭嚙誼荔蕭嚙稷嚙踝蕭嚙罵嚙踝蕭嚙璀嚙瘡JSONArray嚙質式嚙綞嚙編 */
        JSONArray jsa = new JSONArray();
        /** 嚙瞌嚙踝蕭嚙踝蕭痚嚙踝蕭璊刨QL嚙踝蕭嚙瞌 */
        String exexcute_sql = "";
        /** 嚙踝蕭嚙踝蕭嚙緹嚙踝蕭嚙罷嚙締嚙踝蕭嚙踝蕭伅嚙� */
        long start_time = System.nanoTime();
        /** 嚙踝蕭嚙踝蕭SQL嚙窯嚙踝蕭嚙� */
        int row = 0;
        /** 嚙綞嚙編JDBC嚙誼荔蕭嚙踝蕭w嚙踝蕭^嚙褒歹蕭嚙踝蕭嚙瘦嚙璀嚙瘡 pointer 嚙質式嚙踝蕭嚙褊剁蕭U嚙瑾嚙踝蕭嚙踝蕭嚙� */
        ResultSet rs = null;
        
        try {
            /** 嚙踝蕭嚙緻嚙踝蕭w嚙踝蕭嚙編嚙線 */
            conn = DBMgr.getConnection();
            /** SQL嚙踝蕭嚙瞌 */
            String sql = "SELECT * FROM `missa`.`check_out`";
            
            /** 嚙瞇嚙諸數回嚙踝蕭嚙磅QL嚙踝蕭嚙瞌嚙踝蕭嚙璀嚙磐嚙盤嚙篁嚙踝蕭嚙諄只嚙豎要嚙踝蕭嚙踝蕭 prepareStatement */
            pres = conn.prepareStatement(sql);
            /** 嚙踝蕭嚙踝蕭d嚙賠歹蕭SQL嚙踝蕭嚙瞌嚙衛記嚙踝蕭嚙踝蕭^嚙褒歹蕭嚙踝蕭嚙� */
            rs = pres.executeQuery();

            /** 嚙踝蕭嚙踝蕭嚙線嚙踝蕭嚙踝蕭瑼搴QL嚙踝蕭嚙瞌嚙璀嚙衛印嚙碼 **/
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);
            
            /** 嚙緲嚙盤 while 嚙篌嚙賡移嚙踝蕭pointer嚙璀嚙踝蕭嚙緻嚙瘠嚙瑾嚙踝蕭嚙稷嚙褒賂蕭嚙� */
            while(rs.next()) {
                /** 嚙瘠嚙踝蕭嚙踝蕭@嚙踝蕭嚙篌嚙踝蕭嚙豌佗蕭嚙瑾嚙踝蕭嚙踝蕭嚙� */
                row += 1;
                
                /** 嚙瞇 ResultSet 嚙踝蕭嚙踝蕭嚙踝蕭X */
                int id = rs.getInt("id");
                String name=rs.getString("name");
                String dorm = rs.getString("dorm");
                String room = rs.getString("room");
                String bed = rs.getString("bed");
                String passORnot = rs.getString("passORnot");
                
                /** 嚙瞇嚙瘠嚙瑾嚙踝蕭嚙罵嚙踝蕭嚙踝蕭嚙踝蕭秅@嚙磕嚙編Member嚙踝蕭嚙踝蕭 */
                c = new CheckOut(id, name,dorm, room, bed ,passORnot);
                /** 嚙踝蕭嚙碼嚙諉名嚙罵嚙踝蕭嚙踝蕭嚙踝蕭禱妐辿嚙� JSONsonArray 嚙踝蕭 */
                jsa.put(c.getData());
            }

        } catch (SQLException e) {
            /** 嚙盤嚙碼JDBC SQL嚙踝蕭嚙瞌嚙踝蕭嚙羯 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 嚙磐嚙踝蕭嚙羯嚙篁嚙盤嚙碼嚙踝蕭嚙羯嚙確嚙踝蕭 */
            e.printStackTrace();
        } finally {
            /** 嚙踝蕭嚙踝蕭嚙編嚙線嚙踝蕭嚙踝蕭嚙踝蕭狾嚙踝蕭嚙複庫嚙踝蕭嚙踝蕭嚙踝蕭嚙赭源 **/
            DBMgr.close(rs, pres, conn);
        }
        
        /** 嚙踝蕭嚙踝蕭嚙緹嚙踝蕭嚙踝蕭嚙踝蕭嚙踝蕭嚙踝蕭伅嚙� */
        long end_time = System.nanoTime();
        /** 嚙踝蕭嚙踝蕭嚙緹嚙踝蕭嚙踝蕭嚙踝蕭伅嚙� */
        long duration = (end_time - start_time);
        
        /** 嚙瞇SQL嚙踝蕭嚙瞌嚙畿嚙踝蕭O嚙褕塚蕭嚙畿嚙緞嚙確嚙踝蕭P嚙課佗蕭嚙罵嚙踝蕭嚙踝蕭嚙皚SONArray嚙璀嚙褊裝佗蕭JSONObject嚙稷嚙踝蕭 */
        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("row", row);
        response.put("time", duration);
        response.put("data", jsa);

        return response;
    }
    
    /**
     * 嚙緲嚙盤嚙罵嚙踝蕭嚙編嚙踝蕭嚙稽ID嚙稷嚙踝蕭嚙緻嚙罵嚙踝蕭嚙踝蕭嚙�
     *
     * @param id 嚙罵嚙踝蕭嚙編嚙踝蕭
     * @return the JSON object 嚙稷嚙踝蕭SQL嚙踝蕭嚙賣結嚙瘦嚙瞑嚙諉會嚙踝蕭嚙編嚙踝蕭嚙踝蕭嚙罵嚙踝蕭嚙踝蕭嚙�
     */
    public JSONObject getByname(String name) {
        /** 嚙編嚙諍一嚙踝蕭 Member 嚙踝蕭嚙踝蕭 m 嚙豌數，嚙諄抬蕭嚙踝蕭嚙踝蕭C嚙瑾嚙踝蕭d嚙賠回嚙踝蕭嚙罵嚙踝蕭嚙踝蕭嚙� */
        String status="notfound";
        /** 嚙綞嚙編JDBC嚙誼荔蕭嚙踝蕭w嚙踝蕭^嚙褒歹蕭嚙踝蕭嚙瘦嚙璀嚙瘡 pointer 嚙質式嚙踝蕭嚙褊剁蕭U嚙瑾嚙踝蕭嚙踝蕭嚙� */
        ResultSet rs = null;
        
        try {
            /** 嚙踝蕭嚙緻嚙踝蕭w嚙踝蕭嚙編嚙線 */
            conn = DBMgr.getConnection();
            /** SQL嚙踝蕭嚙瞌 */
            String sql = "SELECT `passORnot` FROM `missa`.`check_out` WHERE `name` = ? LIMIT 1";
            
            /** 嚙瞇嚙諸數回嚙踝蕭嚙磅QL嚙踝蕭嚙瞌嚙踝蕭 */
            pres = conn.prepareStatement(sql);
            pres.setString(1, name);
            /** 嚙踝蕭嚙踝蕭d嚙賠歹蕭SQL嚙踝蕭嚙瞌嚙衛記嚙踝蕭嚙踝蕭^嚙褒歹蕭嚙踝蕭嚙� */
            rs = pres.executeQuery();
            if(rs.next()) {
            	status = rs.getString("passORnot");
            }
            
        } catch (SQLException e) {
            /** 嚙盤嚙碼JDBC SQL嚙踝蕭嚙瞌嚙踝蕭嚙羯 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 嚙磐嚙踝蕭嚙羯嚙篁嚙盤嚙碼嚙踝蕭嚙羯嚙確嚙踝蕭 */
            e.printStackTrace();
        } finally {
            /** 嚙踝蕭嚙踝蕭嚙編嚙線嚙踝蕭嚙踝蕭嚙踝蕭狾嚙踝蕭嚙複庫嚙踝蕭嚙踝蕭嚙踝蕭嚙赭源 **/
            DBMgr.close(rs, pres, conn);
        }
        
        /** 嚙踝蕭嚙踝蕭嚙緹嚙踝蕭嚙踝蕭嚙踝蕭嚙踝蕭嚙踝蕭伅嚙� */

        /** 嚙踝蕭嚙踝蕭嚙緹嚙踝蕭嚙踝蕭嚙踝蕭伅嚙� */

        
        /** 嚙瞇SQL嚙踝蕭嚙瞌嚙畿嚙踝蕭O嚙褕塚蕭嚙畿嚙緞嚙確嚙踝蕭P嚙課佗蕭嚙罵嚙踝蕭嚙踝蕭嚙皚SONArray嚙璀嚙褊裝佗蕭JSONObject嚙稷嚙踝蕭 */
        JSONObject response = new JSONObject();
        response.put("passORnot", status);
        System.out.println("4");
        System.out.println(status);
        return response;
    }
    
    /**
     * 嚙踝蕭嚙緻嚙諉名嚙罵嚙踝蕭嚙踝蕭嚙踝蕭s嚙褕塚蕭嚙瞑嚙踝蕭嚙豎歹蕭嚙罵嚙踝蕭嚙調別
     *
     * @param m 嚙瑾嚙磕嚙罵嚙踝蕭嚙踝蕭Member嚙踝蕭嚙踝蕭
     * @return the JSON object 嚙稷嚙褒該名嚙罵嚙踝蕭嚙踝蕭嚙踝蕭s嚙褕塚蕭嚙瞑嚙踝蕭嚙豎組別嚙稽嚙瘡JSONObject嚙箠嚙踝蕭妐芊^
     */

    /**
     * 嚙誼查嚙諉名嚙罵嚙踝蕭嚙踝蕭嚙緬嚙締嚙締嚙踝蕭H嚙箱嚙瞌嚙稻嚙踝蕭嚙複蛛蕭嚙磊
     *
     * @param m 嚙瑾嚙磕嚙罵嚙踝蕭嚙踝蕭Member嚙踝蕭嚙踝蕭
     * @return boolean 嚙磐嚙踝蕭嚙複蛛蕭嚙磊嚙稷嚙踝蕭False嚙璀嚙磐嚙諉信嚙箱嚙踝蕭嚙編嚙箭嚙篁嚙稷嚙踝蕭True
     */
    public boolean checkDuplicate(CheckOut c){
        /** 嚙踝蕭嚙踝蕭SQL嚙窯嚙踝蕭A嚙磐嚙踝蕭嚙線-1嚙緞嚙瞇嚙踝蕭嚙複庫嚙誼荔蕭嚙罵嚙踝蕭嚙踝蕭嚙踝蕭 */
        int row = -1;
        /** 嚙綞嚙編JDBC嚙誼荔蕭嚙踝蕭w嚙踝蕭^嚙褒歹蕭嚙踝蕭嚙瘦嚙璀嚙瘡 pointer 嚙質式嚙踝蕭嚙褊剁蕭U嚙瑾嚙踝蕭嚙踝蕭嚙� */
        ResultSet rs = null;
        
        try {
            /** 嚙踝蕭嚙緻嚙踝蕭w嚙踝蕭嚙編嚙線 */
            conn = DBMgr.getConnection();
            /** SQL嚙踝蕭嚙瞌 */
            String sql = "SELECT count(*) FROM `missa`.`check_out` WHERE `name` = ? ";
            
            /** 嚙踝蕭嚙緻嚙課需歹蕭嚙諸潘蕭 */
            String name=c.getName();

            
            /** 嚙瞇嚙諸數回嚙踝蕭嚙磅QL嚙踝蕭嚙瞌嚙踝蕭 */
            pres = conn.prepareStatement(sql);
            pres.setString(1, name);
            /** 嚙踝蕭嚙踝蕭d嚙賠歹蕭SQL嚙踝蕭嚙瞌嚙衛記嚙踝蕭嚙踝蕭^嚙褒歹蕭嚙踝蕭嚙� */
            rs = pres.executeQuery();

            /** 嚙踝蕭嚙踝蕭嚙請莎蕭嚙踝蕭嚙諒恬蕭@嚙瘠嚙璀嚙踝蕭嚙緻嚙諍前嚙踝蕭嚙碼嚙踝蕭b嚙踝蕭w嚙踝蕭 */
            rs.next();
            row = rs.getInt("count(*)");
            System.out.print(row);

        } catch (SQLException e) {
            /** 嚙盤嚙碼JDBC SQL嚙踝蕭嚙瞌嚙踝蕭嚙羯 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 嚙磐嚙踝蕭嚙羯嚙篁嚙盤嚙碼嚙踝蕭嚙羯嚙確嚙踝蕭 */
            e.printStackTrace();
        } finally {
            /** 嚙踝蕭嚙踝蕭嚙編嚙線嚙踝蕭嚙踝蕭嚙踝蕭狾嚙踝蕭嚙複庫嚙踝蕭嚙踝蕭嚙踝蕭嚙赭源 **/
            DBMgr.close(rs, pres, conn);
        }
        
        /** 
         * 嚙瞑嚙稻嚙瞌嚙稻嚙緩嚙篇嚙踝蕭嚙瑾嚙踝蕭嚙諉電嚙締嚙締嚙踝蕭H嚙箱嚙踝蕭嚙踝蕭嚙�
         * 嚙磐嚙盤嚙瑾嚙踝蕭嚙篁嚙稷嚙踝蕭False嚙璀嚙稻嚙篁嚙稷嚙踝蕭True 
         */
        return (row == 0) ? false : true;
    }
    
    /**
     * 嚙諍立該名嚙罵嚙踝蕭嚙豌賂蕭w
     *
     * @param m 嚙瑾嚙磕嚙罵嚙踝蕭嚙踝蕭Member嚙踝蕭嚙踝蕭
     * @return the JSON object 嚙稷嚙踝蕭SQL嚙踝蕭嚙瞌嚙踝蕭嚙賣之嚙踝蕭嚙瘦
     */
    public JSONObject create(CheckOut c) {
        /** 嚙瞌嚙踝蕭嚙踝蕭痚嚙踝蕭璊刨QL嚙踝蕭嚙瞌 */
        String exexcute_sql = "";
        /** 嚙踝蕭嚙踝蕭嚙緹嚙踝蕭嚙罷嚙締嚙踝蕭嚙踝蕭伅嚙� */
        long start_time = System.nanoTime();
        /** 嚙踝蕭嚙踝蕭SQL嚙窯嚙踝蕭嚙� */
        int row = 0;
        
        try {
            /** 嚙踝蕭嚙緻嚙踝蕭w嚙踝蕭嚙編嚙線 */
            conn = DBMgr.getConnection();
            /** SQL嚙踝蕭嚙瞌 */
            String sql = "INSERT INTO `missa`.`check_out`(`name`, `dorm`, `room`, `bed`, `created` ,`passORnot`)"
                    + " VALUES(?, ?, ?, ?, ?, ?)";
            
            /** 嚙踝蕭嚙緻嚙課需歹蕭嚙諸潘蕭 */
            String name=c.getName();
            String dorm = c.getDorm();
            String room = c.getRoom();
            String bed = c.getBed();
            String passORnot = c.getPassORnot();
            /** 嚙瞇嚙諸數回嚙踝蕭嚙磅QL嚙踝蕭嚙瞌嚙踝蕭 */
            pres = conn.prepareStatement(sql);
            pres.setString(1, name);
            pres.setString(2, dorm);
            pres.setString(3, room);
            pres.setString(4, bed);
            pres.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            pres.setString(6, passORnot);

            
            /** 嚙踝蕭嚙踝蕭s嚙磕嚙踝蕭SQL嚙踝蕭嚙瞌嚙衛記嚙踝蕭嚙緞嚙確嚙踝蕭嚙踝蕭嚙� */
            row = pres.executeUpdate();
            
            /** 嚙踝蕭嚙踝蕭嚙線嚙踝蕭嚙踝蕭瑼搴QL嚙踝蕭嚙瞌嚙璀嚙衛印嚙碼 **/
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);

        } catch (SQLException e) {
            /** 嚙盤嚙碼JDBC SQL嚙踝蕭嚙瞌嚙踝蕭嚙羯 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 嚙磐嚙踝蕭嚙羯嚙篁嚙盤嚙碼嚙踝蕭嚙羯嚙確嚙踝蕭 */
            e.printStackTrace();
        } finally {
            /** 嚙踝蕭嚙踝蕭嚙編嚙線嚙踝蕭嚙踝蕭嚙踝蕭狾嚙踝蕭嚙複庫嚙踝蕭嚙踝蕭嚙踝蕭嚙赭源 **/
            DBMgr.close(pres, conn);
        }

        /** 嚙踝蕭嚙踝蕭嚙緹嚙踝蕭嚙踝蕭嚙踝蕭嚙踝蕭嚙踝蕭伅嚙� */
        long end_time = System.nanoTime();
        /** 嚙踝蕭嚙踝蕭嚙緹嚙踝蕭嚙踝蕭嚙踝蕭伅嚙� */
        long duration = (end_time - start_time);

        /** 嚙瞇SQL嚙踝蕭嚙瞌嚙畿嚙踝蕭O嚙褕塚蕭嚙瞑嚙緞嚙確嚙踝蕭A嚙褊裝佗蕭JSONObject嚙稷嚙踝蕭 */
        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("time", duration);
        response.put("row", row);

        return response;
    }
    public JSONObject update(CheckOut c) {
        /** 嚙踝蕭嚙踝蕭嚙稷嚙褒歹蕭嚙踝蕭嚙� */
        JSONArray jsa = new JSONArray();
        /** 嚙瞌嚙踝蕭嚙踝蕭痚嚙踝蕭璊刨QL嚙踝蕭嚙瞌 */
        String exexcute_sql = "";
        /** 嚙踝蕭嚙踝蕭嚙緹嚙踝蕭嚙罷嚙締嚙踝蕭嚙踝蕭伅嚙� */
        int row = 0;
        
        try {
            /** 嚙踝蕭嚙緻嚙踝蕭w嚙踝蕭嚙編嚙線 */
            conn = DBMgr.getConnection();
            /** SQL嚙踝蕭嚙瞌 */
            String sql = "Update `missa`.`check_out` SET `passORnot` = ? WHERE `id` = ?";
            /** 嚙踝蕭嚙緻嚙課需歹蕭嚙諸潘蕭 */
            int id = c.getID();
            String passORnot = c.getPassORnot();
            
            /** 嚙瞇嚙諸數回嚙踝蕭嚙磅QL嚙踝蕭嚙瞌嚙踝蕭 */
            pres = conn.prepareStatement(sql);
            pres.setString(1, passORnot);
            pres.setInt(2, id);
            row = pres.executeUpdate();
            /** 嚙踝蕭嚙踝蕭嚙線嚙踝蕭嚙踝蕭瑼搴QL嚙踝蕭嚙瞌嚙璀嚙衛印嚙碼 **/
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);

        } catch (SQLException e) {
            /** 嚙盤嚙碼JDBC SQL嚙踝蕭嚙瞌嚙踝蕭嚙羯 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 嚙磐嚙踝蕭嚙羯嚙篁嚙盤嚙碼嚙踝蕭嚙羯嚙確嚙踝蕭 */
            e.printStackTrace();
        } finally {
            /** 嚙踝蕭嚙踝蕭嚙編嚙線嚙踝蕭嚙踝蕭嚙踝蕭狾嚙踝蕭嚙複庫嚙踝蕭嚙踝蕭嚙踝蕭嚙赭源 **/
            DBMgr.close(pres, conn);
        }
                
        /** 嚙瞇SQL嚙踝蕭嚙瞌嚙畿嚙踝蕭O嚙褕塚蕭嚙瞑嚙緞嚙確嚙踝蕭A嚙褊裝佗蕭JSONObject嚙稷嚙踝蕭 */
        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("row", row);
        response.put("data", jsa);

        return response;
    }    

}
