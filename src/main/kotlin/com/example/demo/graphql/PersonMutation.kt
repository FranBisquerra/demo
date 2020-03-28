package com.example.demo.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.example.demo.entity.Person
import com.example.demo.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PersonMutation(
        @Autowired
        private val service: PersonService
): GraphQLMutationResolver {

    fun createPerson(name: String): Person = service.createPerson(name)
}