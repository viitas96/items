package dev.powerit.onetomany.repository;

import dev.powerit.onetomany.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
