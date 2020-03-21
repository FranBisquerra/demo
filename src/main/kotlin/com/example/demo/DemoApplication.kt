package com.example.demo

import com.example.demo.entity.Person
import com.example.demo.repository.PersonRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.function.Consumer

@SpringBootApplication
class DemoApplication {

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
	runApplication<DemoApplication>(*args)
}
