package com.ropitt.ropitt.service

import com.ropitt.ropitt.entity.Person
import com.ropitt.ropitt.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService (
        @Autowired
        private val repository: PersonRepository
) {

    fun getPeople() = repository.findAll().toList()

    fun findPersonById(id: Long) = repository.findById(id)

    fun createPerson(name: String) = repository.save(Person(name))
}