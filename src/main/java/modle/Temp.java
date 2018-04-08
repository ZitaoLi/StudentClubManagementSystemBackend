package modle;

import java.sql.Timestamp;

public class Temp {

	private int id;
	private String title;
	private String content;
	private String time;
	private String place;
	private String imagePath;
	private Timestamp createdTime;
	private String tempName;
	private int userId;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public String getPlace() {
		return place;
	}



	public void setPlace(String place) {
		this.place = place;
	}



	public String getImagePath() {
		return imagePath;
	}



	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}



	public Timestamp getCreatedTime() {
		return createdTime;
	}



	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}



	public String getTempName() {
		return tempName;
	}



	public void setTempName(String tempName) {
		this.tempName = tempName;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	@Override
	public String toString() {
		return "Temp [id=" + id + ", title=" + title + ", content=" + content + ", time=" + time + ", place=" + place
				+ ", imagePath=" + imagePath + ", createdTime=" + createdTime + ", tempName=" + tempName + ", userId="
				+ userId + "]";
	}

	
}
