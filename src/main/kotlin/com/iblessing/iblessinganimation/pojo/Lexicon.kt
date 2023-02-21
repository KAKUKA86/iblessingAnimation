package com.iblessing.iblessinganimation.pojo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
class Lexicon {
    var leId: Int = 0
    var leWord: String = ""
    var leCreationTime: Long = 0
    var leNumber: Int = 0
    var auId: Int = 0
}