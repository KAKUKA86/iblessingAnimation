package com.iblessing.iblessinganimation.controller

import com.iblessing.iblessinganimation.pojo.User
import com.iblessing.iblessinganimation.service.NormalUserService
import com.iblessing.iblessinganimation.util.NoUserResult
import jakarta.annotation.Resource
import org.springframework.web.bind.annotation.CrossOrigin

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class NormalUserController {
    @Resource
    val service: NormalUserService? = null

    /**
     * 普通用户登录
     */
    @PostMapping("/login")
    fun userLogin(@RequestBody user: User): NoUserResult? {
        val noUsername: String = user.noUsername
        val noUserPassword: String = user.noUserPassword
        return service?.normalUserLogin(noUsername, noUserPassword)
    }

    /**
     * 测试接口
     */
    @RequestMapping("/")
    fun hello(): String {
        return "hello world"
    }
}