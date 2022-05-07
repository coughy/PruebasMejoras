package mx.com.uam.utils
import java.io
class Validate {

def validacionSencilla(archivo){
    def comando = false
    if (fileExists(archivo)) {
        comando = true
    }
    return comando
}

}