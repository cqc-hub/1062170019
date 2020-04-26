package yp.cqc.pojo;

public class User {

	private int uid;
	private String uname;
	private String fav;
	private Address addr;//地址对象 (自创实体类)
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
	 * @return the fav
	 */
	public String getFav() {
		return fav;
	}
	/**
	 * @param fav the fav to set
	 */
	public void setFav(String fav) {
		this.fav = fav;
	}
	/**
	 * @return the addr
	 */
	public Address getAddr() {
		return addr;
	}
	/**
	 * @param addr the addr to set
	 */
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ((fav == null) ? 0 : fav.hashCode());
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
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (fav == null) {
			if (other.fav != null)
				return false;
		} else if (!fav.equals(other.fav))
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", fav=" + fav + ", addr=" + addr + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String uname, String fav, Address addr) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.fav = fav;
		this.addr = addr;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
