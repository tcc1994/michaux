package com.tcc.main.dto.usr;

/**
 * @Description 当前用户
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年11月1日 下午4:52:22
 */
public class CurUser {

	private Long usId;

    private Long usPhone;

    private String usNickname;

    private Integer usRegClient;

    private Integer usFrozen;

	/**
	 * @return the usId
	 */
	public Long getUsId() {
		return usId;
	}

	/**
	 * @param usId the usId to set
	 */
	public void setUsId(Long usId) {
		this.usId = usId;
	}

	/**
	 * @return the usPhone
	 */
	public Long getUsPhone() {
		return usPhone;
	}

	/**
	 * @param usPhone the usPhone to set
	 */
	public void setUsPhone(Long usPhone) {
		this.usPhone = usPhone;
	}

	/**
	 * @return the usNickname
	 */
	public String getUsNickname() {
		return usNickname;
	}

	/**
	 * @param usNickname the usNickname to set
	 */
	public void setUsNickname(String usNickname) {
		this.usNickname = usNickname;
	}

	/**
	 * @return the usRegClient
	 */
	public Integer getUsRegClient() {
		return usRegClient;
	}

	/**
	 * @param usRegClient the usRegClient to set
	 */
	public void setUsRegClient(Integer usRegClient) {
		this.usRegClient = usRegClient;
	}

	/**
	 * @return the usFrozen
	 */
	public Integer getUsFrozen() {
		return usFrozen;
	}

	/**
	 * @param usFrozen the usFrozen to set
	 */
	public void setUsFrozen(Integer usFrozen) {
		this.usFrozen = usFrozen;
	}
    
    
}
