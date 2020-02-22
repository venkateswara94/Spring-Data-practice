package org.db.apn.repository;

import org.db.apn.entity.VBSchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VBSchoolRepository extends JpaRepository<VBSchoolEntity, Long> {

}
