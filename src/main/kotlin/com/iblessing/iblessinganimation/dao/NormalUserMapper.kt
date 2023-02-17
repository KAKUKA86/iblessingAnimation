package com.iblessing.iblessinganimation.dao

import com.iblessing.iblessinganimation.pojo.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
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
}
