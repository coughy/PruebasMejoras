package mx.com.uam.utils
import java.io.File
class Validate {

def validacionSencilla(archivo){
    def comando = false
    if (archivo.exists()) {
        comando = true
    }
    return comando
}

}