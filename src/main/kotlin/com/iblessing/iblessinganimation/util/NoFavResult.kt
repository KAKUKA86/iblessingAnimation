package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Favorites


class NoFavResult(
    var code: Int,
    var statusCode: String,
    var message: String,
    var noFavorites: Favorites?,
    var noFavoritesList: List<Favorites>?
)