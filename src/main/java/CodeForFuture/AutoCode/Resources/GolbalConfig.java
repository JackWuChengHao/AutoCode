package CodeForFuture.AutoCode.Resources;

public enum GolbalConfig {
	
	Generator_Dir("./dir/"),Generator_Author("AutoCode");
	
	private String context;
	
	GolbalConfig(String context){
		this.context = context;
	}
	
	public String getContext() {
		return context;
	}
	
	
}
