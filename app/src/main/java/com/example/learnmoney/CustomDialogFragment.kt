package com.example.learnmoney

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.learnmoney.database.AppDatabase
import com.example.learnmoney.database.Transaction
import com.example.learnmoney.database.TransactionDao
import kotlinx.android.synthetic.main.custom_dialog_fragment.*

class CustomDialogFragment : DialogFragment() {

    private lateinit var transactionDao: TransactionDao
    private val args: CustomDialogFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.custom_dialog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transactionDao = AppDatabase.getDatabase(requireContext()).getTransactionDao()
        confirmation_button.setOnClickListener {
            val amount = enter_amount_text_view.text.toString().toLong()
            transactionDao.inserTransaction(Transaction(
                month = 1,
                year = 2019,
                transactionName = "Expense",
                transactionType = args.TransactionType,
                expenseType = TransactionConstant.ExpenseType.FOOD.toString(),
                amount = if(args.TransactionType == TransactionConstant.TransactionType.INCOME.toString()) amount else (amount * -1)
            ))

            this.dismiss()
            findNavController().navigate(R.id.mainFragment)
        }

    }
}