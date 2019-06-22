package com.example.learnmoney

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.learnmoney.database.AppDatabase
import com.example.learnmoney.database.Transaction
import com.example.learnmoney.database.TransactionDao
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.content_main.*

class MainFragment : Fragment() {

    private lateinit var transactionDao: TransactionDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fab: FloatingActionButton = view.findViewById(R.id.fab)
        fab.setOnClickListener {
            findNavController().navigate(R.id.expensesFragment)
        }
        transactionDao = AppDatabase.getDatabase(requireContext())
            .getTransactionDao()

        transactionDao.getAllTransactions().observe(this, Observer {
            income_text_view.text = "${calculateIncome(it)}"
            expenses_text_view.text = "${calculateExpense(it)}"
            balance_text_view.text = "${calculateBalance(it)}"

        })
    }

    private fun calculateIncome(transactions: List<Transaction>): Long{
        var income: Long = 0
        transactions.forEach {
            if(it.transactionType == TransactionConstant.TransactionType.INCOME.toString()) {
                income += it.amount
            }
        }
        return income
    }

    private fun calculateExpense(transactions: List<Transaction>): Long {
        var expense: Long = 0
        transactions.forEach {
            if(it.transactionType == TransactionConstant.TransactionType.EXPENSE.toString()) {
                expense += it.amount
            }
        }
        return expense
    }

    private fun calculateBalance(transactions: List<Transaction>) : Long {
        var balance: Long = 0
        transactions.forEach {
            balance += it.amount
        }
        return balance
    }
}
