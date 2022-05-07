package mx.com.uam.utils
import java.io.File
class Validate {

def validacionSencilla(archivo){
    File file = new File(archivo)
    def comando = false
    if (file.exists()) {
        comando = true
    }
    return comando
}

}