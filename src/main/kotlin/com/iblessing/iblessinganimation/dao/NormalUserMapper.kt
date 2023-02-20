package com.iblessing.iblessinganimation.dao

import com.iblessing.iblessinganimation.pojo.Article
import com.iblessing.iblessinganimation.pojo.Comment
import com.iblessing.iblessinganimation.pojo.Favorites
import com.iblessing.iblessinganimation.pojo.User
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import java.sql.Timestamp

@Mapper
interface NormalUserMapper {
    @Select("select * from n_user where no_username = #{noUsername}")
    fun queryNormalUserByUserName(noUsername: String): User

    @Insert(
        "insert into n_user(no_username, no_user_password, no_gender, no_birthday, no_sign_in, no_email) " +
                "values (#{noUsername}, #{noUserPassword}, #{noGender}, #{noBirthday}, #{noSignIn}, #{noEmail})"
    )
    fun insertNormalUser(
        noUsername: String,
        noUserPassword: String,
        noGender: String,
        noBirthday: String,
        noSignIn: Timestamp,
        noEmail: String
    )

    @Update(
        "update n_user set no_login = #{noLogin} where no_username = #{noUsername}"
    )
    fun updateNormalUserLoginTime(noUsername: String, noLogin: Timestamp)

    @Select(
        "select * from n_favorites where no_id = #{noId} and ar_id = #{arId}"
    )
    fun queryNorUserFavByNoIdAndArId(noId: Int, arId: Int): Favorites

    @Insert(
        "insert into n_favorites (no_id , ar_id , fa_time) values (#{noId} , #{arId} , #{faTime})"
    )
    fun addNorUserFav(noId: Int, arId: Int, faTime: Timestamp)

    @Select(
        "select * from n_favorites where no_id = #{noId}"
    )
    fun queryNorUserFavByNoId(noId: Int): List<Favorites>

    @Insert(
        "insert into n_article (no_id , ar_title , ar_content , ar_time) " +
                "values (#{noId} , #{arTitle}, #{arContent} , #{arTime})"
    )
    fun addArticle(noId: Int, arTitle: String, arContent: String, arTime: Timestamp): Int

    @Delete(
        "delete from n_article where no_id = #{noId} and ar_id = #{arId}"
    )
    fun delArticle(noId: Int, arId: Int): Int

    @Select(
        "select * from n_article where no_id = #{noId}"
    )
    fun queryArticleByNoId(noId: Int): List<Article>

    @Update(
        "update n_article " +
                " set ar_title = #{arTitle} , ar_content = #{arContent} , ar_status = #{arStatus} , ar_time = #{arTime} " +
                " where no_id = #{noId} and ar_id = #{arId}"
    )
    fun updateArticle(noId: Int, arId: Int, arTitle: String, arContent: String, arStatus: Int, arTime: Timestamp): Int


    @Insert(
        "insert into n_comment (no_id , ar_id , co_content , co_time ) " +
                " values ( #{noId} , #{arId} , #{coContent} , #{coTime} )"

    )
    fun addComment(noId: Int, arId: Int, coContent: String, coTime: Timestamp): Int

    @Delete(
        "delete from n_comment where no_id = #{noId} and ar_id = #{arId}"
    )
    fun delComment(noId: Int, arId: Int): Int
    @Update(
        "update n_comment " +
                "set co_content = #{coContent} , co_time = #{coTime} " +
                "where no_id = #{noId} and ar_id = #{arId}"
    )
    fun updateComment(noId: Int, arId: Int, coContent: String, coTime: Timestamp): Int
    @Select(
        "select * from n_comment where no_id = #{noId}"
    )
    fun queryCommentByNoId(noId: Int): List<Comment>
}
