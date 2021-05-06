package com.dnegu.data.movie

import com.dnegu.data.network.RoomMapper

data class ApiResponse<T> (
    val page:Int?=0,
    val results:List<T>,
    val total_pages:Int?=0,
    val total_results:Int?=0
): RoomMapper<List<T>> {
    override fun mapToRoomEntity(): List<T> {
        return results
    }
}