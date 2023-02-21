package com.iblessing.iblessinganimation.service

import com.iblessing.iblessinganimation.util.AdUserResult
import org.springframework.stereotype.Service

@Service
interface AdminUserService {
    fun adminUserLogin(adUsername: String, adUserPassword: String): AdUserResult?
}
