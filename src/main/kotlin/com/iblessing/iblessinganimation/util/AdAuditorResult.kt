package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.AudiUser

class AdAuditorResult(
    var statusCode: Int,
    var code: String,
    var message: String,
    var audiUser: AudiUser?,
    var audiUserList: List<AudiUser>?
)