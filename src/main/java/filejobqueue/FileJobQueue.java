package filejobqueue;

import java.util.LinkedList;
import transcoder.JobData;
import transcoder.JobQueue;

public class FileJobQueue implements JobQueue {
	
	private LinkedList<JobData> jobList = new LinkedList<JobData>();
	
	@Override
	public JobData getJob() {
		if(jobList.isEmpty()) {
			return null;
		}
		JobData data = jobList.getFirst();
		jobList.pop();
		return data;
	}

	@Override
	public void addJob(JobData jobData) {
		jobList.addLast(jobData);
	}
}