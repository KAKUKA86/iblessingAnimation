package com.iblessing.iblessinganimation.service

import com.iblessing.iblessinganimation.pojo.Collect
import com.iblessing.iblessinganimation.pojo.Loan
import com.iblessing.iblessinganimation.util.*
import org.springframework.stereotype.Service

@Service
interface BookService {
    fun showAllBook(): BookResult
    abstract fun searchBookByName(bookName: String): BookResult?
    abstract fun searchBookByAuthor(author: String): BookResult?
    abstract fun searchBookByBid(loan: Loan): Any
    abstract fun validTimeIsAfterLastEndTimeByUidAndBid(loan: Loan): Any
    abstract fun searchLoanByUidAndBid(loan: Loan): Any
    abstract fun addLoan(loan: Loan): LoanResult?
    abstract fun searchCollectByUidAndBid(collect: Collect): Any?
    abstract fun addCollect(collect: Collect): CollectResult?
    fun searchLoanByUid(uid : Int): UserViewLoanResult?
    abstract fun returnBook(loan: Loan): LoanResult?
    abstract fun showAllCollection(uid: Int): CollectResult
    abstract fun showAllSubscribe(uid: Int): SubscribeResult?
    abstract fun showAllBill(uid: Int): BillResult?

}