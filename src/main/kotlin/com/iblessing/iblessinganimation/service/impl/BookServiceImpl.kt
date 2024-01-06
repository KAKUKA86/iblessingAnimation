package com.iblessing.iblessinganimation.service.impl

import com.iblessing.iblessinganimation.dao.BookMapper
import com.iblessing.iblessinganimation.pojo.Book
import com.iblessing.iblessinganimation.pojo.Collect
import com.iblessing.iblessinganimation.pojo.Loan
import com.iblessing.iblessinganimation.pojo.UserViewLoan
import com.iblessing.iblessinganimation.service.BookService
import com.iblessing.iblessinganimation.util.*
import jakarta.annotation.Resource
import org.springframework.stereotype.Service


@Service
class BookServiceImpl : BookService {
    @Resource
    private val mapper: BookMapper? = null
    override fun showAllBook(): BookResult {
        println("BookServiceImpl.showAllBook")
        val list: List<Book> = mapper?.queryAllBooks() ?: return BookResult(
            "查询失败",
            400,
            "数据库为空，找不到书本数据",
            null,
            null
        )
        return BookResult(
            "查询成功",
            200,
            "查询成功",
            null,
            list
        )
    }

    override fun searchBookByName(bookName: String): BookResult? {
        println("BookServiceImpl.searchBookByName")
        val list: List<Book> = mapper?.queryBooksByBookName(bookName) ?: return BookResult(
            "查询失败",
            400,
            "数据库为空，找不到书本数据",
            null,
            null
        )
        return BookResult(
            "查询成功",
            200,
            "查询成功",
            null,
            list
        )
    }

    override fun searchBookByAuthor(author: String): BookResult? {
        println("BookServiceImpl.searchBookByAuthor")
        val list: List<Book> = mapper?.queryBooksByBookAuthor(author) ?: return BookResult(
            "查询失败",
            400,
            "数据库为空，找不到书本数据",
            null,
            null
        )
        return BookResult(
            "查询成功",
            200,
            "查询成功",
            null,
            list
        )
    }

    override fun searchBookByBid(loan: Loan): Any {
        println("BookServiceImpl.searchBookNumByBid")
        return mapper?.searchBookNumByBid(loan) ?: return false
    }

    override fun validTimeIsAfterLastEndTimeByUidAndBid(loan: Loan): Any {
        println("BookServiceImpl.searchTimeIsAfterLastEndTimeByUidAndBid")
        return mapper?.searchLoanStatusByUidAndBid(loan) ?: return true
    }

    override fun searchLoanByUidAndBid(loan: Loan): Any {
        TODO("Not yet implemented")
    }

    override fun addLoan(loan: Loan): LoanResult? {
        println("BookServiceImpl.addLoan")
        mapper?.addLoan(loan) ?: return LoanResult(
            "借阅失败",
            400,
            "数据库为空，找不到书本数据",
            null,
            null
        )
        return LoanResult(
            "借阅成功",
            200,
            "借阅成功",
            null,
            null
        )
    }

    override fun searchCollectByUidAndBid(collect: Collect): Any? {
        println("BookServiceImpl.searchCollectByUidAndBid")
        return mapper?.searchCollectByUidAndBid(collect)

    }

    override fun addCollect(collect: Collect): CollectResult? {
        println("BookServiceImpl.addCollect")
        mapper?.addCollect(collect) ?: return CollectResult(
            "收藏失败",
            400,
            "收藏失败",
            null,
            null
        )
        return CollectResult(
            "收藏成功",
            200,
            "收藏成功",
            null,
            null
        )
    }

    override fun searchLoanByUid(uid: Int): UserViewLoanResult? {
        println("BookServiceImpl.searchLoanByUid")
        val list: List<UserViewLoan> = mapper?.searchLoanByUid(uid) ?: return UserViewLoanResult(
            "查询失败",
            400,
            "查询失败",
            null

        )
        return UserViewLoanResult(
            "查询成功",
            200,
            "查询成功",
            list
        )
    }

    override fun returnBook(loan: Loan): LoanResult? {
        println("BookServiceImpl.returnBook")
        mapper?.alterLoanStatus(loan) ?: return LoanResult(
            "归还失败",
            400,
            "归还失败",
            null,
            null
        )
        return LoanResult(
            "归还成功",
            200,
            "归还成功",
            null,
            null
        )
    }

    override fun showAllCollection(uid: Int): CollectResult {
        println("BookServiceImpl.showAllCollection")
        val resultList = mapper?.searchCollectByUid(uid)
        if (resultList != null)
            return CollectResult(
                "查询成功",
                200,
                "查询成功",
                null,
                resultList
            )
        return CollectResult(
            "查询失败",
            400,
            "查询失败",
            null,
            null
        )
    }

    override fun showAllSubscribe(uid: Int): SubscribeResult? {
        println("BookServiceImpl.showAllSubscribe")
        val resultList = mapper?.searchSubscribe(uid)
        if (resultList != null)
            return SubscribeResult(
                "查询成功",
                200,
                "查询成功",
                resultList
            )
        return SubscribeResult(
            "查询失败",
            400,
            "查询失败",
            null
        )
    }

    override fun showAllBill(uid: Int): BillResult? {
        println("BookServiceImpl.showAllBill")
        val resultList = mapper?.searchBill(uid)
        if (resultList != null)
            return BillResult(
                "查询成功",
                200,
                "查询成功",
                resultList
            )
        return BillResult(
            "查询失败",
            400,
            "查询失败",
            null
        )
    }
}