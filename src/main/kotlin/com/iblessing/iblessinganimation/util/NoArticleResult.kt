package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Article

class NoArticleResult(
    var code: Int,
    var StatusCode: String,
    var message: String,
    var article: Article?,
    var articleList: List<Article>?
)