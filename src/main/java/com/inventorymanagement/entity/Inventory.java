package com.inventorymanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;
import lombok.Data;

@Entity
@Data
public class Inventory {
	
	@Id
	@Column
    private Long productId;
	
	 @OneToOne
	    @MapsId  //JPA to use product.id as this entity's id
	    @JoinColumn(name = "product_id")
	    private Product product;

	@Column
    private Integer quantity;
}
