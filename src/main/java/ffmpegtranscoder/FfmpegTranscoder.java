package ffmpegtranscoder;

import java.io.IOException;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import transcoder.Transcoder;

public class FfmpegTranscoder implements Transcoder {

	@Override
	public void transcode(String src, String tgt) throws IOException {

		FFmpeg ffmpeg = new FFmpeg("/Users/chaeyoonlee/ffmpeg/bin/ffmpeg");
		FFprobe ffprobe = new FFprobe("/Users/chaeyoonlee/ffmpeg/bin/ffprobe");

		FFmpegBuilder builder = new FFmpegBuilder()

				.setInput(src) // Filename, or a FFmpegProbeResult
				.overrideOutputFiles(true) // Override the output if it exists

				.addOutput(tgt) // Filename for the destination
				.setFormat("flv") // Format is inferred from filename, or can be set

				.disableSubtitle() // No subtiles

				.setAudioChannels(1) // Mono audio
				.setAudioCodec("aac") // using the aac codec
				.setAudioSampleRate(48_000) // at 48KHz
				.setAudioBitRate(32768) // at 32 kbit/s

				.setVideoCodec("libx264") // Video using x264
				.setVideoFrameRate(24, 1) // at 24 frames per second
				.setVideoResolution(640, 480) // at 640x480 resolution

				.done();

		FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
		executor.createJob(builder).run();

		System.out.println(
				"Transcode the file in " + src + " using FF-MPEG. The transformed file is saved in " + tgt + ".");
	}
}