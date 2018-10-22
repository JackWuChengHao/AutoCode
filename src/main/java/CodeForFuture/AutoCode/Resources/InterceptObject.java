package CodeForFuture.AutoCode.Resources;

import java.io.Serializable;

public class InterceptObject implements Serializable{
	
	private static final long serialVersionUID = 4738587545250311545L;

	
	private String ip;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "InterceptObject [ip=" + ip + "]";
	}
	

}
