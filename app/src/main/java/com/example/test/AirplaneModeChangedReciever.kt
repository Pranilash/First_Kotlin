package layout

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangedReciever : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val airplaneEnabled = intent?.getBooleanExtra("state", false) ?: return
        if (airplaneEnabled) {
            Toast.makeText(context, "Airplane Mode Enabled", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Airplane Mode Disabled", Toast.LENGTH_LONG).show()
        }
    }
}