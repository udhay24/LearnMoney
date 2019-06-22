package com.example.learnmoney.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Transaction::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun getTransactionDao(): TransactionDao

    companion object {

        private lateinit var INSTANCE: AppDatabase

        fun getDatabase(context: Context) : AppDatabase {
            return if (::INSTANCE.isInitialized) {
                INSTANCE
            } else {
                INSTANCE = Room.databaseBuilder(
                    context, AppDatabase::class.java, "transaction.db"
                )
                    .allowMainThreadQueries()
                    .build()
                INSTANCE
            }
        }
    }
}