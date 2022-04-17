package com.ibrahimssoft.busticket

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ScheduleViewModel(application: Application)
    :AndroidViewModel(application){

        private lateinit var repository: ScheduleRepository

        init {
            val dao = BusScheduleDB.getDB(application).getScheduleDao()
            repository = ScheduleRepository(dao)
        }
    fun addSchedule(busSchedule: BusSchedule){
        viewModelScope.launch {
            repository.addSchedule(busSchedule)
        }
    }

    fun deleteSchedule(busSchedule: BusSchedule){
        viewModelScope.launch {
            repository.deleteSchedule(busSchedule)
        }
    }

    fun updateSchedule(busSchedule: BusSchedule){
        viewModelScope.launch {
            repository.updateSchedule(busSchedule)
        }
    }

    fun getAllSchedule():LiveData<List<BusSchedule>> = repository.getAllSchedule()

    fun getScheduleById(id:Long) = repository.getScheduleById(id)

}