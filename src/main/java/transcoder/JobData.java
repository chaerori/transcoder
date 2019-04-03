package transcoder;

public class JobData {
	
	private String source; // 변환할 원본 파일 path
	private String target; // 변환 후 생성될 파일 path
	
	public JobData(String source, String target) {
		this.source = source;
		this.target = target;
	}
	
	public String getSource() {
		return this.source;
	}
	public String getTarget() {
		return this.target;
	}
}