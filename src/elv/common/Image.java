package elv.common;

public class Image {
	public static final int REJECT = Integer.MAX_VALUE;

	public String reason;
	public String result;

	public Image(String src, String dst) {
		this.reason = src;
		this.result = dst;
	}

}
