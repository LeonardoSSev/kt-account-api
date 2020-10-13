package com.example.account.model.entity

import java.time.LocalDateTime
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
data class User (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    val creationDate: LocalDateTime

)
