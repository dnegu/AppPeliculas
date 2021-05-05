package com.dnegu.apptemplate.ui.login

import com.dnegu.apptemplate.common.BaseViewModel
import com.dnegu.apptemplate.common.Error
import com.dnegu.apptemplate.common.Success
import com.dnegu.core.common.onFailure
import com.dnegu.core.common.onSuccess
import com.dnegu.core.login.Authenticate
import com.dnegu.core.login.Login
import com.dnegu.data.common.PREF_API_TOKEN
import com.dnegu.data.utils.LocalStorage

class LoginViewModel(
    private val authenticate: Authenticate,
    private val localStorage: LocalStorage
) : BaseViewModel<Login, Any>() {

    fun login(id: String) = executeUseCase {
        authenticate(id)
            .onSuccess {
                localStorage[PREF_API_TOKEN] = it.token
                state.value = Success(it)
            }
            .onFailure { state.value = Error(it.throwable) }
    }
}