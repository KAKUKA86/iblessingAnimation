package com.iblessing.iblessinganimation.service

import com.iblessing.iblessinganimation.pojo.Article
import com.iblessing.iblessinganimation.util.NoArticleResult
import com.iblessing.iblessinganimation.util.UtArticleAndCommentResult
import org.springframework.stereotype.Service

@Service
interface UtilService {
    fun showArticleByArId(article: Article): NoArticleResult
    fun showArticleAndCommentByArId(arId: Int): UtArticleAndCommentResult?
}