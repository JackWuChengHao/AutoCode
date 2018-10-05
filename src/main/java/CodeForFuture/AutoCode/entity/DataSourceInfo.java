package CodeForFuture.AutoCode.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class DataSourceInfo implements Serializable {

	private static final long serialVersionUID = 6467487932038832841L;

	private String datasourceAddress;
	
	private String driverclassname;
	
	private String username;
	
	private String password;
	
	public String getDriverclassname() {
		return driverclassname;
	}

	public void setDriverclassname(String driverclassname) {
		this.driverclassname = driverclassname;
	}

	public String getDatasourceAddress() {
		return datasourceAddress;
	}

	public void setDatasourceAddress(String datasourceAddress) {
		this.datasourceAddress = datasourceAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
