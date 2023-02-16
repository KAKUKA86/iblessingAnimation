package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.User
import lombok.AllArgsConstructor
import lombok.Data

@Data
@AllArgsConstructor
class NoUserResult(
    private var statusCode: Int,
    private var code: String,
    private var message: String,
    private var user: User?

)
