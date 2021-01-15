import android.bluetooth.BluetoothDevice

// Représente les données
data class Device(var name: String?, var mac: String?, var device: BluetoothDevice?) {

    override fun equals(other: Any?): Boolean {
        return other is Device && other.mac == this.mac
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (mac?.hashCode() ?: 0)
        result = 31 * result + device.hashCode()
        return result
    }

}