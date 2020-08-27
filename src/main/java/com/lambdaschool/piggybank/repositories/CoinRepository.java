package com.lambdaschool.piggybank.repositories;

import org.springframework.data.repository.CrudRepository;
import com.lambdaschool.piggybank.models.Coin;

public interface CoinRepository extends CrudRepository<Coin, Long> {
}
