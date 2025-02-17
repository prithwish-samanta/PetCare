package dev.prithwish.petcare_monolithic_rest_api.repository;

import dev.prithwish.petcare_monolithic_rest_api.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {
}
