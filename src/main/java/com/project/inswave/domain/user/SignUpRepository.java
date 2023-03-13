package com.project.inswave.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository(value="SignUpRepository")
public interface SignUpRepository extends JpaRepository<User, Long> {

	Optional<User> findByinsNum(int insNum);
	
	//지금 이건 count로 임시방편임 .exists 사용해서 변경해야함.
	/* select count(e)>0 from User e where insNum=:insNum /  select count(user0_.insIdx)>0 as col_0_0_ from INS_USER user0_ where user0_.insNum=100413| */
	@Query("select count(e)>0 from User e where insNum=:insNum")
	boolean existsByInsNum(@Param("insNum") int insNum); 
	
	@Query("select count(e)>0 from User e where insId=:insId")
	boolean existsByInsId(@Param("insId") String insId); 

}
