package com.dnegu.data.login

import com.dnegu.core.common.Result
import com.dnegu.core.login.Login
import com.dnegu.core.login.LoginRepository
import com.dnegu.data.common.Repository
import com.dnegu.data.network.Api
import com.dnegu.data.network.getData

class LoginRepositoryImpl(private val api: Api) : Repository<Login, LoginResponse>(),
    LoginRepository {

    override suspend fun login(id: String): Result<Login> {
        return fetchData(
            dataProvider = {
                api.authenticate(LoginRequest(id = id)).getData()
            }
        )
    }
}