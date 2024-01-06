package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.UserViewLoan

class UserViewLoanResult(
    var code: String,
    var statusCode: Int,
    var message: String,
    var userViewLoanList: List<UserViewLoan>?
)