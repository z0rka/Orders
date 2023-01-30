package com.example.orders.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Kostiantyn Kvartyrmeister 30.01.2023
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "my_store")
public class OrderedProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Product product;

  @OneToMany
  private Order order;
}
