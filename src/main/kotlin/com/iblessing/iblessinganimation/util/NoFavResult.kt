package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Favorites


class NoFavResult(
    var statusCode: Int,
    var code: String,
    var message: String,
    var noFavorites: Favorites?,
    var noFavoritesList: List<Favorites>?
) {

}