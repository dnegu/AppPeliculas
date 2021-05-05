package com.dnegu.core.worker

import com.dnegu.core.common.Result

interface GetWorker {

    suspend operator fun invoke(id: Int): Result<Worker>
}

class GetWorkerImpl(private val workerRepository: WorkerRepository) : GetWorker {

    override suspend fun invoke(id: Int): Result<Worker> {
        return workerRepository.getWorkerById(id)
    }
}