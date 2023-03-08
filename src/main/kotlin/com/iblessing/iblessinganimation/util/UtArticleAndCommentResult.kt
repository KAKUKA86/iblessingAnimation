package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Article
import com.iblessing.iblessinganimation.pojo.Comment

class UtArticleAndCommentResult(
    var code: Int,
    var StatusCode: String,
    var message: String,
    var article: Article?,
    var commentList: List<Comment>?
)
