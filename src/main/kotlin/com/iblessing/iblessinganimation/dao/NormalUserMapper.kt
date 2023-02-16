package com.iblessing.iblessinganimation.dao

import com.iblessing.iblessinganimation.pojo.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface NormalUserMapper {
    @Select("select * from n_user where no_username = #{noUsername}")
    fun queryNormalUserByUserName(noUsername: String): User
}