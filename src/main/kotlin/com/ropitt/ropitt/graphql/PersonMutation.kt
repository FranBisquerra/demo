package com.ropitt.ropitt.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.ropitt.ropitt.entity.Person
import com.ropitt.ropitt.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PersonMutation(
        @Autowired
        private val service: PersonService
): GraphQLMutationResolver {

    fun createPerson(name: String): Person = service.createPerson(name)
}