package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Lexicon

class AdLexiconResult(
    var code: Int,
    var statusCode: String,
    var message: String,
    var lexicon: Lexicon?,
    var lexiconList: List<Lexicon>?
)