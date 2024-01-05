package com.iblessing.iblessinganimation.service


import com.iblessing.iblessinganimation.pojo.User
import com.iblessing.iblessinganimation.util.UserResult
import org.springframework.stereotype.Service

@Service
interface UserService {
    abstract fun normalUserLogin(username: String, password: String): UserResult?
    abstract fun normalUserRegister(user: User): UserResult?

}
