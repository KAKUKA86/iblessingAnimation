package com.iblessing.iblessinganimation.controller


import com.iblessing.iblessinganimation.pojo.User
import com.iblessing.iblessinganimation.service.UserService
import com.iblessing.iblessinganimation.util.UserResult
import jakarta.annotation.Resource
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RequestMapping("/userSystem")
class UserSystemController {
    @Resource
    val service: UserService? = null
    @PostMapping("/login")
    fun userLogin(@RequestBody user: User): UserResult? {
        val username: String = user.username
        val password: String = user.password
        return service?.normalUserLogin(username, password)
    }
    @PostMapping("/registration")
    fun userRegister(@RequestBody user:User): UserResult? {
        return service?.normalUserRegister(user)
    }
}