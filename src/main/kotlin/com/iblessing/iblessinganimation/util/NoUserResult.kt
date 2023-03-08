package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.User


class NoUserResult(
    var code: Int,
    var statusCode: String,
    var message: String,
    var user: User?,
    var userList: List<User>?
)
