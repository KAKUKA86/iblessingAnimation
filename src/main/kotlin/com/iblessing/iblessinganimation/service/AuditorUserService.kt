package com.iblessing.iblessinganimation.service

import com.iblessing.iblessinganimation.pojo.AudiUser
import com.iblessing.iblessinganimation.util.AuUserResult
import org.springframework.stereotype.Service

@Service
interface AuditorUserService {
    fun auditorUserLogin(audiUser: AudiUser): AuUserResult?
    fun checkArticle(audiUser: AudiUser): AuUserResult?

}