package weibo4j.model;

public class UserIdWapper {

	private String[] uids;
	private long previousCursor;
	private long nextCursor;
	private long totalNumber;
	public UserIdWapper(String[] uids, long previousCursor, long nextCursor,
			long totalNumber) {
		super();
		this.uids = uids;
		this.previousCursor = previousCursor;
		this.nextCursor = nextCursor;
		this.totalNumber = totalNumber;
	}
	public UserIdWapper() {
		uids = new String[0];
		previousCursor = 0;
		nextCursor = 0;
		totalNumber = 0;

	}
	public String[] getUids() {
		return uids;
	}
	public void setUids(String[] uids) {
		this.uids = uids;
	}
	public long getPreviousCursor() {
		return previousCursor;
	}
	public void setPreviousCursor(long previousCursor) {
		this.previousCursor = previousCursor;
	}
	public long getNextCursor() {
		return nextCursor;
	}
	public void setNextCursor(long nextCursor) {
		this.nextCursor = nextCursor;
	}
	public long getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(long totalNumber) {
		this.totalNumber = totalNumber;
	}
	
	
}
