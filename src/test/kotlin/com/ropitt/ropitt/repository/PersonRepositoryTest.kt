package com.ropitt.ropitt.repository

import com.ropitt.ropitt.entity.Person
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class PersonRepositoryTest @Autowired constructor(
        val entityManager: TestEntityManager,
        val personRepository: PersonRepository
) {

    @Test
    fun `When findByIdOrNull then return Person`() {
        val person = Person("Pepe")
        entityManager.persist(person)
        entityManager.flush()
        val found = personRepository.findById(person.id).get()
        assertThat(found).isEqualTo(person)
    }
}