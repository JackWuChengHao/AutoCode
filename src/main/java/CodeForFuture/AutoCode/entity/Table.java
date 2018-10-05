package CodeForFuture.AutoCode.entity;

import java.io.Serializable;

public class Table implements Serializable{
	
	private static final long serialVersionUID = -4773347398631162076L;
	
	public Table() {
		
	}
	
	public Table(int id,String name){
		
		this.setId(id);
		this.setName(name);
	}
	
	private String name;
	
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Table [name=" + name + ", id=" + id + "]";
	}

}
