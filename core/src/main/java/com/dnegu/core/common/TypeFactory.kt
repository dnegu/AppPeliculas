package com.dnegu.core.common

import com.dnegu.core.worker.Worker

interface TypeFactory {
    fun type(item: Worker): Int
}