package my.edu.tarc.connectfirebase

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import my.edu.tarc.connectfirebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    var firebaseDatabase: FirebaseDatabase? = null
    var reference: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        firebaseDatabase = FirebaseDatabase.getInstance()
        reference = firebaseDatabase!!.getReference()


        mainBinding.buttonsubmit.setOnClickListener {

            val name = mainBinding.editTextTextPersonName.text.toString()
            val position = mainBinding.editTextname.text.toString()

            val user = UserHelper(name, position)
            reference!!.child(name).setValue(user)
        }

    }
}