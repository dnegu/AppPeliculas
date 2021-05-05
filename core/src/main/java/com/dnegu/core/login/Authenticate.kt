package com.dnegu.core.login

import com.dnegu.core.common.Result

interface Authenticate {
    suspend operator fun invoke(id: String): Result<Login>
}

class AuthenticateImpl(private val loginRepository: LoginRepository) : Authenticate {

    override suspend fun invoke(id: String): Result<Login> {
        return loginRepository.login(id)
    }
}