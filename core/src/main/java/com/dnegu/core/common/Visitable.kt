package com.dnegu.core.common

interface Visitable {
    fun type(typeFactory: TypeFactory): Int
}