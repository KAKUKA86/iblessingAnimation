package com.iblessing.iblessinganimation.dao

import com.iblessing.iblessinganimation.pojo.Article
import com.iblessing.iblessinganimation.pojo.Comment
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface UtilMapper {
    @Select("select * from n_article where ar_id = #{arId}")
    fun showArticleByArId(arId: Int): Article?

    @Select("select * from n_comment where ar_id = #{arId}")
    fun showCommentByArId(arId: Int): List<Comment>?
}