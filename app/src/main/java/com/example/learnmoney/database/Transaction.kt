package com.example.learnmoney.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Year

@Entity
data class Transaction(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "month") val month: Int,
    @ColumnInfo(name = "year") val year: Int,
    @ColumnInfo(name = "transaction_name") val transactionName: String,
    @ColumnInfo(name = "transaction_type") val transactionType: String,
    @ColumnInfo(name = "expense_type") val expenseType: String,
    @ColumnInfo(name = "income_type") val incomeType: String,
    @ColumnInfo(name = "amount") val amount: Long
)