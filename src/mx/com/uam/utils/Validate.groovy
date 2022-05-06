package mx.com.uam.utils


class Validate {

def validacionSencilla(archivo){
    def comando = false
    if (script.fileExists(archivo)) {
        comando = true
    }
    return comando
}

}