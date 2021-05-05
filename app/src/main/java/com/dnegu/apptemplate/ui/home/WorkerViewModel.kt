package com.dnegu.apptemplate.ui.home

import com.dnegu.apptemplate.common.BaseViewModel
import com.dnegu.apptemplate.common.Error
import com.dnegu.apptemplate.common.Success
import com.dnegu.core.common.onFailure
import com.dnegu.core.common.onSuccess
import com.dnegu.core.worker.GetWorker
import com.dnegu.core.worker.Worker

class WorkerViewModel(private val getWorker: GetWorker) : BaseViewModel<Worker, Any>() {

    fun getWorkerById(id: Int = 0) = executeUseCase {
        getWorker(id)
            .onSuccess { state.value = Success(it) }
            .onFailure { state.value = Error(it.throwable) }
    }
}