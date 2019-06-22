package com.example.learnmoney.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TransactionDao {

    @Query("SELECT * FROM `Transaction`")
    fun getAllTransactions(): LiveData<List<Transaction>>

    @Insert
    fun inserTransaction(transaction: Transaction)
}