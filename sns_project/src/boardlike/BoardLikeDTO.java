package boardlike;

import java.sql.Timestamp;

public class BoardLikeDTO {
	private int boardLikeId;
	private int boardId;
	private String userId;
	private String clickDate;
	private int likeFlag;
	
	public int getBoardLikeId() {
		return boardLikeId;
	}
	public void setBoardLikeId(int boardLikeId) {
		this.boardLikeId = boardLikeId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getClickDate() {
		return clickDate;
	}
	public void setClickDate(String clickDate) {
		this.clickDate = clickDate;
	}
	public int getLikeFlag() {
		return likeFlag;
	}
	public void setLikeFlag(int likeFlag) {
		this.likeFlag = likeFlag;
	}
	
	public BoardLikeDTO(int boardLikeId, int boardId, String userId, String clickDate, int likeFlag) {
		super();
		this.boardLikeId = boardLikeId;
		this.boardId = boardId;
		this.userId = userId;
		this.clickDate = clickDate;
		this.likeFlag = likeFlag;
	}
	@Override
	public String toString() {
		return "BoardLikeDTO [boardLikeId=" + boardLikeId + ", boardId=" + boardId + ", userId=" + userId
				+ ", clickDate=" + clickDate + ", likeFlag=" + likeFlag + "]";
	}
	
	
	
}
