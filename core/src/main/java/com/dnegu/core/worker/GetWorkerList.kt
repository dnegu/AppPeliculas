package com.dnegu.core.worker

import com.dnegu.core.common.Result

interface GetWorkerList {

    suspend operator fun invoke(): Result<List<Worker>>
}

class GetWorkerListImpl(private val workerRepository: WorkerRepository) : GetWorkerList {

    override suspend fun invoke(): Result<List<Worker>> {
        return workerRepository.getWorkerList()
    }
}