package transcoder;

public interface JobQueue {
	
	public JobData getJob();
	
	public void addJob(JobData jobData);
}
