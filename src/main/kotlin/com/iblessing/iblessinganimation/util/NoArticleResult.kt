package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Article

class NoArticleResult(
    var statusCode: Int,
    var code: String,
    var message: String,
    var article: Article?,
    var articleList: List<Article>?
) {
}