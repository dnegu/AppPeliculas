package com.dnegu.core.worker

import com.dnegu.core.common.Result

interface WorkerRepository {

    suspend fun getWorkerList(): Result<List<Worker>>

    suspend fun getWorkerById(id: Int): Result<Worker>
}