package modle;

import java.sql.Timestamp;

public class ClubMember {

	private int id;
	private int clubId;
	private String clubName;
	private int userId;
	private int level;
	private String power;
	private boolean active;
	private Timestamp joinTime;
	private String userName;
	private String userHeaderImage;
	

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserHeaderImage() {
		return userHeaderImage;
	}
	public void setUserHeaderImage(String userHeaderImage) {
		this.userHeaderImage = userHeaderImage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Timestamp getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Timestamp joinTime) {
		this.joinTime = joinTime;
	}
	
	
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	
	@Override
	public String toString() {
		return "ClubMember [id=" + id + ", clubId=" + clubId + ", clubName=" + clubName + ", userId=" + userId
				+ ", level=" + level + ", power=" + power + ", active=" + active + ", joinTime=" + joinTime
				+ ", userName=" + userName + ", userHeaderImage=" + userHeaderImage + "]";
	}
	
	
	
}
