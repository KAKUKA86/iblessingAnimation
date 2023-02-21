package com.iblessing.iblessinganimation.dao

import com.iblessing.iblessinganimation.pojo.AdminUser
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface AdminUserMapper {
    @Select("Select * from a_admin_user where ad_username = #{adUsername}")
    fun queryAdminUserByAdUserName(adUsername: String): AdminUser?

}
