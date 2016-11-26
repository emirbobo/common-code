package kryo.model;

import java.io.Serializable;

public class ZookeeperTest1 implements Serializable{
	
	private String name;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String print(){
		
		return System.currentTimeMillis()+"";
	}
}
