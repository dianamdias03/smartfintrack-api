package com.api.smartfintrackapi.dtos;

public class CategoryDTO {
	private Long id;
	private String name;
	private String description;
	private Boolean hasRelatedData;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getHasRelatedData() {
		return hasRelatedData;
	}
	public void setHasRelatedData(Boolean hasRelatedData) {
		this.hasRelatedData = hasRelatedData;
	}
	
}
