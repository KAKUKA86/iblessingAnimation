package com.iblessing.iblessinganimation.controller

import com.iblessing.iblessinganimation.pojo.Collect
import com.iblessing.iblessinganimation.pojo.Loan
import com.iblessing.iblessinganimation.pojo.User
import com.iblessing.iblessinganimation.service.BookService
import com.iblessing.iblessinganimation.util.*
import jakarta.annotation.Resource
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RequestMapping("/book")
class BookController {
    @Resource
    val service: BookService? = null

    @GetMapping("/queAllBook")
    fun showAllBook(): BookResult? {
        return service?.showAllBook()
    }

    @PostMapping("/searchBookByBookName", produces = ["application/json;charset=UTF-8"])
    fun searchBookByName(@RequestBody bookName: String): BookResult? {
        println("main: $bookName")
        return service?.searchBookByName(bookName)
    }

    @PostMapping("/searchBookByAuthor", produces = ["application/json;charset=UTF-8"])
    fun searchBookByAuthor(@RequestBody author: String): BookResult? {
        println("main: $author")
        return service?.searchBookByAuthor(author)
    }

    @PostMapping("/searchAllLoan", produces = ["application/json;charset=UTF-8"])
    fun searchAllLoan(@RequestBody loan: Loan): UserViewLoanResult? {
        val uid = loan.uid
        return service?.searchLoanByUid(uid)
    }

    @PostMapping("/loanBook", produces = ["application/json;charset=UTF-8"])
    fun loanBook(@RequestBody loan: Loan): LoanResult? {
        println("main: $loan")
        //查询是否剩余库存(int)
        val searchLoan = service?.searchBookByBid(loan)
        if (searchLoan == 0 || searchLoan == false) {
            return LoanResult(
                "借阅失败",
                201,
                "库存不足,是否预约",
                null,
                null
            )
        }
        //查询是否在借阅到期时间之后(boolean)
        val valid = service?.validTimeIsAfterLastEndTimeByUidAndBid(loan)
        if (valid != true) {
            return LoanResult(
                "借阅失败",
                400,
                "请勿重复借阅同一本书",
                null,
                null
            )
        }
        return service?.addLoan(loan)
    }

    @PostMapping("/collectBook", produces = ["application/json;charset=UTF-8"])
    fun collectBook(@RequestBody collect: Collect): CollectResult? {
        if (service?.searchCollectByUidAndBid(collect) != null) {
            return CollectResult(
                "收藏失败",
                400,
                "请勿重复收藏同一本书",
                null,
                null
            )
        }
        return service?.addCollect(collect)
    }

    @PostMapping("/returnBook", produces = ["application/json;charset=UTF-8"])
    fun returnBook(@RequestBody loan: Loan): LoanResult? {
        println("main: $loan")
        return service?.returnBook(loan)
    }

    @PostMapping("/showAllCollection", produces = ["application/json;charset=UTF-8"])
    fun showAllCollection(@RequestBody user: User): CollectResult? {
        println("main: $user")
        val uid = user.uid
        return service?.showAllCollection(uid)
    }
    @PostMapping("/showAllSubscribe")
    fun showAllSubscribe(@RequestBody user: User): SubscribeResult?{
        println("main: $user")
        val uid = user.uid
        return service?.showAllSubscribe(uid)
    }
    @PostMapping("/showAllBill")
    fun showAllBill(@RequestBody user: User) : BillResult? {
        println("main: $user")
        val uid = user.uid
        return service?.showAllBill(uid)
    }
}