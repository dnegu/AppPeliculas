package com.dnegu.core.login

import com.dnegu.core.common.Result

interface LoginRepository {
    suspend fun login(id: String): Result<Login>
}