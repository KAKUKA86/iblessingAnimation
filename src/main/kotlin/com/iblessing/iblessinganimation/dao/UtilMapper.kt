package com.iblessing.iblessinganimation.dao

import com.iblessing.iblessinganimation.pojo.Article
import com.iblessing.iblessinganimation.pojo.Comment
import com.iblessing.iblessinganimation.pojo.Like
import com.iblessing.iblessinganimation.pojo.View
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import java.sql.Timestamp

@Mapper
interface UtilMapper {
    @Select("select * from n_article where ar_id = #{arId}")
    fun showArticleByArId(arId: Int): Article?

    @Select("select * from n_comment where ar_id = #{arId}")
    fun showCommentByArId(arId: Int): List<Comment>?
    @Select("select count(*) from n_article where pa_id = #{paId}")
    fun showArticleCountByPaId(paId: Int): Int?
    @Select("select * from n_like where no_id = #{noId} and ar_id = #{arId}")
    fun showLikeCountByNoIdAndArId(like: Like): Like?
    @Insert("insert into n_like (no_id, ar_id) values (#{noId}, #{arId})")
    fun addLike(arId: Int, noId: Int): Int
    @Select("select * from n_view where no_id = #{noId} and ar_id = #{arId}")
    fun showViewByNoIdAndArId(arId: Int,noId: Int): View?
    @Insert("insert into n_view (no_id, ar_id, vi_time) values (#{noId}, #{arId}, #{viTime})")
    fun addView(arId: Int, noId: Int, viTime: Timestamp): Int?
    @Update("update n_article set ar_view = ar_view + 1 where ar_id = #{arId}")
    fun addViewCount(arId: Int): Int?

}