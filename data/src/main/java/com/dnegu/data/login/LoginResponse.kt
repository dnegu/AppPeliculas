package com.dnegu.data.login

import com.dnegu.core.login.Login
import com.dnegu.data.network.DomainMapper

data class LoginResponse(val token: String) : DomainMapper<Login> {
    override fun mapToDomainModel(): Login {
        return Login(token = token)
    }
}