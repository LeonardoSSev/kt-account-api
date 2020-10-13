package com.example.account

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class AccountApplication

fun main(args: Array<String>) {
	runApplication<AccountApplication>(*args)
}
