package mx.com.uam.utils

class Validate {

def validacionSencilla(archivo){
    def comando = false
    if (exists(archivo)) {
        comando = true
    }
    return comando
}

}