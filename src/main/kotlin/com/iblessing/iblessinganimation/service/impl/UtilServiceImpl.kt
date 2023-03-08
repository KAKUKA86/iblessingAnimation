package com.iblessing.iblessinganimation.service.impl

import com.iblessing.iblessinganimation.dao.UtilMapper
import com.iblessing.iblessinganimation.pojo.Article
import com.iblessing.iblessinganimation.service.UtilService
import com.iblessing.iblessinganimation.util.NoArticleResult
import com.iblessing.iblessinganimation.util.UtArticleAndCommentResult
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
}