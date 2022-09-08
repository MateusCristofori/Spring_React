package com.devsuperior.dsmeta.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sales")
public class Sale {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String sellerName;
  private Integer visited;
  private Integer deals;
  private Double amount;
  private LocalDate date;

  public Sale() {
  }

  public Double getAmount() {
    return amount;
  }

  public LocalDate getDate() {
    return date;
  }

  public Integer getDeals() {
    return deals;
  }

  public Long getId() {
    return id;
  }

  public String getSellerName() {
    return sellerName;
  }

  public Integer getVisited() {
    return visited;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public void setDeals(Integer deals) {
    this.deals = deals;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setSellerName(String sellerName) {
    this.sellerName = sellerName;
  }

  public void setVisited(Integer visited) {
    this.visited = visited;
  }

}