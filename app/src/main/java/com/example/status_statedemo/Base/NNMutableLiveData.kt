package com.example.status_statedemo.Base

import androidx.lifecycle.LiveData

@Suppress("UNCHECKED_CAST")
class NNMutableLiveData<T> (value:T): LiveData<T>(value) {
    override  fun getValue():T =super.getValue() as T
    public override fun setValue(value: T) {
        super.setValue(value)
    }

    public override fun postValue(value: T) {
        super.postValue(value)
    }


}