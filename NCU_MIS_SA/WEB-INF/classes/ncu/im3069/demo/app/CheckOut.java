package ncu.im3069.demo.app;

import org.json.*;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class Member
 * Member���O�]class�^�㦳�|���һݭn���ݩʻP��k�A�åB�x�s�P�|���������ӷ~�P�_�޿�<br>
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class CheckOut {
    

    private int id;
    
    private String name;

    private String dorm;
    

    private String room;
    

    private String bed;
    
    private String passORnot;
    
    
    /** mh�AMemberHelper������PMember��������Ʈw��k�]Sigleton�^ */
    private CheckOutHelper ch =  CheckOutHelper.getHelper();
    
    /**
     * ��Ҥơ]Instantiates�^�@�ӷs���]new�^Member����<br>
     * �ĥΦh���]overload�^��k�i��A���غc�l�Ω�إ߷|����ƮɡA���ͤ@�W�s���|��
     *
     * @param email �|���q�l�H�c
     * @param password �|���K�X
     * @param name �|���m�W
     */
    public CheckOut(String name,String dorm, String room, String bed,String passORnot) {
    	this.name=name;
        this.dorm = dorm;
        this.room = room;
        this.bed = bed;
        this.passORnot = passORnot;
    }
    
    public CheckOut(int id, String name,String dorm, String room, String bed,String passORnot) {
    	this.id = id;
    	this.name=name;
        this.dorm = dorm;
        this.room = room;
        this.bed = bed;
        this.passORnot = passORnot;
    }

    public CheckOut(int id,String passORnot) {
    	this.id = id;
        this.passORnot = passORnot;
    }

    
    
    /**
     * ���o�|�����s��
     *
     * @return the id �^�Ƿ|���s��
     */
    public int getID() {
        return this.id;
    }
    public String getName() {
    	return this.name;
    }
    /**
     * ���o�|�����q�l�l��H�c
     *
     * @return the email �^�Ƿ|���q�l�l��H�c
     */
    public String getDorm() {
        return this.dorm;
    }
    
    /**
     * ���o�|�����m�W
     *
     * @return the name �^�Ƿ|���m�W
     */
    public String getRoom() {
        return this.room;
    }

    /**
     * ���o�|�����K�X
     *
     * @return the password �^�Ƿ|���K�X
     */
    public String getBed() {
        return this.bed;
    }
    
    public String getPassORnot() {
        return this.passORnot;
    }
    
    /**
     * ��s�|�����
     *
     * @return the JSON object �^��SQL��s�����G�P�����ʸˤ����
     */
    public JSONObject update() {
        /** �s�ؤ@��JSONObject�ΥH�x�s��s�ᤧ��� */
        JSONObject data = new JSONObject();
        data = ch.update(this);
        return data;
    }
    
    /**
     * ���o�ӦW�|���Ҧ����
     *
     * @return the data ���o�ӦW�|�����Ҧ���ƨëʸ˩�JSONObject����
     */
    public JSONObject getData() {
        /** �z�LJSONObject�N�ӦW�|���һݤ���ƥ����i��ʸ�*/ 
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("name",getName());
        jso.put("dorm", getDorm());
        jso.put("room", getRoom());
        jso.put("bed", getBed());
        jso.put("passORnot", getPassORnot());

        return jso;
    }
    


}