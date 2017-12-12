package BasicSession;

import java.sql.Date;

public class sessionAdminUserinfo {

	private int id;
    private String user_code;
    private String user_name;
    private String user_key;
    private String user_role;
    private String user_phone;
    private int flag;
    private String comment;
    private Date create_dttm;
    
    
    
    //用户点击微信公众号时候的菜单
    private String user_weixin_clickmenuitem;
    
    //用户当前的岗位
    private String user_post;

    //用户当前的所属部门
    private String user_src_department;

    //用户当前的权限部门
    private String user_tag_department;
    
    /**
	 * 用户actionKey
	 */
	private String userActionKey;
	/**
	 * @return the userActionKey
	 */
	public String getUserActionKey() {
		return userActionKey;
	}
	/**
	 * @param userActionKey the userActionKey to set
	 */
	public void setUserActionKey(String userActionKey) {
		this.userActionKey = userActionKey;
	}
    //用户绑定的电话
    public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String pUser_phone) {
		this.user_phone = pUser_phone;
	}
    
    //用户当前权限部门
    public String getUser_tag_department() {
		return user_tag_department;
	}

	public void setUser_tag_department(String pUser_tag_department) {
		this.user_tag_department = pUser_tag_department;
	}
	
    //所属部门
    public String getUser_src_department() {
		return user_src_department;
	}

	public void setUser_src_department(String pUser_src_department) {
		this.user_src_department = pUser_src_department;
	}

    
    //所属岗位
    public String getUser_post() {
		return user_post;
	}

	public void setUser_post(String pUser_post) {
		this.user_post = pUser_post;
	}
	

	//点击到的菜单项目
    public String getUser_weixin_clickmenuitem() {
		return user_weixin_clickmenuitem;
	}

	public void setUser_weixin_clickmenuitem(String pUser_weixin_clickmenuitem) {
		this.user_weixin_clickmenuitem = pUser_weixin_clickmenuitem;
	}

    
    
    
	
    public sessionAdminUserinfo(){}
    
    public int getId() {
        return id;
    }
    public void setId(int pid) {
        this.id = pid;
    }
    
    
    public String getUsercode() {
        return user_code;
    }
    public void setUsercode(String puser_id) {
    	this.user_code = puser_id;
    }
    
    public void setUserName(String puser_name) {
        this.user_name = puser_name;
    }
    public String getusername() {
        return user_name;
    }
    
    public void setUserkey(String puser_key) {
        this.user_key = puser_key;
    }
    public String getUserkey() {
    	if (user_key == null){
    		return "";
    	}
        return user_key;
    }
    
    
    public String getUserrole() {
        return user_role;
    }
    public void setUserrole(String puserrole) {
        this.user_role = puserrole;
    }
    
    public int getFlag() {
        return flag;
    }
    public void setFlag(int pflag) {
        this.flag = pflag;
    }
    
    public String getComment() {
        return comment;
    }
    public void setComment(String pcomment) {
        this.comment = pcomment;
    }
    
    public Date getCreate_dttm() {
        return create_dttm;
    }
    public void setCreate_dttm(Date pcreate_dttm) {
        this.create_dttm = pcreate_dttm;
    }
}
