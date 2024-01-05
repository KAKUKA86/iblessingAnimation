package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Book

class BookResult(
    var code: String,
    var statusCode: Int,
    var message: String,
    var book: Book?,
    var bookList: List<Book>?,
)