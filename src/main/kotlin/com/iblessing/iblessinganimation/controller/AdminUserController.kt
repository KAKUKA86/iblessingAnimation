package com.iblessing.iblessinganimation.controller

import com.iblessing.iblessinganimation.pojo.AdminUser
import com.iblessing.iblessinganimation.service.AdminUserService
import com.iblessing.iblessinganimation.util.AdUserResult
import jakarta.annotation.Resource
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/adUser")
class AdminUserController {
    @Resource
    val service: AdminUserService? = null

    /**
     * 管理员登录
     */
    @PostMapping("/login")
    fun adminLogin(@RequestBody adminUser: AdminUser): AdUserResult? {
        val adUsername: String = adminUser.adUsername
        val adUserPassword: String = adminUser.adUserPassword
        return service?.adminUserLogin(adUsername, adUserPassword)
    }



}