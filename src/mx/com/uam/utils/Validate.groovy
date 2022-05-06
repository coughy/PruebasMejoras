package mx.com.uam.utils
import java.io.File

class Validate {

def validacionSencilla(archivo){
    def comando = false
    if (fileExists(archivo)) {
        comando = true
    }
    return comando
}

}