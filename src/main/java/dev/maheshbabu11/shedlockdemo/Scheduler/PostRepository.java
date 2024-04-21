package dev.maheshbabu11.shedlockdemo.Scheduler;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Posts, Long> {
}
