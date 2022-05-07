package mx.com.uam.utils
import java.io.File
class Validate {

def validacionSencilla(archivo){
    File file = archivo
    def comando = false
    if (file.exists()) {
        comando = true
    }
    return comando
}

}