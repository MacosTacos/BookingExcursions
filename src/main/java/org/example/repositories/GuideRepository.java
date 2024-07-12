package org.example.repositories;

import org.example.entities.GuideEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepository extends JpaRepository<GuideEntity, Long> {
}
