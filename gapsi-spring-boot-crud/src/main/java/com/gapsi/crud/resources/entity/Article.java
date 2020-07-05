
package com.gapsi.crud.resources.entity;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ARTICLE_TBL")
public class Article {
	
    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "Identificador del articulo", example = "10")
    private int id;
	@ApiModelProperty(notes = "Nombre del articulo", example = "Mac book pro 15")
	private String name;
    @ApiModelProperty(notes = "Descripcion del articulo", example = "laptop")
    private String description;
    @ApiModelProperty(notes = "Precio del articulo", example = "15000.00")
    private double price;
    @ApiModelProperty(notes = "Modelo del articulo", example = "2015")
    private String model;
    
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
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}   
}