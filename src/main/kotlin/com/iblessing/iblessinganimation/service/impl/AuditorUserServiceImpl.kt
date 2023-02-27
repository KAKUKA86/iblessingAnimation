package com.iblessing.iblessinganimation.service.impl

import com.iblessing.iblessinganimation.dao.AuditorUserMapper
import com.iblessing.iblessinganimation.pojo.Article
import com.iblessing.iblessinganimation.pojo.AudiUser
import com.iblessing.iblessinganimation.service.AuditorUserService
import com.iblessing.iblessinganimation.util.AuUserResult
import com.iblessing.iblessinganimation.util.NoArticleResult
import com.iblessing.iblessinganimation.util.NoUserResult
import jakarta.annotation.Resource
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.util.*

@Service
class AuditorUserServiceImpl : AuditorUserService {
    @Resource
    private var mapper: AuditorUserMapper? = null
    override fun auditorUserLogin(audiUser: AudiUser): AuUserResult? {
        return if (Objects.isNull(mapper?.queryAuditorUserByAuUserName(audiUser.auUsername))) {
            AuUserResult(400, "002", "用户不存在", null, null)
        } else {
            if (Objects.equals(
                    mapper?.queryAuditorUserByAuUserName(audiUser.auUsername)?.auUserPassword,
                    audiUser.auUserPassword
                )
            ) {
                AuUserResult(200, "001", "登录成功", mapper?.queryAuditorUserByAuUserName(audiUser.auUsername), null)
            } else {
                AuUserResult(100, "002", "密码错误", null, null)
            }
        }
    }

    /**
     * 审核普通用户的文章
     * 审核已知用户文章表并操作用户文章表
     */
    override fun queAudiArticle(article: Article): NoArticleResult? {
        val articleList: List<Article>? = mapper?.queryAllArticleByStatus()
        return if (Objects.isNull(articleList)) {
            NoArticleResult(400, "002", "暂无文章", null, null)
        } else {
            NoArticleResult(200, "001", "查询成功", null, articleList)
        }
    }

    override fun updAudiArticle(article: Article): NoArticleResult? {
        val arId = article.arId
        val auId = article.auId
        val arStatus = article.arStatus
        return if (mapper?.updAuditorArticle(arId, auId, arStatus) == 1) {
            NoArticleResult(200, "001", "审核成功", article, null)
        } else {
            NoArticleResult(400, "002", "审核失败", null, null)
        }
    }

    override fun delAudiArticle(article: Article): NoArticleResult? {
        val arId = article.arId
        return if (mapper?.delAuditorArticle(arId) == 1) {
            NoArticleResult(200, "001", "删除成功", article, null)
        } else {
            NoArticleResult(400, "002", "删除失败", null, null)
        }
    }

    override fun queArticle(article: Article): NoArticleResult? {
        return if (Objects.isNull(mapper?.queryAllArticle())) {
            NoArticleResult(400, "002", "文章不存在", null, null)
        } else {
            NoArticleResult(200, "001", "查询成功", null, mapper?.queryAllArticle())
        }
    }

    /**
     * 上次登录大于一年的用户
     */
    override fun queUserByTime(): NoUserResult? {
        val nowTime = Timestamp(System.currentTimeMillis())
        return if (Objects.isNull(mapper?.queryUserByTime(nowTime))) {
            NoUserResult(400, "002", "用户不存在", null, null)
        } else {
            NoUserResult(200, "001", "查询成功", null, mapper?.queryUserByTime(nowTime))
        }
    }

}