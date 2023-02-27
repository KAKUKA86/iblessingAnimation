package com.iblessing.iblessinganimation.service.impl

import com.iblessing.iblessinganimation.dao.NormalUserMapper
import com.iblessing.iblessinganimation.pojo.*
import com.iblessing.iblessinganimation.service.NormalUserService
import com.iblessing.iblessinganimation.util.*
import jakarta.annotation.Resource
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.util.*

@Service
class NormalUserServiceImpl : NormalUserService {
    @Resource
    private var mapper: NormalUserMapper? = null

    /**
     * 普通用户登录
     */
    override fun normalUserLogin(noUsername: String, noUserPassword: String): NoUserResult {
        println("service处 $noUsername")
        val user: User? = mapper?.queryNormalUserByUserName(noUsername)
        val noLogin = Timestamp(System.currentTimeMillis())
        println("service出库 ${user?.noUsername}")
        return if (Objects.isNull(user)) {
            println("该用户不存在")
            NoUserResult(400, "002", "用户不存在", null, null)
        } else {
            println("用户存在条件")
            if (Objects.equals(user?.noUserPassword, noUserPassword)) {
                println(user?.noUsername + "登陆成功，写入登录时间")
                mapper?.updateNormalUserLoginTime(noUsername, noLogin)
                NoUserResult(200, "001", "登录成功", user, null)
            } else {
                println("该用户存在但密码错误")
                NoUserResult(100, "002", "密码错误", null, null)
            }
        }
    }

    /**
     * 普通用户注册
     */
    override fun normalUserSignIn(user: User): NoUserResult {
        println(user.noUsername)
        val noUsername: String = user.noUsername
        val noUserPassword: String = user.noUserPassword
        val noUserGender: String = user.noGender
        val noUserBirthday: String = user.noBirthday
        val noUserEmail: String = user.noEmail

        return if (mapper?.queryNormalUserByUserName(user.noUsername) == null) {
            val noSignIn = Timestamp(System.currentTimeMillis())
            mapper?.insertNormalUser(noUsername, noUserPassword, noUserGender, noUserBirthday, noSignIn, noUserEmail)
            NoUserResult(200, "003", "注册成功", null, null)
            /**
             * 输入用户对象
             * 需要返回值？
             */
        } else {
            println("用户名重复或服务器错误")
            NoUserResult(100, "004", "注册失败", null, null)
        }
    }

    /**
     * 用户收藏功能
     * 若文章用户不存在收藏标记
     * 则用户可以收藏该文章
     */
    override fun addUserFavorite(favorites: Favorites): NoFavResult? {
        val noId: Int = favorites.noId
        val arId: Int = favorites.arId
        val faTime = Timestamp(System.currentTimeMillis())
        val noFavorites: Favorites? = mapper?.queryNorUserFavByNoIdAndArId(noId, arId)
        return if (Objects.isNull(noFavorites)) {
            println("用户收藏")
            mapper?.insertNorUserFav(noId, arId, faTime)
            NoFavResult(200, "200", "收藏成功", favorites, null)
        } else {
            println("用户取消收藏")
            NoFavResult(100, "100", "取消收藏", null, null)
        }

    }

    /**
     * 用户查询收藏状态
     */
    override fun queryFavorite(favorites: Favorites): NoFavResult? {
        val noId = favorites.noId
        val noFavorites: List<Favorites>? = mapper?.queryNorUserFavByNoId(noId)
        return if (Objects.isNull(noFavorites)) {
            println("没有查询到数据或参数错误")
            NoFavResult(400, "400", "查询失败", null, null)
        } else {
            println("查询成功")
            NoFavResult(500, "500", "查询成功", null, noFavorites)
        }
    }

    /**
     * 用户新建文章
     */
    override fun addArticle(article: Article): NoArticleResult? {
        val noId = article.noId
        val paId = article.paId
        val arTitle = article.arTitle
        val arContent = article.arContent
        val arTime = Timestamp(System.currentTimeMillis())
        val code = mapper?.addArticle(noId, paId, arTitle, arContent, arTime)
        return if (code != 0) {
            println("添加成功")
            article.arTime = arTime
            NoArticleResult(500, "500", "添加成功", article, null)
        } else {
            println("添加失败")
            NoArticleResult(400, "400", "添加失败", null, null)
        }
    }

    /**
     * 用户删除文章
     */
    override fun deleteArticle(article: Article): NoArticleResult? {
        val noId = article.noId
        val arId = article.arId
        // val arTitle = article.arTitle 此处最好做一次查询操作
        val code = mapper?.delArticle(noId, arId)
        return if (code != 0) {
            println("删除成功")
            NoArticleResult(500, "500", "删除成功", article, null)
        } else {
            println("参数错误或删除失败")
            NoArticleResult(400, "400", "删除失败，请检查错误", null, null)
        }
    }

    /**
     * 更新文章
     */
    override fun updateArticle(article: Article): NoArticleResult? {
        val noId = article.noId
        val arId = article.arId
        val paId = article.paId
        val arTitle = article.arTitle
        val arContent = article.arContent
        val arStatus = 0
        val arTime = Timestamp(System.currentTimeMillis())
        val newArticle = mapper?.updateArticle(noId, arId, paId, arTitle, arContent, arStatus, arTime)
        return if (newArticle != 0) {
            println("更新成功")
            article.arTime = arTime
            NoArticleResult(500, "500", "更新成功，等待审核", article, null)
        } else {
            println("更新失败")
            NoArticleResult(400, "400", "更新失败", article, null)
        }
    }

    /**
     * 通过用户查询文章
     */
    override fun queryArticle(article: Article): NoArticleResult? {
        val noId = article.noId
        val articleList = mapper?.queryArticleByNoId(noId)
        return if (Objects.nonNull(articleList)) {
            println("查询成功")
            NoArticleResult(500, "500", "查询成功", null, articleList)
        } else {
            println("查询失败或数据为空")
            NoArticleResult(400, "400", "查询失败或数据为空", null, null)
        }
    }

    /**
     * 新增评论
     */
    override fun addComment(comment: Comment): NoComResult? {
        val noId = comment.noId
        println(noId)
        val arId = comment.arId
        val coContent = comment.coContent
        val coTime = Timestamp(System.currentTimeMillis())
        return if (mapper?.addComment(noId, arId, coContent, coTime) != 0) {
            println("新增成功")
            comment.coTime = coTime
            NoComResult(500, "500", "新增成功", comment, null)
        } else {
            println("新增失败")
            NoComResult(400, "400", "新增失败", null, null)
        }
    }

    /**
     * 删除评论
     */
    override fun deleteComment(comment: Comment): NoComResult? {
        val noId = comment.noId
        val arId = comment.arId
        val time = Timestamp(System.currentTimeMillis())
        comment.coTime = time
        return if (mapper?.delCommentByNoIdAndArId(noId, arId) != 0) {
            println("删除成功")
            NoComResult(500, "500", "删除成功,删除时间为$time", comment, null)
        } else {
            NoComResult(400, "400", "删除失败", comment, null)
        }
    }

    /**
     * 更新评论
     */
    override fun updateComment(comment: Comment): NoComResult? {
        val noId = comment.noId
        val arId = comment.arId
        val coContent = comment.coContent
        val time = Timestamp(System.currentTimeMillis())
        val newComment = mapper?.updateComment(noId, arId, coContent, time)
        return if (newComment != 0) {
            println("修改成功")
            NoComResult(500, "500", "修改成功", comment, null)
        } else {
            println("修改失败")
            NoComResult(400, "400", "更改失败", comment, null)
        }
    }

    /**
     * 通过ID查询评论
     */
    override fun queryCommonByNoId(comment: Comment): NoComResult? {
        val noId = comment.noId
        val commentList = mapper?.queryCommentByNoId(noId)
        return if (Objects.nonNull(commentList)) {
            NoComResult(500, "500", "查询成功", null, commentList)
        } else {
            NoComResult(400, "400", "查询失败", null, null)
        }

    }

    /**
     * 普通用户新增举报
     */
    override fun addReport(report: Report): NoReportResult? {
        val noId = report.noId
        val arId = report.arId
        val reType = report.reType
        val reContent = report.reContent
        //直接添加
        return if (mapper?.addReport(noId, arId, reType, reContent) != 0) {
            NoReportResult(500, "500", "添加成功", null, null)
        } else {
            NoReportResult(400, "400", "添加失败", null, null)
        }
    }

    /**
     * 通过用户ID和文章删除举报
     */
    override fun deleteReport(report: Report): NoReportResult? {
        val noId = report.noId
        val arId = report.arId
        return if (mapper?.deleteReportByNoIdAndArId(noId, arId) != 0) {
            NoReportResult(500, "500", "删除成功", report, null)
        } else {
            NoReportResult(400, "400", "删除失败", report, null)
        }
    }

    /**
     * 用户修改内容
     */
    override fun updateReport(report: Report): NoReportResult? {
        val noId = report.noId
        val arId = report.arId
        val reType = report.reType
        val reContent = report.reContent
        return if (mapper?.updateReportByNoIdAndArId(noId, arId, reType, reContent) != 0) {
            NoReportResult(500, "500", "修改成功", report, null)
        } else {
            NoReportResult(400, "400", "修改失败", report, null)
        }
    }

    /**
     * 通过ID查询举报内容
     */
    override fun queryReportByNoId(report: Report): NoReportResult? {
        val noId = report.noId
        val reportList = mapper?.queryReportByNoId(noId)
        return if (Objects.nonNull(reportList)) {
            NoReportResult(500, "500", "查询成功", null, reportList)
        } else {
            NoReportResult(400, "400", "查询失败", null, null)
        }
    }

    override fun queryArticlePartition(partition: Partition): NoPartitionResult? {
        return if (Objects.nonNull(mapper?.queryArticlePartition())) {
            NoPartitionResult(500, "500", "查询成功", mapper?.queryArticlePartition())
        } else {
            NoPartitionResult(400, "400", "查询失败", null)
        }
    }

    override fun deleteUserFavorite(favorites: Favorites): NoFavResult? {
        return if (mapper?.deleteUserFavorite(favorites.noId, favorites.arId) != 0) {
            NoFavResult(500, "500", "删除成功", favorites, null)
        } else {
            NoFavResult(400, "400", "删除失败", favorites, null)
        }
    }


}