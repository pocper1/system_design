package ncu.im3069.demo.app;
import java.util.Calendar;

import org.json.JSONObject;

//TODO: Auto-generated Javadoc
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

public class BulletinBoard {
	
	/**����i��|�A�ŧi�@���ܼƬO�Ψ��x�s�гy���G�檺�H�O�֡A�ӭ�n��ȤW�ڭ̭���u���޲z���i�H�Ыؤ��G��A�ҥH�o���ܼ����ӴN�O�Ψ��x�s �Ыؤ��G�檺�޲z��**/
	
	/** id ���G��s�� */
	private int id;
	
	/** title�A���i����D */
	private String topic;
	
	/**content�A���i�椺�e */
	private String content;
	
	/** login_times�A��s�ɶ��������� */
    private int login_times;
    private String modify_times;
    
    /** bh�ABulletinBoardHelper������PBulletinBoard��������Ʈw��k�]Sigleton�^ */
    private BulletinBoardHelper bh = BulletinBoardHelper.getHelper();
    
    /**
     * ��Ҥơ]Instantiates�^�@�ӷs���]new�^BulletinBoard����<br>
     * �ĥΦh���]overload�^��k�i��A���غc�l�Ω�إ߷|����ƮɡA���ͤ@�W�s���|��
     *
     * @param topic ���G����D
     * @param content ���G�椺�e
     */
    public BulletinBoard(String topic, String content) {
        this.topic = topic;
        this.content = content;
        update();
    }
	
	/**
     * ��Ҥơ]Instantiates�^�@�ӷs���]new�^BulletinBoard����<br>
     * �ĥΦh���]overload�^��k�i��A���غc�l�Ω��s���G���ƮɡA���ͤ@�Ӥ��G��P�ɻݭn�h��Ʈw�˯��즳��s�ɶ�������
     *
     * @param id ���G��s��
     * @param topic ���i����D
     * @param content ���i�椺�e
     */
	public BulletinBoard(int id, String topic, String content){
		this.id = id;
		this.topic = topic;
		this.content = content;
		/** ���^�즳��Ʈw���ӦW�|������s�ɶ������ƻP�էO */
        getLoginTimesStatus();
	}
	
	/**
     * ��Ҥơ]Instantiates�^�@�ӷs���]new�^BulletinBoard����<br>
     * �ĥΦh���]overload�^��k�i��A���غc�l�Ω�d�ߤ��G���ƮɡA�N�C�@����Ʒs�W���@�Ӥ��G�檫��
     *
     * @param id ���G��s��
     * @param topic ���i����D
     * @param content ���i�椺�e
     * @param login_times ��s�ɶ���������
     */
    public BulletinBoard(int id, String topic, String content, int login_times) {
    	this.id = id;
    	this.topic = topic;
    	this.content =content;
    	this.login_times = login_times;
    }
    public BulletinBoard(int id, String topic, String content, int login_times,String modify_times) {
    	this.id = id;
    	this.topic = topic;
    	this.content =content;
    	this.login_times = login_times;
    	this.modify_times=modify_times;
    }
	
	/**
     * ���o���G�椧�s��
     *
     * @return the id �^�Ǥ��G��s��
     */
    public int getID() {
        return this.id;
    }
	
	/**
     * ���o�޲z�������i����D
     *
     * @return the title �^�Ǻ޲z�������i����D
     */
	public String getTopic() {
		return this.topic;
	}
	public String getModifyTimes() {
		return this.modify_times;
	}
	
	/**
     * ���o�޲z�������i�椺�e
     *
     * @return the content �^�Ǻ޲z�������i�椺�e
     */
	public String getContent() {
		return this.content;
	}
	
	/**
     * ���o��s��Ʈɶ���������
     *
     * @return the login times �^�ǧ�s��Ʈɶ���������
     */

    public int getLoginTimes() {
        return this.login_times;
    }
    
    /**
     * ��s���G����
     *
     * @return the JSON object �^��SQL��s�����G�P�����ʸˤ����
     */
    public JSONObject update() {
        /** �s�ؤ@��JSONObject�ΥH�x�s��s�ᤧ��� */
        JSONObject data = new JSONObject();
        /** ���o��s��Ʈɶ��]�Y�{�b���ɶ��^�������� */
        Calendar calendar = Calendar.getInstance();
        this.login_times = calendar.get(Calendar.MINUTE);
        
        /** �ˬd�Ӥ��G��O�_�w�g�b��Ʈw */
        if(this.id != 0) {
            /** �Y���h�N�ثe��s�ᤧ��Ƨ�s�ܸ�Ʈw�� */
            bh.updateLoginTimes(this);
            /** �z�LMemberHelper����A��s�ثe���|����Ƹm��Ʈw�� */
            data = bh.update(this);
        }
        
        return data;
    }
    
    /**
     * ���o�Ӥ��G��Ҧ����
     *
     * @return the data ���o�ӥ��i�椧�Ҧ���ƨëʸ˩�JSONObject����
     */
    public JSONObject getData() {
        /** �z�LJSONObject�N�ӦW�|���һݤ���ƥ����i��ʸ�*/ 
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("topic", getTopic());
        jso.put("content", getContent());
        jso.put("login_times", getLoginTimes());
        jso.put("modify_times", getModifyTimes());
        
        return jso;
    }
    
    /**
     * ���o��Ʈw������s��Ʈɶ�������
     *
     */
    private void getLoginTimesStatus() {
        /** �z�LBulletinBoardHelper����A���o�x�s���Ʈw����s�ɶ������ƻP�|���էO */
        JSONObject data = bh.getLoginTimesStatus(this);
        /** �N��Ʈw���x�s�Ӥ��G�椧������ƫ�����BulletinBoard�����ݩ� */
        this.login_times = data.getInt("login_times");
    }
}
