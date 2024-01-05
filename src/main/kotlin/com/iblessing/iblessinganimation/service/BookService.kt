package com.iblessing.iblessinganimation.service

import com.iblessing.iblessinganimation.util.BookResult
import org.springframework.stereotype.Service

@Service
interface BookService {
    fun showAllBook(): BookResult
    abstract fun searchBookByName(bookName: String): BookResult?
    abstract fun searchBookByAuthor(author: String): BookResult?
}