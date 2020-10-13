package com.example.account.model.entity

import javax.persistence.*

@Entity
data class BankAccount (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id", nullable = false)
    val Bank: Bank,

    @Column(nullable = false)
    val type: String,

    @Column(nullable = false)
    val number: Long,

    @Column(nullable = false, precision = 2)
    val balance: Long = 0
)