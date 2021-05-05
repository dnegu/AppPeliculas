package com.dnegu.core.worker

import com.dnegu.core.common.TypeFactory
import com.dnegu.core.common.Visitable

data class Worker(
    val id: String,

    val name: String?,

    val lastName: String?
) : Visitable {
    override fun type(typeFactory: TypeFactory): Int {
        return typeFactory.type(this)
    }
}