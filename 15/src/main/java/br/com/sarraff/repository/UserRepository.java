package br.com.sarraff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sarraff.data.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("Select u FROM User u WHERE u.userName =:userName")
	User findbyUserName(@Param("userName") String userName);
}
