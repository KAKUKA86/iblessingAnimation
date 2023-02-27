package com.iblessing.iblessinganimation.dao

import com.iblessing.iblessinganimation.pojo.Article
import com.iblessing.iblessinganimation.pojo.AudiUser
import com.iblessing.iblessinganimation.pojo.User
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import java.sql.Timestamp

@Mapper
interface AuditorUserMapper {
    @Select("select * from a_audi_user where au_username = #{auUsername}")
    fun queryAuditorUserByAuUserName(auUsername: String): AudiUser?

    @Select("select * from n_article where ar_status = 0")
    fun queryAllArticleByStatus(): List<Article>?

    @Update("update n_article set ar_status = #{arStatus} , au_id = #{auId} where ar_id = #{arId}")
    fun updAuditorArticle(arId: Int, auId: Int, arStatus: Int): Int
    @Delete("delete from n_article where ar_id = #{arId}")
    fun delAuditorArticle(arId: Int): Int
    @Select("select * from n_article")
    fun queryAllArticle(): List<Article>?
    @Select("select * from n_user where timestampdiff(day, no_login, #{noLogin}) > 365")
    fun queryUserByTime(noLogin:Timestamp): List<User>?
}