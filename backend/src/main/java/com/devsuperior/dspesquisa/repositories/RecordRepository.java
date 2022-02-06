package com.devsuperior.dspesquisa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dspesquisa.entities.Record;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    @Query("SELECT obj FROM Record obj WHERE "
            + "(COALESCE(:min, NULL) IS NULL OR obj.moment >= :min) AND "
            + "(COALESCE(:max, NULL) IS NULL OR obj.moment <= :max)")
    Page<Record> findByMoments(Instant min, Instant max, Pageable pageable);

}
