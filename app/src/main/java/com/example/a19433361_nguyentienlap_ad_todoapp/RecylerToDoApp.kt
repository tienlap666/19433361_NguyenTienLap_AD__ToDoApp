package com.example.a19433361_nguyentienlap_ad_todoapp


import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_recyclerview_todoapp.*
import kotlinx.android.synthetic.main.activity_todoapp.*
import kotlinx.android.synthetic.main.activity_todoapp.fac_recyclerview
import kotlinx.android.synthetic.main.add_new_task.*
import kotlinx.android.synthetic.main.add_new_task.view.*
import com.example.a19433361_nguyentienlap_ad_todoapp.Extentions.toast
import java.util.ArrayList

class RecylerToDoApp:AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference
    private val arrayList = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview_todoapp)

        itemClick()
        databaseReference = FirebaseDatabase.getInstance().getReference("User")

        fac_recyclerview.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_new_task, null)
            val mBuilder = AlertDialog.Builder(this@RecylerToDoApp)
            mBuilder.setView(mDialogView)


            val mAlertDialog = mBuilder.show()
            mAlertDialog.btnSave.setOnClickListener{
                mAlertDialog.dismiss()
                val work = mDialogView.etWork.text.toString()
                val status = "Not Complete"
                val user = User(work, status)
                arrayList.add(user)
                //listView.adapter = ListAdapter(this, R.layout.item_work, arrayList)
                rcvWork.adapter = RecyclerviewAdapter(arrayList)
                rcvWork.layoutManager = LinearLayoutManager(this)
                AddRealTimeDataBase()
            }
            mDialogView.btnCancel.setOnClickListener {
                mAlertDialog.dismiss()
            }
        }



    }
    fun AddRealTimeDataBase(){
        val uid = FirebaseUtils.firebaseAuth.currentUser?.uid

        if (uid!=null){
            databaseReference.child(uid).setValue(arrayList).addOnCompleteListener {
                if (it.isSuccessful){
                    toast("Successfully")
                }else{
                    toast("Failed")
                }
            }
        }
    }
    private fun itemClick() {
        TODO("Not yet implemented")
    }
}