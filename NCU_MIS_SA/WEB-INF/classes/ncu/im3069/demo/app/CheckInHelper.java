package ncu.im3069.demo.app;

import java.sql.*;
//import java.time.LocalDateTime;
import org.json.*;

import ncu.im3069.demo.util.DBMgr;



public class CheckInHelper {
	
	private static CheckInHelper ch;
	
	private Connection conn = null;
	
	private PreparedStatement pres = null;
	
	public CheckInHelper() {
		
	}
	
	
	
	public static CheckInHelper getHelper() { 
		if(ch == null) ch = new CheckInHelper();
        
        return ch;
	}
	
	
	
    public JSONObject deleteByID(int id) {
        /** 記錄實際執行之SQL指令 */
        String exexcute_sql = "";
        /** 紀錄程式開始執行時間 */
        long start_time = System.nanoTime();
        /** 紀錄SQL總行數 */
        int row = 0;
        /** 儲存JDBC檢索資料庫後回傳之結果，以 pointer 方式移動到下一筆資料 */
        ResultSet rs = null;
        
        try {
            /** 取得資料庫之連線 */
            conn = DBMgr.getConnection();
            
            /** SQL指令 */
            String sql = "DELETE FROM `missa`.`check_in` WHERE `id` = ? LIMIT 1";
            
            /** 將參數回填至SQL指令當中 */
            pres = conn.prepareStatement(sql);
            pres.setInt(1, id);
            /** 執行刪除之SQL指令並記錄影響之行數 */
            row = pres.executeUpdate();

            /** 紀錄真實執行的SQL指令，並印出 **/
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);
            
        } catch (SQLException e) {
            /** 印出JDBC SQL指令錯誤 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 若錯誤則印出錯誤訊息 */
            e.printStackTrace();
        } finally {
            /** 關閉連線並釋放所有資料庫相關之資源 **/
            DBMgr.close(rs, pres, conn);
        }

        /** 紀錄程式結束執行時間 */
        long end_time = System.nanoTime();
        /** 紀錄程式執行時間 */
        long duration = (end_time - start_time);
        
        /** 將SQL指令、花費時間與影響行數，封裝成JSONObject回傳 */
        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("row", row);
        response.put("time", duration);

        return response;
    }
    
    
    public JSONObject getAll() {
        /** 新建一個 Member 物件之 m 變數，用於紀錄每一位查詢回之會員資料 */
        CheckIn c = null;
        /** 用於儲存所有檢索回之會員，以JSONArray方式儲存 */
        JSONArray jsa = new JSONArray();
        /** 記錄實際執行之SQL指令 */
        String exexcute_sql = "";
        /** 紀錄程式開始執行時間 */
        long start_time = System.nanoTime();
        /** 紀錄SQL總行數 */
        int row = 0;
        /** 儲存JDBC檢索資料庫後回傳之結果，以 pointer 方式移動到下一筆資料 */
        ResultSet rs = null;
        
        try {
            /** 取得資料庫之連線 */
            conn = DBMgr.getConnection();
            /** SQL指令 */
            String sql = "SELECT * FROM `missa`.`check_in`";
            
            /** 將參數回填至SQL指令當中，若無則不用只需要執行 prepareStatement */
            pres = conn.prepareStatement(sql);
            /** 執行查詢之SQL指令並記錄其回傳之資料 */
            rs = pres.executeQuery();

            /** 紀錄真實執行的SQL指令，並印出 **/
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);
            
            /** 透過 while 迴圈移動pointer，取得每一筆回傳資料 */
            while(rs.next()) {
                /** 每執行一次迴圈表示有一筆資料 */
                row += 1;
                
                /** 將 ResultSet 之資料取出 */
                int ci_id = rs.getInt("id");
                String userID = rs.getString("user_id");
                String name = rs.getString("name");
                String dorm = rs.getString("dorm_no");
                String room = rs.getString("room_no");
                String bed = rs.getString("bed_no");
                String checkInStat = rs.getString("check_in_stat");
                boolean isDamaged = rs.getBoolean("is_damaged");
                Timestamp created = rs.getTimestamp("create_time");
                Timestamp modified = rs.getTimestamp("modify_time");
                
                /** 將每一筆會員資料產生一名新Member物件 */
                //int id,String userID, String name, String dorm, String roomNo, String bedNo, boolean isDamaged, Timestamp created, Timestamp modified
                c = new CheckIn(ci_id,userID, name, dorm, room, bed,checkInStat,isDamaged, created, modified);
                //int id,String userID, String name, String dorm, String roomNo, String bedNo,String checkInStat,  boolean isDamaged, Timestamp created, Timestamp modified
                /** 取出該名會員之資料並封裝至 JSONsonArray 內 */
                jsa.put(c.getData());
            }

        } catch (SQLException e) {
            /** 印出JDBC SQL指令錯誤 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 若錯誤則印出錯誤訊息 */
            e.printStackTrace();
        } finally {
            /** 關閉連線並釋放所有資料庫相關之資源 **/
            DBMgr.close(rs, pres, conn);
        }
        
        /** 紀錄程式結束執行時間 */
        long end_time = System.nanoTime();
        /** 紀錄程式執行時間 */
        long duration = (end_time - start_time);
        
        /** 將SQL指令、花費時間、影響行數與所有會員資料之JSONArray，封裝成JSONObject回傳 */
        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("row", row);
        response.put("time", duration);
        response.put("data", jsa);

        return response;
    }
    
    
    
    
    
    public JSONObject getByID(String id) {
        /** 新建一個 Member 物件之 m 變數，用於紀錄每一位查詢回之會員資料 */
        CheckIn c = null;
        /** 用於儲存所有檢索回之會員，以JSONArray方式儲存 */
        JSONArray jsa = new JSONArray();
        /** 記錄實際執行之SQL指令 */
        String exexcute_sql = "";
        /** 紀錄程式開始執行時間 */
        long start_time = System.nanoTime();
        /** 紀錄SQL總行數 */
        int row = 0;
        /** 儲存JDBC檢索資料庫後回傳之結果，以 pointer 方式移動到下一筆資料 */
        ResultSet rs = null;
        
        try {
            /** 取得資料庫之連線 */
            conn = DBMgr.getConnection();
            /** SQL指令 */
            String sql = "SELECT * FROM `missa`.`check_in` WHERE `id` = ? LIMIT 1";
            
            /** 將參數回填至SQL指令當中 */
            pres = conn.prepareStatement(sql);
            pres.setString(1, id);
            /** 執行查詢之SQL指令並記錄其回傳之資料 */
            rs = pres.executeQuery();

            /** 紀錄真實執行的SQL指令，並印出 **/
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);
            
            /** 透過 while 迴圈移動pointer，取得每一筆回傳資料 */
            /** 正確來說資料庫只會有一筆該會員編號之資料，因此其實可以不用使用 while 迴圈 */
            while(rs.next()) {
                /** 每執行一次迴圈表示有一筆資料 */
                //row += 1;
                
                /** 將 ResultSet 之資料取出 */

                int ci_id = rs.getInt("id");
                String userID = rs.getString("user_id");
                String name = rs.getString("name");
                String dorm = rs.getString("dorm_no");
                String room = rs.getString("room_no");
                String bed = rs.getString("bed_no");
                String checkInStat = rs.getString("check_in_stat");
                boolean isDamaged = rs.getBoolean("is_damaged");
                Timestamp created = rs.getTimestamp("create_time");
                Timestamp modified = rs.getTimestamp("modify_time");
                
                /** 將每一筆會員資料產生一名新Member物件 */
                c = new CheckIn(ci_id,userID, name, dorm, room, bed,checkInStat,isDamaged, created, modified);
                /** 取出該名會員之資料並封裝至 JSONsonArray 內 */
                jsa.put(c.getData());
            }
            
        } catch (SQLException e) {
            /** 印出JDBC SQL指令錯誤 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 若錯誤則印出錯誤訊息 */
            e.printStackTrace();
        } finally {
            /** 關閉連線並釋放所有資料庫相關之資源 **/
            DBMgr.close(rs, pres, conn);
        }
        
        /** 紀錄程式結束執行時間 */
        long end_time = System.nanoTime();
        /** 紀錄程式執行時間 */
        long duration = (end_time - start_time);
        
        /** 將SQL指令、花費時間、影響行數與所有會員資料之JSONArray，封裝成JSONObject回傳 */
        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("row", row);
        response.put("time", duration);
        response.put("data", jsa);

        return response;
    }
    
    public JSONObject getByRoom(String dormNo, String roomNo) {
        /** 新建一個 Member 物件之 m 變數，用於紀錄每一位查詢回之會員資料 */
        CheckIn c = null;
        /** 用於儲存所有檢索回之會員，以JSONArray方式儲存 */
        JSONArray jsa = new JSONArray();
        /** 記錄實際執行之SQL指令 */
        String exexcute_sql = "";
        /** 紀錄程式開始執行時間 */
        long start_time = System.nanoTime();
        /** 紀錄SQL總行數 */
        int row = 0;
        /** 儲存JDBC檢索資料庫後回傳之結果，以 pointer 方式移動到下一筆資料 */
        ResultSet rs = null;
        
        try {
            /** 取得資料庫之連線 */
            conn = DBMgr.getConnection();
            /** SQL指令 */
            String sql = "SELECT * FROM `missa`.`check_in` WHERE `dorm_no`=?, `room_no` = ? LIMIT 1";
            
            /** 將參數回填至SQL指令當中 */
            pres = conn.prepareStatement(sql);
            pres.setString(1, dormNo);
            pres.setString(2, roomNo);
            /** 執行查詢之SQL指令並記錄其回傳之資料 */
            rs = pres.executeQuery();

            /** 紀錄真實執行的SQL指令，並印出 **/
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);
            
            /** 透過 while 迴圈移動pointer，取得每一筆回傳資料 */
            /** 正確來說資料庫只會有一筆該會員編號之資料，因此其實可以不用使用 while 迴圈 */
            while(rs.next()) {
                /** 每執行一次迴圈表示有一筆資料 */
                //row += 1;
                
                /** 將 ResultSet 之資料取出 */

                int ci_id = rs.getInt("id");
                String userID = rs.getString("user_id");
                String name = rs.getString("name");
                String dorm = rs.getString("dorm_no");
                String room = rs.getString("room_no");
                String bed = rs.getString("bed_no");
                String checkInStat = rs.getString("check_in_stat");
                boolean isDamaged = rs.getBoolean("is_damaged");
                Timestamp created = rs.getTimestamp("create_time");
                Timestamp modified = rs.getTimestamp("modify_time");
                
                /** 將每一筆會員資料產生一名新Member物件 */
                c = new CheckIn(ci_id,userID, name, dorm, room, bed,checkInStat,isDamaged, created, modified);
                /** 取出該名會員之資料並封裝至 JSONsonArray 內 */
                jsa.put(c.getData());
            }
            
        } catch (SQLException e) {
            /** 印出JDBC SQL指令錯誤 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 若錯誤則印出錯誤訊息 */
            e.printStackTrace();
        } finally {
            /** 關閉連線並釋放所有資料庫相關之資源 **/
            DBMgr.close(rs, pres, conn);
        }
        
        /** 紀錄程式結束執行時間 */
        long end_time = System.nanoTime();
        /** 紀錄程式執行時間 */
        long duration = (end_time - start_time);
        
        /** 將SQL指令、花費時間、影響行數與所有會員資料之JSONArray，封裝成JSONObject回傳 */
        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("row", row);
        response.put("time", duration);
        response.put("data", jsa);

        return response;
    }
    
    
    
    public boolean checkDuplicate(CheckIn c){
        /** 紀錄SQL總行數，若為「-1」代表資料庫檢索尚未完成 */
        int row = -1;
        /** 儲存JDBC檢索資料庫後回傳之結果，以 pointer 方式移動到下一筆資料 */
        ResultSet rs = null;
        
        try {
            /** 取得資料庫之連線 */
            conn = DBMgr.getConnection();
            /** SQL指令 */
            String sql = "SELECT count(*) FROM `missa`.`check_in` WHERE `dorm_no` = ? AND `room_no` = ? AND `bed_no` = ?";
            
            /** 取得所需之參數 */
            String dorm = c.getDormNo();
            String room = c.getRoomNo();
            String bed = c.getBedNo();
            System.out.println(dorm + room + bed);
            
            /** 將參數回填至SQL指令當中 */
            pres = conn.prepareStatement(sql);
            pres.setString(1, dorm);
            pres.setString(2, room);
            pres.setString(3, bed);
            /** 執行查詢之SQL指令並記錄其回傳之資料 */
            rs = pres.executeQuery();

            /** 讓指標移往最後一列，取得目前有幾行在資料庫內 */
            rs.next();
            row = rs.getInt("count(*)");
            System.out.print(row);

        } catch (SQLException e) {
            /** 印出JDBC SQL指令錯誤 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 若錯誤則印出錯誤訊息 */
            e.printStackTrace();
        } finally {
            /** 關閉連線並釋放所有資料庫相關之資源 **/
            DBMgr.close(rs, pres, conn);
        }
        
        /** 
         * 判斷是否已經有一筆該電子郵件信箱之資料
         * 若無一筆則回傳False，否則回傳True 
         */
        return (row == 0) ? false : true;
    }
    
    
    public JSONObject create(CheckIn c) {
        /** 記錄實際執行之SQL指令 */
        String exexcute_sql = "";
        /** 紀錄程式開始執行時間 */
        //long start_time = System.nanoTime();
        /** 紀錄SQL總行數 */
        //int row = 0;
        JSONArray arr = new JSONArray();
        
        long id = -1;
        
        try {
            /** 取得資料庫之連線 */
            conn = DBMgr.getConnection();
            /** SQL指令 */
            String sql = "INSERT INTO `missa`.`check_in`(`user_id`, `name`,`dorm_no`, `room_no`, `bed_no`,`check_in_stat`,`is_damaged`, `create_time` ,`modify_time`)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            /** 取得所需之參數 */
            String userID = c.getUserID();
            String name = c.getName();
            String dorm = c.getDormNo();
            String room = c.getRoomNo();
            String bed = c.getBedNo();
            String checkInStat = c.getCheckInStat();
            boolean isDamaged = c.getIsDamaged();
            Timestamp create = c.getCreateTime();
            Timestamp modify = c.getModifyTime();
            
            /** 將參數回填至SQL指令當中 */
            pres = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pres.setString(1, userID);
            pres.setString(2, name);
            pres.setString(3, dorm);
            pres.setString(4, room);
            pres.setString(5, bed);
            pres.setString(6,checkInStat);
            pres.setBoolean(7, isDamaged);
            pres.setTimestamp(8, create);
            pres.setTimestamp(9, modify);
            

            
            /** 執行新增之SQL指令並記錄影響之行數 */
            pres.executeUpdate();
            
            /** 紀錄真實執行的SQL指令，並印出 **/
            exexcute_sql = pres.toString();
            ResultSet rs = pres.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
            }
            System.out.println(exexcute_sql);

        } catch (SQLException e) {
            /** 印出JDBC SQL指令錯誤 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 若錯誤則印出錯誤訊息 */
            e.printStackTrace();
        } finally {
            /** 關閉連線並釋放所有資料庫相關之資源 **/
            DBMgr.close(pres, conn);
        }

        /** 紀錄程式結束執行時間 */
        //long end_time = System.nanoTime();
        /** 紀錄程式執行時間 */
        //long duration = (end_time - start_time);

        /** 將SQL指令、花費時間與影響行數，封裝成JSONObject回傳 */
        JSONObject response = new JSONObject();
        //response.put("sql", exexcute_sql);
        //response.put("time", duration);
        response.put("id", id);
        response.put("data", arr);
        
        //response.put("row", row);

        return response;
    }
    
    
    public JSONObject update(CheckIn c) {
        /** 紀錄回傳之資料 */
        JSONArray jsa = new JSONArray();
        /** 記錄實際執行之SQL指令 */
        String exexcute_sql = "";
        /** 紀錄程式開始執行時間 */
        long start_time = System.nanoTime();
        /** 紀錄SQL總行數 */
        int row = 0;
        
        try {
            /** 取得資料庫之連線 */
            conn = DBMgr.getConnection();
            /** SQL指令 */
            String sql = "Update `missa`.`check_in` SET `is_damaged` = ?, `check_in_stat` = ? WHERE `id` = ?";
            /** 取得所需之參數 */
            int id = c.getId();
            boolean isDamaged = c.getIsDamaged();
            String checkInStat = c.getCheckInStat();
            
            
            /** 將參數回填至SQL指令當中 */
            pres = conn.prepareStatement(sql);
            pres.setBoolean(1, isDamaged);
            pres.setString(2, checkInStat);
            pres.setInt(3, id);
            /** 執行更新之SQL指令並記錄影響之行數 */
            row = pres.executeUpdate();

            /** 紀錄真實執行的SQL指令，並印出 **/
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);

        } catch (SQLException e) {
            /** 印出JDBC SQL指令錯誤 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 若錯誤則印出錯誤訊息 */
            e.printStackTrace();
        } finally {
            /** 關閉連線並釋放所有資料庫相關之資源 **/
            DBMgr.close(pres, conn);
        }
        
        /** 紀錄程式結束執行時間 */
        long end_time = System.nanoTime();
        /** 紀錄程式執行時間 */
        long duration = (end_time - start_time);
        
        /** 將SQL指令、花費時間與影響行數，封裝成JSONObject回傳 */
        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("row", row);
        response.put("time", duration);
        response.put("data", jsa);

        return response;
    }    
    


}
