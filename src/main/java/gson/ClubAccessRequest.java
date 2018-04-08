package gson;

public class ClubAccessRequest {

	private int userId;
	private int clubId;
	private String clubName;
	private String title;
	private String content;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
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
	
	@Override
	public String toString() {
		return "ClubAccessRequest [userId=" + userId + ", clubId=" + clubId + ", clubName=" + clubName + ", title="
				+ title + ", content=" + content + "]";
	}
	
}
