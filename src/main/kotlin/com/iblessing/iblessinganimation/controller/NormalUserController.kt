package com.iblessing.iblessinganimation.controller

import com.iblessing.iblessinganimation.pojo.Article
import com.iblessing.iblessinganimation.pojo.Comment
import com.iblessing.iblessinganimation.pojo.Favorites
import com.iblessing.iblessinganimation.pojo.User
import com.iblessing.iblessinganimation.service.NormalUserService
import com.iblessing.iblessinganimation.util.NoArticleResult
import com.iblessing.iblessinganimation.util.NoComResult
import com.iblessing.iblessinganimation.util.NoFavResult
import com.iblessing.iblessinganimation.util.NoUserResult
import jakarta.annotation.Resource
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
}