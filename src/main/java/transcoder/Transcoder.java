package transcoder;

import java.io.IOException;

public interface Transcoder {

	void transcode(String src, String tgt) throws IOException;
}
