package com.ibrahimssoft.busticket

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ScheduleDao {
    @Insert
    suspend fun addSchedule(busSchedule: BusSchedule)

    @Update
    suspend fun updateSchedule(busSchedule: BusSchedule)

    @Delete
   suspend fun deleteSchedule(busSchedule: BusSchedule)

    @Query("select * from tbl_schedule")
    fun getAllSchedule():LiveData<List<BusSchedule>>

    @Query("select * from tbl_schedule where id = :id")
    fun getScheduleById(id:Long):LiveData<BusSchedule>

}