package ru.home.shop.query.candy;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CandyEntryJpaRepository extends CrudRepository<CandyEntry, UUID> {
}
