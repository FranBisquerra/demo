package com.example.demo.controller

import com.example.demo.entity.Person
import com.example.demo.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PersonController (
        @Autowired
        private val repository: PersonRepository
) {

    @GetMapping("/person")
    fun getUsers(): List<Person> = listOf(Person("pepe"))

    @GetMapping("person/{userId}")
    fun getJournalById(@PathVariable userId : Long) : ResponseEntity<Person> {
        return repository.findById(userId)
                .map { ResponseEntity.ok(it) }
                .orElse(ResponseEntity.notFound().build())
    }

}