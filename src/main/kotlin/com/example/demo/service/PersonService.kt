package com.example.demo.service

import com.example.demo.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService (
        @Autowired
        private val repository: PersonRepository
) {

    fun getPeople() = repository.findAll().toList()

    fun findPersonById(id: Long) = repository.findById(id)
}