package com.tms.Entity;

import org.springframework.stereotype.Component;

@Component
public class TaskVO {
	
private int id;
private String name;
private String Description;
private boolean status;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}


}
