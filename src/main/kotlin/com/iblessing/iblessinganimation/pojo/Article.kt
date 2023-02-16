package com.iblessing.iblessinganimation.pojo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
class Article {
    var arId : Int = 0
    var noId: Int = 0
    var arTitle : String = ""
    var arContent : String = ""
    var arTime : Long = 0
    var arView : Int = 0
}