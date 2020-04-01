package com.ropitt.ropitt.it

import com.ropitt.ropitt.repository.PersonRepository
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("it")
class PersonIT {

    @MockBean
    private lateinit var personRepository: PersonRepository

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @LocalServerPort
    private val port = 0
    private val baseUrl = "http://localhost:"

    @Test
    fun `get all users`() {
        `when`(personRepository.findAll()).thenReturn(listOf())

    }
}