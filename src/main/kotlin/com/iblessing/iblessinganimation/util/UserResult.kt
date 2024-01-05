package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.User

class UserResult(
    var code: String,
    var statusCode: Int,
    var message: String,
    var user: User?,
    var userList: List<User>?,
)