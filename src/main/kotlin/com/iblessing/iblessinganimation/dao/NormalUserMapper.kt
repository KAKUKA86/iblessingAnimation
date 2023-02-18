package com.iblessing.iblessinganimation.dao

import com.iblessing.iblessinganimation.pojo.User
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
    fun queryNorUserFavByNoIdAndArId(noId: Int, arId: Int)

    @Insert(
        "insert into n_favorites (no_id , ar_id , fa_time) values = (#{noId} , #{arId} , #{faTime})"
    )
    fun addNorUserFav(noId: Int, arId: Int, faTime: Timestamp)
}
