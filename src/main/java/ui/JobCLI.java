package ui;

import java.util.Scanner;
import transcoder.JobData;
import transcoder.JobQueue;

public class JobCLI {

	private Scanner scan = new Scanner(System.in);
	
	private JobQueue jobQueue;
	
	public JobCLI() {}
	
	public JobCLI(JobQueue jobQueue) {
		if (jobQueue == null)
			throw new IllegalArgumentException();
		this.jobQueue = jobQueue;
	}
	
	public void setJobQueue(JobQueue jobQueue) {
		this.jobQueue = jobQueue;
	}
	
	public void printInputSourceMessage() {
		System.out.print("Input the path of SOURCE file: ");
	}
	
	public void printInputTargetMessage() {
		System.out.print("Input the path of TARGET file: ");
	}
	
	public String getSourceFromConsole() {
		String source = this.scan.nextLine();
		source = source.trim();
		return source;
	}
	
	public String getTargetFromConsole() {
		String target = this.scan.nextLine();
		target = target.trim();
		return target;
	}
	
	public void interact() {
		printInputSourceMessage();
		String source = getSourceFromConsole();
		printInputTargetMessage();
		String target = getTargetFromConsole();
		
		jobQueue.addJob(new JobData(source, target));
	}
}
