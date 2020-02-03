package com.etherapists.BookStore.BookEntity;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	private long ISBN;
	private String name;
	private String author;
	private String categories;
	@ApiModelProperty(value = "createdDate", hidden = true)
	private ZonedDateTime createdDate;
	@ApiModelProperty(value = "updatedDate", hidden = true)
	private ZonedDateTime updatedDate;

	Book() {
	}

	public Book(String name, String author) {
		this.name = name;
		this.author = author;
	}

	public Book(String name, String author, long ISBN, String categories, ZonedDateTime createdDate,
			ZonedDateTime updatedDate) {

		this.ISBN = ISBN;
		this.name = name;
		this.author = author;
		this.categories = categories;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		categories = categories;
	}

	public ZonedDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(ZonedDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public ZonedDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(ZonedDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

}
