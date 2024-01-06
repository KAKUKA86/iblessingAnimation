package com.iblessing.iblessinganimation.dao

import com.iblessing.iblessinganimation.pojo.*
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper
interface BookMapper {
    @Select("select * from book_main_management.book ")
    abstract fun queryAllBooks(): List<Book>

    @Select("select * from book_main_management.book where name like concat('%',\${name},'%')")
    abstract fun queryBooksByBookName(name: String): List<Book>?

    @Select("select * from book_main_management.book where author like concat('%',\${author},'%')")
    abstract fun queryBooksByBookAuthor(author: String): List<Book>?

    //通过uid和bid查询借书记录，返回数据库中status为'借阅中'的记录
    @Select(
        "select * from book_main_management.loanlist where uid = #{uid} and bid = #{bid} and status = '借阅中'"
    )
    abstract fun searchLoanStatusByUidAndBid(loan: Loan): Any?

    @Insert(
        "insert into book_main_management.loanlist (bid, uid, starttime, endtime) " +
                "values (#{bid}, #{uid}, #{starttime}, #{endtime})"
    )
    abstract fun addLoan(loan: Loan): Int?

    @Select(
        "select num from book_main_management.book where bid = #{bid}"
    )
    abstract fun searchBookNumByBid(loan: Loan): Any

    @Select(
        "select * from book_main_management.collect where uid = #{uid} and bid = #{bid}"
    )
    abstract fun searchCollectByUidAndBid(collect: Collect): Any?

    @Insert(
        "insert into book_main_management.collect (bid, uid, time) " +
                "values (#{bid}, #{uid}, #{time})"
    )
    abstract fun addCollect(collect: Collect): Int?

    //通过loanlist.bid查询book.name,通过loanlist.bid和uid查询结果
    @Select(
        "select loanlist.id, book.name, loanlist.starttime, loanlist.endtime, loanlist.status " +
                "from book_main_management.loanlist, book_main_management.book " +
                "where loanlist.bid = book.bid and loanlist.uid = #{uid}"
    )
    abstract fun searchLoanByUid(uid: Int): List<UserViewLoan>?

    @Update(
        "update book_main_management.loanlist set status = '已归还' where id = #{id}"
    )
    abstract fun alterLoanStatus(loan: Loan): Int?

    //多表查询，通过uid查询收藏表和书本表，返回收藏表和书本表的交集
    @Select(
        "select book.name,book.author,book.publishing, collect.time " +
                "from book_main_management.collect, book_main_management.book " +
                "where collect.bid = book.bid and collect.uid = #{uid}"
    )
    abstract fun searchCollectByUid(uid: Int): List<Collect>?

    @Select(
        "select  book_main_management.book.name,book_main_management.book.author,book_main_management.book.publishing," +
                "book_main_management.subscribe.time " +
                "from book_main_management.book, book_main_management.subscribe " +
                "where book_main_management.subscribe.bid = book.bid and book_main_management.subscribe.uid = #{uid}"
    )
    fun searchSubscribe(uid: Int): List<Subscribe>?
    @Select(
        "select book_main_management.book.name,book_main_management.book.author," +
                "book_main_management.book.publishing,book_main_management.book.price," +
                "book_main_management.bill.time, book_main_management.bill.comment " +
                "from book_main_management.book, book_main_management.bill " +
                "where  book_main_management.bill.bid = book.bid and book_main_management.bill.uid = #{uid}"
    )
    abstract fun searchBill(uid: Int): List<Bill>?
}