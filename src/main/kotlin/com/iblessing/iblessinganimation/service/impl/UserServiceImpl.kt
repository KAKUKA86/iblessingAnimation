package com.iblessing.iblessinganimation.service.impl


import com.iblessing.iblessinganimation.dao.UserMapper
import com.iblessing.iblessinganimation.pojo.User
import com.iblessing.iblessinganimation.service.UserService
import com.iblessing.iblessinganimation.util.UserResult
import org.springframework.stereotype.Service
import jakarta.annotation.Resource
import java.sql.Timestamp
import java.time.Instant

@Service
class UserServiceImpl : UserService {
    @Resource
    private var mapper: UserMapper? = null
    override fun normalUserLogin(username: String, password: String): UserResult? {
        println("UserServiceImpl.normalUserLogin")
        println(username + password)
        val user: User? = mapper?.userLogin(username, password)
        println(user)
        return if (user != null) UserResult("success", 200, "登录成功", user, null)
        else UserResult("fail", 400, "登录失败", null, null)

    }

    override fun normalUserRegister(user: User): UserResult? {
        println("UserServiceImpl.normalUserRegister")
        println("11111111111111111")
        val i = mapper?.queryUserByUsername(username = user.username)
        println(i)
        if (i == null) {
            val instant = Instant.now()
            val timestamp = Timestamp.from(instant)
            val inUser = mapper?.addUser(username = user.username, password = user.password, timestamp = timestamp)
                ?: return UserResult(
                    "fail",
                    400,
                    "注册失败",
                    null,
                    null
                )
            return UserResult(
                "success",
                200,
                "注册成功",
                user,
                null,
            )
        } else return UserResult(
            "fail",
            400,
            "注册失败,用户重复",
            null,
            null
        )
    }
}