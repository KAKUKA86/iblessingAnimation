package com.iblessing.iblessinganimation.dao

import com.iblessing.iblessinganimation.pojo.Book
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface BookMapper {
    @Select("select * from book_main_management.book ")
    abstract fun queryAllBooks(): List<Book>
    @Select("select * from book_main_management.book where name like concat('%',\${name},'%')")
    abstract fun queryBooksByBookName(name: String): List<Book>?
    @Select("select * from book_main_management.book where author like concat('%',\${author},'%')")
    abstract fun queryBooksByBookAuthor(author: String): List<Book>?
}