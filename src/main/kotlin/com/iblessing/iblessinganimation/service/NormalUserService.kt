package com.iblessing.iblessinganimation.service

import com.iblessing.iblessinganimation.pojo.Article
import com.iblessing.iblessinganimation.pojo.Comment
import com.iblessing.iblessinganimation.pojo.Favorites
import com.iblessing.iblessinganimation.pojo.User
import com.iblessing.iblessinganimation.util.NoArticleResult
import com.iblessing.iblessinganimation.util.NoComResult
import com.iblessing.iblessinganimation.util.NoFavResult
import com.iblessing.iblessinganimation.util.NoUserResult
import org.springframework.stereotype.Service

@Service
interface NormalUserService {
    fun normalUserLogin(noUsername: String, noUserPassword: String): NoUserResult
    fun normalUserSignIn(user: User): NoUserResult
    fun addUserFavorite(favorites: Favorites): NoFavResult?
    fun queryFavorite(favorites: Favorites): NoFavResult?
    fun addArticle(article: Article): NoArticleResult?
    fun deleteArticle(article: Article): NoArticleResult?
    fun updateArticle(article: Article): NoArticleResult?
    fun queryArticle(article: Article): NoArticleResult?
    fun addComment(comment: Comment): NoComResult?
    fun deleteComment(comment: Comment): NoComResult?
    fun updateComment(comment: Comment): NoComResult?
    fun queryCommonByNoId(comment: Comment): NoComResult?


}

