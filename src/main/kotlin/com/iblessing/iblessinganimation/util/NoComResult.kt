package com.iblessing.iblessinganimation.util
import com.iblessing.iblessinganimation.pojo.Comment
class NoComResult(
    var code: Int,
    var statusCode: String,
    var message: String,
    var comment: Comment?,
    var commentList: List<Comment>?
) {
}