package com.example.account.model.entity

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["ispb"])])
data class Bank (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = false)
    val ispb: String,

    @Column(nullable = false)
    val name: String
)