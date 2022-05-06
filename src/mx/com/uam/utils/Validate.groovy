package mx.com.uam.utils

class Validate {
    def archivo
Validate(archivo){
    this.archivo = archivo
}
def validacionSencilla(archivo){
    def comando = false
    if (fileExists(archivo)) {
        comando = true
    }
    return comando
}

}