package com.iblessing.iblessinganimation.service.impl

import com.iblessing.iblessinganimation.dao.UtilMapper
import com.iblessing.iblessinganimation.pojo.Article
import com.iblessing.iblessinganimation.pojo.Like
import com.iblessing.iblessinganimation.service.UtilService
import com.iblessing.iblessinganimation.util.NoArticleResult
import com.iblessing.iblessinganimation.util.UtArticleAndCommentResult
import com.iblessing.iblessinganimation.util.UtilResult
import jakarta.annotation.Resource
import org.springframework.stereotype.Service

@Service
class UtilServiceImpl : UtilService {
    @Resource
    val mapper: UtilMapper? = null

    override fun showArticleByArId(article: Article): NoArticleResult {
        return if (mapper?.showArticleByArId(article.arId) != null) {
            NoArticleResult(200, "OK", "查询成功", mapper?.showArticleByArId(article.arId), null)
        } else {
            NoArticleResult(404, "Not Found", "查询失败", null, null)
        }
    }

    override fun showArticleAndCommentByArId(arId: Int): UtArticleAndCommentResult? {
        mapper?.showArticleByArId(arId)?.let {
            return UtArticleAndCommentResult(200, "OK", "查询成功", it, mapper?.showCommentByArId(arId))
        }
        return UtArticleAndCommentResult(404, "Not Found", "查询失败", null, null)
    }

    override fun showArticleCountByPaId(article: Article): UtilResult? {
        return if (mapper?.showArticleCountByPaId(article.paId) != null) {
            UtilResult(200, "OK", "查询成功", mapper?.showArticleCountByPaId(article.paId),null)
        } else {
            UtilResult(404, "Not Found", "查询失败", null,null)
        }
    }

    override fun showLikeCountByNoIdAndArId(like: Like): UtilResult? {
        return if (mapper?.showLikeCountByNoIdAndArId(like) != null) {
            UtilResult(200, "OK", "查询有值", null,mapper?.showLikeCountByNoIdAndArId(like))
        } else {
            UtilResult(200, "OK", "查询空",null ,null)
        }
    }

    override fun addLike(like: Like): UtilResult? {
        return if (mapper?.addLike(like.arId,like.noId) != null) {
            UtilResult(200, "OK", "新增成功", null,null)
        } else {
            UtilResult(404, "Not Found", "新增失败",null ,null)
        }
    }
}