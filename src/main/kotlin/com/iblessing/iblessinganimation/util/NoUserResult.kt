package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.User


class NoUserResult(
    var statusCode: Int,
    var code: String,
    var message: String,
    var user: User?
) {
    override fun toString(): String {
        return "NoUserResult(statusCode=$statusCode, code='$code', message='$message', user=$user)"
    }


}
