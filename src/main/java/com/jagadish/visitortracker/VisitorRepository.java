package com.jagadish.visitortracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {

	@Query("SELECT COUNT(DISTINCT v.ipAddress) FROM Visitor v")
    Long countUniqueVisitors();
	
}
