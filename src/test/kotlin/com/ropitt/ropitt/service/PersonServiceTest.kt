package com.ropitt.ropitt.service

import com.ropitt.ropitt.entity.Person
import com.ropitt.ropitt.repository.PersonRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mockito.mock
import java.util.*
import org.mockito.Mockito.`when` as When

class PersonServiceTest {

    private val personRepository = mock(PersonRepository::class.java)

    @InjectMocks
    private val personService = PersonService(personRepository)

    @Test
    fun `findPersonById should return a person by its id`() {
        val person = Person("Francesc")
        When(personRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(person))

        Assertions.assertEquals(person, personService.findPersonById(2).get())
    }
}