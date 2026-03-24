package se.iths.erikthorell.finkdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.iths.erikthorell.finkdemo.model.BirdPost;

@Repository
public interface BirdPostRepository extends JpaRepository<BirdPost, Long> {
}
