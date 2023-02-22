package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Lexicon

class AdLexiconResult (
    var statusCode : Int,
    var code : String,
    var message : String,
    var lexicon: Lexicon?,
    var lexiconList: List<Lexicon>?
        )