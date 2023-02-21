package com.study.restaurant.wishlist.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WishListEntity {

	private Long Id;
	private String title;
	private String category;
	private String address;
	private String readAddress;
	private String homePageLink;
	private String imageLink;
	private boolean isVisit;
	private int visitCount;
	private LocalDateTime lastVisitDate;
}
