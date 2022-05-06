package mx.com.uam.utils


class Validate {

def validacionSencilla(archivo){
    def comando = false
    if (fileExists(archivo)) {
        comando = true
    }
    return comando
}

}