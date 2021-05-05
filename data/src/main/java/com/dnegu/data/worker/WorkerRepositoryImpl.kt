package com.dnegu.data.worker

import com.dnegu.core.common.Result
import com.dnegu.core.worker.Worker
import com.dnegu.core.worker.WorkerRepository
import com.dnegu.data.common.Repository
import com.dnegu.data.network.Api
import com.dnegu.data.network.getData
import com.dnegu.data.network.getDataAsList

class WorkerRepositoryImpl(private val api: Api, private val workerDao: WorkerDao) :
    Repository<Worker, WorkerEntity>(), WorkerRepository {

    override suspend fun getWorkerList(): Result<List<Worker>> {
        return fetchDataList(
            apiDataProvider = {
                api.getWorkerList().getDataAsList(
                    fetchFromCacheAction = { workerDao.getWorkerList() },
                    cacheAction = { workerDao.insertMultiple(it) }
                )
            },
            dbDataProvider = {
                workerDao.getWorkerList()
            }
        )
    }

    override suspend fun getWorkerById(id: Int): Result<Worker> {
        return fetchData(
            apiDataProvider = {
                api.getWorkerById(id).getData(
                    fetchFromCacheAction = { workerDao.getWorkerById(id) },
                    cacheAction = { workerDao.insert(it) }
                )
            },
            dbDataProvider = {
                workerDao.getWorkerById(id)
            }
        )
    }
}