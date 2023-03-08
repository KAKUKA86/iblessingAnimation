package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.AudiUser

class AdAuditorResult(
    var code: Int,
    var statusCode: String,
    var message: String,
    var audiUser: AudiUser?,
    var audiUserList: List<AudiUser>?
)