package com.project.inswave.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Repository
public interface SignInRepository extends JpaRepository<User, Long> {
	Optional<User> findByInsnum(int insNum);
}
