package main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ffmpegtranscoder.FfmpegTranscoder;
import filejobqueue.FileJobQueue;
import transcoder.JobQueue;
import transcoder.Transcoder;
import transcoder.Worker;
import ui.JobCLI;

@Configuration
public class TranscoderConfig {
	
	@Bean
	public JobQueue fileJobQueue() {
		return new FileJobQueue();
	}
	
	@Bean
	public Transcoder ffmpegTranscoder() {
		return new FfmpegTranscoder();
	}
	
	@Bean
	public Worker worker() {
		return new Worker(fileJobQueue(), ffmpegTranscoder());
	}
	
	@Bean
	public JobCLI jobCli() {
		JobCLI jobCli = new JobCLI();
		jobCli.setJobQueue(fileJobQueue());
		return jobCli;
	}
}