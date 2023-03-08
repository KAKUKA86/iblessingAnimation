package com.iblessing.iblessinganimation.service

import com.iblessing.iblessinganimation.pojo.*
import com.iblessing.iblessinganimation.util.*
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
    fun addReport(report: Report): NoReportResult?
    fun deleteReport(report: Report): NoReportResult?
    fun updateReport(report: Report): NoReportResult?
    fun queryReportByNoId(report: Report): NoReportResult?
    fun queryArticlePartition(partition: Partition): NoPartitionResult?
    fun deleteUserFavorite(favorites: Favorites): NoFavResult?
    fun queryAllArticle(article: Article): NoArticleResult?


}


