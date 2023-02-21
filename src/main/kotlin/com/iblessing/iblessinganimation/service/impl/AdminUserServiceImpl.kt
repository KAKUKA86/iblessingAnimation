package com.iblessing.iblessinganimation.service.impl

import com.iblessing.iblessinganimation.dao.AdminUserMapper
import com.iblessing.iblessinganimation.pojo.AdminUser
import com.iblessing.iblessinganimation.service.AdminUserService
import com.iblessing.iblessinganimation.util.AdUserResult
import jakarta.annotation.Resource
import org.springframework.stereotype.Service
import java.util.*

@Service
class AdminUserServiceImpl : AdminUserService {
    @Resource
    private var mapper: AdminUserMapper? = null
    override fun adminUserLogin(adUsername: String, adUserPassword: String): AdUserResult? {
        println("service处 $adUsername")
        val adminUser: AdminUser? = mapper?.queryAdminUserByAdUserName(adUsername)
        println("service出库 ${adminUser?.adUsername}")
        return if (Objects.isNull(adminUser)) {
            println("该用户不存在")
            AdUserResult(400, "002", "用户不存在", null)
        } else {
            println("用户存在条件")
            if (Objects.equals(adminUser?.adUsername, adUserPassword)) {
                println(adminUser?.adUsername + "登陆成功，写入登录时间")
                AdUserResult(200, "001", "登录成功", adminUser)
            } else {
                println("该用户存在但密码错误")
                AdUserResult(100, "002", "密码错误", null)
            }
        }
    }
}