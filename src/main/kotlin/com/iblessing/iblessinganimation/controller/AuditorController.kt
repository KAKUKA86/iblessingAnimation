package com.iblessing.iblessinganimation.controller

import com.iblessing.iblessinganimation.pojo.Article
import com.iblessing.iblessinganimation.pojo.AudiUser
import com.iblessing.iblessinganimation.service.AuditorUserService
import com.iblessing.iblessinganimation.util.AuUserResult
import com.iblessing.iblessinganimation.util.NoArticleResult
import com.iblessing.iblessinganimation.util.NoUserResult
import jakarta.annotation.Resource
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/auUser")
class AuditorController {
    @Resource
    val service: AuditorUserService? = null

    @RequestMapping("/login")
    fun auditorLogin(@RequestBody audiUser: AudiUser): AuUserResult? {
        return service?.auditorUserLogin(audiUser)
    }

    /**
     * 审核员查询全部用户上传的文章
     */
    @RequestMapping("/queArticle")
    fun queArticle(@RequestBody article: Article): NoArticleResult? {
        return service?.queArticle(article)
    }

    /**
     * 审核员查询用户上传未审核的文章
     */
    @RequestMapping("/queAudArticle")
    fun queAuArticle(@RequestBody article: Article): NoArticleResult? {
        return service?.queAudiArticle(article)
    }

    /**
     * 审核员审核用户上传的文章
     */
    @RequestMapping("/updAudArticle")
    fun updAuArticle(@RequestBody article: Article): NoArticleResult? {
        return service?.updAudiArticle(article)
    }

    /**
     * 审核员删除用户上传的文章
     */
    @RequestMapping("/delAudArticle")
    fun delAuArticle(@RequestBody article: Article): NoArticleResult? {
        return service?.delAudiArticle(article)
    }

    /**
     * 审核员通过用户登录时间差>1年查询用户
     */
    @RequestMapping("/queUserByTime")
    fun queUserByTime(): NoUserResult? {
        return service?.queUserByTime()
    }

}