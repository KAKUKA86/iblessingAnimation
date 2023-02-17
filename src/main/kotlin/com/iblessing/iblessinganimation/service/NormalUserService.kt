package com.iblessing.iblessinganimation.service

import com.iblessing.iblessinganimation.pojo.User
import com.iblessing.iblessinganimation.util.NoUserResult
import org.springframework.stereotype.Service

@Service
interface NormalUserService {
    fun normalUserLogin(noUsername: String, noUserPassword: String): NoUserResult
    fun normalUserSignIn(user : User): NoUserResult
}