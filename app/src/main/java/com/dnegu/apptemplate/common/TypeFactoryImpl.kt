package com.dnegu.apptemplate.common

import com.dnegu.apptemplate.R
import com.dnegu.core.common.TypeFactory
import com.dnegu.core.worker.Worker

class TypeFactoryImpl : TypeFactory {
    override fun type(item: Worker): Int {
        return R.layout.row_worker
    }
}