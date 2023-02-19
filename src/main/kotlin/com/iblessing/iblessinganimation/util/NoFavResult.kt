package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Favorites
import lombok.AllArgsConstructor

@AllArgsConstructor
class NoFavResult (
    var statusCode : Int,
    var code : String,
    var message : String,
    var noFavorites: Favorites?
        ) {
    override fun toString(): String {
        return super.toString()
    }

}