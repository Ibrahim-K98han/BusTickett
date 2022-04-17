package com.ibrahimssoft.busticket

import androidx.lifecycle.LiveData

class ScheduleRepository (val scheduleDao: ScheduleDao){

    suspend fun addSchedule(busSchedule: BusSchedule){
        scheduleDao.addSchedule(busSchedule)
    }

    suspend fun deleteSchedule(busSchedule: BusSchedule){
        scheduleDao.deleteSchedule(busSchedule)
    }

    suspend fun updateSchedule(busSchedule: BusSchedule){
        scheduleDao.updateSchedule(busSchedule)
    }

    fun getAllSchedule():LiveData <List<BusSchedule>> = scheduleDao.getAllSchedule()

    fun getScheduleById(id:Long):LiveData<BusSchedule> = scheduleDao.getScheduleById(id)

}