package com.iblessing.iblessinganimation.controller

import com.iblessing.iblessinganimation.pojo.Article
import com.iblessing.iblessinganimation.pojo.Like
import com.iblessing.iblessinganimation.service.UtilService
import com.iblessing.iblessinganimation.util.NoArticleResult
import com.iblessing.iblessinganimation.util.UtArticleAndCommentResult
import com.iblessing.iblessinganimation.util.UtilResult
import jakarta.annotation.Resource
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class UtilController {

    @Resource
    val service: UtilService? = null
    //通过编号显示文章
    @RequestMapping("/queArticleByArId")
    fun showArticleByArId(@RequestBody article: Article) : NoArticleResult? {
        return service?.showArticleByArId(article)
    }
    //通过编号查找文章和相关评论
    @RequestMapping("/queArticleAndCommentByArId")
    fun showArticleAndCommentByArId(@RequestBody article: Article) : UtArticleAndCommentResult? {
        return service?.showArticleAndCommentByArId(article.arId)
    }
    //通过分区编号查询文章数量
    @RequestMapping("/queArticleCountByPaId")
    fun showArticleCountByPaId(@RequestBody article: Article) : UtilResult? {
        return service?.showArticleCountByPaId(article)
    }
    /**
     * 查询点赞次数
     */
    @RequestMapping("/queLikeCountByNoIdAndArId")
    fun showLikeCountByNoIdAndArId(@RequestBody like: Like) : UtilResult? {
        return service?.showLikeCountByNoIdAndArId(like)
    }
    /**
     * 增加点赞记录
     */
    @RequestMapping("/addLike")
    fun addLike(@RequestBody like: Like) : UtilResult? {
        return service?.addLike(like)
    }

}