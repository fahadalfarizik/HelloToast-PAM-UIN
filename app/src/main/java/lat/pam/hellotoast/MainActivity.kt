package lat.pam.hellotoast

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Variabel untuk menghitung klik
    private var mCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Mencatat log (Debug)
        Log.d("Test debug", "Hello World, ini aplikasi Hello Toast")

        // Inisialisasi View dari XML ke Kotlin
        val mShowCount = findViewById<TextView>(R.id.show_count)
        val buttonCountUp = findViewById<Button>(R.id.button_count)
        val buttonToast = findViewById<Button>(R.id.button_toast)
        val buttonSwitchPage = findViewById<Button>(R.id.button_switchpage)
        val buttonBrowser = findViewById<Button>(R.id.button_browser)

        // AKSI 1: Tombol Count (Menambah Angka)
        buttonCountUp.setOnClickListener(View.OnClickListener {
            mCount++
            Log.d("mCount", mCount.toString()) // Catat ke Logcat
            mShowCount.text = mCount.toString() // Update UI
        })

        // AKSI 2: Tombol Toast (Menampilkan Pesan Timbul)
        buttonToast.setOnClickListener(View.OnClickListener {
            val tulisan: String = mShowCount.text.toString()
            val toast: Toast = Toast.makeText(this, "Angka yang dimunculkan $tulisan", Toast.LENGTH_LONG)
            toast.show()
        })

        // AKSI 3: Tombol Switch Page (INTENT EXPLICIT - Pindah Activity)
        buttonSwitchPage.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        })

        // AKSI 4: Tombol Browser (INTENT IMPLICIT - Buka Aplikasi Lain)
        buttonBrowser.setOnClickListener(View.OnClickListener {
            val intentBrowse = Intent(Intent.ACTION_VIEW)
            intentBrowse.data = Uri.parse("https://www.google.com/")
            startActivity(intentBrowse)
        })

        // Edge to Edge UI Padding (Bawaan Android Studio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}