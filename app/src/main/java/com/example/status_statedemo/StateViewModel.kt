package com.example.status_statedemo

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.status_statedemo.Base.NNMutableLiveData

class States(){

}

class StateViewModel(): ViewModel() {
    val progress = NNMutableLiveData<Array<Int>>(arrayOf(View.VISIBLE, View.GONE, View.GONE))
    val progressVar = NNMutableLiveData<Int>(View.VISIBLE)
    val success = NNMutableLiveData<Int>(View.GONE)
    val error = NNMutableLiveData<Int>(View.GONE)



}
class StateVals(){
    companion object{
        val prog = 0
        val err = 1
        val succ = 2
    }
}
