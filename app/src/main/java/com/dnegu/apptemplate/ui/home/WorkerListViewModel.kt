package com.dnegu.apptemplate.ui.home

import com.dnegu.apptemplate.common.BaseViewModel
import com.dnegu.apptemplate.common.Error
import com.dnegu.apptemplate.common.Success
import com.dnegu.core.common.onFailure
import com.dnegu.core.common.onSuccess
import com.dnegu.core.worker.GetWorkerList
import com.dnegu.core.worker.Worker

class WorkerListViewModel(private val getWorkerList: GetWorkerList) :
    BaseViewModel<List<Worker>, Any>() {

    fun getAll() = executeUseCase {
        getWorkerList()
            .onSuccess { state.value = Success(it) }
            .onFailure { state.value = Error(it.throwable) }
    }
}