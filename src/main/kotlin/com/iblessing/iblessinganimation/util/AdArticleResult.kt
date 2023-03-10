package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Article

class AdArticleResult(
    var code: Int,
    var statusCode: String,
    var message: String,
    var article: Article?,
    var articles: List<Article>?
)