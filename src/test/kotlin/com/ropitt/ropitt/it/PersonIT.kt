package com.ropitt.ropitt.it

import com.fasterxml.jackson.databind.ObjectMapper
import com.graphql.spring.boot.test.GraphQLTestTemplate
import com.ropitt.ropitt.entity.Person
import com.ropitt.ropitt.repository.PersonRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("it")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonIT {

    @MockBean
    private lateinit var personRepository: PersonRepository

    @Autowired
    private lateinit var graphQLTestTemplate: GraphQLTestTemplate

    @Test
    fun `get all users`() {
        `when`(personRepository.findAll()).thenReturn(listOf(Person("pepe")))

        val variables = ObjectMapper().createObjectNode()
        variables.put("count", "1")
        val response = graphQLTestTemplate.perform("graphql/post-get-people.graphql", variables)

        assertThat(response.readTree().toPrettyString())
                .isEqualTo("{\n" +
                            "  \"data\" : {\n" +
                            "    \"people\" : [ {\n" +
                            "      \"name\" : \"pepe\"\n" +
                            "    } ]\n" +
                            "  }\n" +
                            "}")
    }
}