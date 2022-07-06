package com.xxnbr.cursomc.repositories;

import com.xxnbr.cursomc.domain.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedItemRepository extends JpaRepository<OrderedItem, Integer> {
}
