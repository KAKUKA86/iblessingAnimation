package com.iblessing.iblessinganimation.service.impl

import com.iblessing.iblessinganimation.dao.AuditorUserMapper
import com.iblessing.iblessinganimation.pojo.AudiUser
import com.iblessing.iblessinganimation.service.AuditorUserService
import com.iblessing.iblessinganimation.util.AuUserResult
import jakarta.annotation.Resource
import org.springframework.stereotype.Service
import java.util.Objects

@Service
class AuditorUserServiceImpl : AuditorUserService {
    @Resource
    private var mapper: AuditorUserMapper? = null
    override fun auditorUserLogin(audiUser: AudiUser): AuUserResult? {
        return if (Objects.isNull(mapper?.queryAuditorUserByAuUserName(audiUser.auUsername))) {
            AuUserResult(400, "002", "用户不存在", null, null)
        } else {
            if (Objects.equals(mapper?.queryAuditorUserByAuUserName(audiUser.auUsername)?.auUserPassword, audiUser.auUserPassword)) {
                AuUserResult(200, "001", "登录成功", mapper?.queryAuditorUserByAuUserName(audiUser.auUsername), null)
            } else {
                AuUserResult(100, "002", "密码错误", null, null)
            }
        }
    }

    override fun checkArticle(audiUser: AudiUser): AuUserResult? {
        TODO("Not yet implemented")
    }

}