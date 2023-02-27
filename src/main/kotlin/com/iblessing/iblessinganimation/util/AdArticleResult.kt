package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Article

class AdArticleResult (
    var statusCode : Int,
    var code : String,
    var message : String,
    var article: Article?,
    var articles: List<Article>?
        )