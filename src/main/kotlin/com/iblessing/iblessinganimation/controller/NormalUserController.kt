package com.iblessing.iblessinganimation.controller

import com.iblessing.iblessinganimation.pojo.*
import com.iblessing.iblessinganimation.service.NormalUserService
import com.iblessing.iblessinganimation.util.*
import jakarta.annotation.Resource
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/noUser")
class NormalUserController {
    @Resource
    val service: NormalUserService? = null

    /**
     * 普通用户登录
     */
    @PostMapping("/login")
    fun userLogin(@RequestBody user: User): NoUserResult? {
        val noUsername: String = user.noUsername
        val noUserPassword: String = user.noUserPassword
        return service?.normalUserLogin(noUsername, noUserPassword)
    }

    /**
     * 普通用户注册
     */
    @PostMapping("/signIn")
    fun userSignIn(@RequestBody user: User): NoUserResult? {
        return service?.normalUserSignIn(user)
    }

    /**
     * 查询用户的收藏表(返回List类型的数据)
     */
    @RequestMapping("/queryFavorite")
    fun queryUserFavorite(@RequestBody favorites: Favorites): NoFavResult? {
        return service?.queryFavorite(favorites)
    }

    /**
     * 新增普通用户收藏表
     */
    @RequestMapping("/addFavorite")
    fun addUserFavorite(@RequestBody favorites: Favorites): NoFavResult? {
        return service?.addUserFavorite(favorites)
    }

    /**
     * 用户新增文章
     */
    @RequestMapping("/addArt")
    fun addArticle(@RequestBody article: Article): NoArticleResult? {
        return service?.addArticle(article)
    }

    /**
     * 用户删除文章
     */
    @DeleteMapping("/delArt")
    fun delArticle(@RequestBody article: Article): NoArticleResult? {
        return service?.deleteArticle(article)
    }

    /**
     * 用户修改文章
     */
    @RequestMapping("/updArt")
    fun updateArticle(@RequestBody article: Article): NoArticleResult? {
        return service?.updateArticle(article)
    }

    /**
     * 用户查询文章
     */
    @RequestMapping("/queArt")
    fun queryArticle(@RequestBody article: Article): NoArticleResult? {
        return service?.queryArticle(article)
    }

    /**
     * 用户新增对文章评论
     */
    @RequestMapping("/addCom")
    fun addComment(@RequestBody comment: Comment): NoComResult? {
        return service?.addComment(comment)
    }

    /**
     * 用户删除对文章评论
     */
    @RequestMapping("/delCom")
    fun delComment(@RequestBody comment: Comment): NoComResult? {
        return service?.deleteComment(comment)
    }

    /**
     * 用户修改自己的评论
     */
    @RequestMapping("/updCom")
    fun updComment(@RequestBody comment: Comment): NoComResult? {
        return service?.updateComment(comment)
    }

    /**
     * 用户查询自己评论
     */
    @RequestMapping("/queCom")
    fun queComment(@RequestBody comment: Comment): NoComResult? {
        return service?.queryCommonByNoId(comment)
    }

    /**
     * 用户新增举报记录
     */
    @RequestMapping("/addReport") // 得接收报错
    fun addReport(@RequestBody report: Report): NoReportResult? {
        return service?.addReport(report)
    }

    //以下未测试
    /**
     * 用户删除举报记录
     */
    @RequestMapping("/delReport")
    fun delReport(@RequestBody report: Report): NoReportResult? {
        return service?.deleteReport(report)
    }

    /**
     * 用户修改记录
     */
    @RequestMapping("/updReport")
    fun updReport(@RequestBody report: Report): NoReportResult? {
        return service?.updateReport(report)
    }

    /**
     * 用户查询举报记录
     */
    @RequestMapping("/queReport")
    fun queReport(@RequestBody report: Report): NoReportResult? {
        return service?.queryReportByNoId(report)
    }


}