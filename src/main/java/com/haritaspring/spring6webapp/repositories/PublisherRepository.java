package com.haritaspring.spring6webapp.repositories;

import com.haritaspring.spring6webapp.model.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
