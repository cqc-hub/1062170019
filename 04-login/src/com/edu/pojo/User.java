package com.edu.pojo;

/**
 * @author cqc
 *
 *
 *1、(手打的)定义 private int uid;
	  private String uname;
	  private String pwd;
 *2、source->Generate Getters and Setters ->Select All ->ok
 *
 *3、source->Generate toString()..,->点击Generate
 *
 *4、source->Generate hashCode and..,->点击Generate
 *
 *5、（手打（实际上是不知道快捷键））
 *public User() {
		super();
		
	}
		public User(int uid,String uname,String pwd){
		super();
		this.uid=uid;
		this.uname=uname;
		this.pwd=pwd;
	}
	
 */
public class User {

	private int uid;
	private String uname;
	private String pwd;
	//这里的字段名要和数据库里的所有字段名一致
	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", pwd=" + pwd + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + uid;
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (uid != other.uid)
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		return true;
	}
	
	public User() {
		super();
		
	}
	public User(int uid,String uname,String pwd){
		super();
		this.uid=uid;
		this.uname=uname;
		this.pwd=pwd;
	}
	
	
}
