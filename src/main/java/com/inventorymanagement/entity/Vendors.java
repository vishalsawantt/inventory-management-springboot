package com.inventorymanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vendors {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

	@Column
    private String name;
    
	@Column
    private String phone;
    
	@Column
    private String email;
    
	@Column
    private String address;

}
