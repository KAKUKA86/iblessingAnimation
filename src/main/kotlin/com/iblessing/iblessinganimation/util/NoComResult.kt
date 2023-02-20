package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Comment


class NoComResult(
    var statusCode: Int,
    var code: String,
    var message: String,
    var comment: Comment?,
    var commentList: List<Comment>?
) {
    override fun toString(): String {
        return super.toString()
    }
}