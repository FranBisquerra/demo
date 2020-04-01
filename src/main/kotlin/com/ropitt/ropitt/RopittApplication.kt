package com.ropitt.ropitt

import com.ropitt.ropitt.entity.Person
import com.ropitt.ropitt.repository.PersonRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class RopittApplication {

	@Bean
	fun init(repository: PersonRepository) = CommandLineRunner {
		repository.save(Person("Lluc"))
		repository.save(Person("Francesc"))
		repository.save(Person("Marta"))
		repository.save(Person("Pepe"))

		repository.findAll().forEach { println(it.toString()) }
	}

}

fun main(args: Array<String>) {
	runApplication<RopittApplication>(*args)
}
