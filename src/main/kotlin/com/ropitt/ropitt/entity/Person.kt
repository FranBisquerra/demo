package com.example.demo.entity

import javax.persistence.*

@Entity
data class Person (
    @Column(nullable = false)
    val name: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id = 0L
}