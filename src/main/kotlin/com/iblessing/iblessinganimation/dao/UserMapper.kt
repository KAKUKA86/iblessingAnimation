package com.iblessing.iblessinganimation.dao


import com.iblessing.iblessinganimation.pojo.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import java.sql.Timestamp

@Mapper
interface UserMapper {
    @Select("select * from user where username = #{username} and password = #{password}")
    abstract fun userLogin(username: String, password: String): User?
    @Select("select * from user where username = #{username}")
    abstract fun queryUserByUsername(username: String): Int?
    @Insert("insert into user values (null,#{username},#{password},null,#{timestamp},null)")
    abstract fun addUser(username: String,password: String,timestamp: Timestamp): Int?

}
