package com.example.demo.controller

import com.example.demo.entity.Person
import com.example.demo.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PersonController (
        @Autowired
        private val service: PersonService
) {

    @GetMapping("/person")
    fun getPeople(): List<Person> = service.getPeople()

    @GetMapping("person/{userId}")
    fun getJournalById(@PathVariable userId : Long) : ResponseEntity<Person> {
        return service.findPersonById(userId)
                .map { ResponseEntity.ok(it) }
                .orElse(ResponseEntity.notFound().build())
    }

}