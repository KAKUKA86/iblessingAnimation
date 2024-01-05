package com.iblessing.iblessinganimation.controller

import com.iblessing.iblessinganimation.pojo.Book
import com.iblessing.iblessinganimation.service.BookService
import com.iblessing.iblessinganimation.util.BookResult
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

}