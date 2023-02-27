package com.iblessing.iblessinganimation.service

import com.iblessing.iblessinganimation.pojo.Article
import com.iblessing.iblessinganimation.pojo.AudiUser
import com.iblessing.iblessinganimation.pojo.User
import com.iblessing.iblessinganimation.util.AuUserResult
import com.iblessing.iblessinganimation.util.NoArticleResult
import com.iblessing.iblessinganimation.util.NoUserResult
import org.springframework.stereotype.Service

@Service
interface AuditorUserService {
    fun auditorUserLogin(audiUser: AudiUser): AuUserResult?
    fun queAudiArticle(article: Article): NoArticleResult?
    fun updAudiArticle(article: Article): NoArticleResult?
    fun delAudiArticle(article: Article): NoArticleResult?
    fun queArticle(article: Article): NoArticleResult?
    fun queUserByTime(): NoUserResult?

}