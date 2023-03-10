package com.iblessing.iblessinganimation.service

import com.iblessing.iblessinganimation.pojo.Article
import com.iblessing.iblessinganimation.pojo.Like
import com.iblessing.iblessinganimation.util.NoArticleResult
import com.iblessing.iblessinganimation.util.UtArticleAndCommentResult
import com.iblessing.iblessinganimation.util.UtilResult
import org.springframework.stereotype.Service

@Service
interface UtilService {
    fun showArticleByArId(article: Article): NoArticleResult
    fun showArticleAndCommentByArId(arId: Int): UtArticleAndCommentResult?
    fun showArticleCountByPaId(article: Article): UtilResult?
    fun showLikeCountByNoIdAndArId(like: Like): UtilResult?
    fun addLike(like: Like): UtilResult?
}