package com.example.demo.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.example.demo.entity.Person
import com.example.demo.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PersonResolver(
        @Autowired
        private val service: PersonService
) : GraphQLQueryResolver {

    fun getPeople(count: Int): List<Person> = service.getPeople().take(count)

    fun getPerson(id: Long): Person = service.findPersonById(id).get()
}