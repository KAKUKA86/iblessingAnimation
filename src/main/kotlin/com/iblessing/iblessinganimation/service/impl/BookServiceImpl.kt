package com.iblessing.iblessinganimation.service.impl

import com.iblessing.iblessinganimation.dao.BookMapper
import com.iblessing.iblessinganimation.pojo.Book
import com.iblessing.iblessinganimation.service.BookService
import com.iblessing.iblessinganimation.util.BookResult
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
}