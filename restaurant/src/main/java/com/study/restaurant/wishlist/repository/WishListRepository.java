package com.study.restaurant.wishlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.restaurant.wishlist.entity.WishListEntity;

public interface WishListRepository extends JpaRepository<WishListEntity, Long>{

}
