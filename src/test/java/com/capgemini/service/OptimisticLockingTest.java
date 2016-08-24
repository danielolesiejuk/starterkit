package com.capgemini.service;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.PracownikEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OptimisticLockingTest {

	@Autowired
	private PracownikService pracownikService;
	@Autowired
	private EntityManager entityManager;

	@Test(expected = OptimisticLockException.class)
	@Transactional
	public void shouldUseOptimisticLocking() {
		// given
		PracownikEntity firstWorkerWithId1 = pracownikService.znajdzPracownikaPoId(1L);
		entityManager.detach(firstWorkerWithId1);
		PracownikEntity secondWorkerWithId1 = pracownikService.znajdzPracownikaPoId(1L);
		entityManager.detach(secondWorkerWithId1);
		
		// when
		firstWorkerWithId1.setImie("Daniel");
		secondWorkerWithId1.setImie("Sebastian");

		entityManager.merge(firstWorkerWithId1);
		entityManager.flush();
		entityManager.merge(secondWorkerWithId1);
		// then
	}

}
