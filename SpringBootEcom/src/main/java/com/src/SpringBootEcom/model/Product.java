package com.src.SpringBootEcom.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String brand;
	private String catagory;
	private double price;
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date releaseDate;
	private boolean productAvailable;
	private int stockQuantity;
	private String imageType;
	private String imageName;
	
	@Lob
	private byte[] imageData;
	
	
	
	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public Product() {
	}
	
	public Product(int id) {
		this.id=id;
	}

	public int getId() {
		System.out.println("id : "+id);
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




	public String getBrand() {
		return brand;
	}




	public void setBrand(String brand) {
		this.brand = brand;
	}




	public String getCatagory() {
		return catagory;
	}




	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public Date getReleaseDate() {
		return releaseDate;
	}




	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}




	public boolean isProductAvailable() {
		return productAvailable;
	}




	public void setProductAvailable(boolean productAvailable) {
		this.productAvailable = productAvailable;
	}




	public int getStockQuantity() {
		return stockQuantity;
	}




	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}




	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", brand=" + brand
				+ ", catagory=" + catagory + ", price=" + price + ", releaseDate=" + releaseDate + ", productAvailable="
				+ productAvailable + ", stockQuantity=" + stockQuantity + "]";
	}
	
	
	

}
