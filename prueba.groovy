def archivo1 = "prueba.txt"
def archivo2 = "prueba2.txt"
def directorio = prueba
pipeline {
agent any
stages {
    stage('Hello'){
        steps {
            echo 'Hello World'
            sh "touch ${archivo1}"
            sh 'ls -al'
        }
    }
    stage('validar archivo'){
        steps{
            script{
                existeLocal("${archivo2}")
                echo "Validar sencillo"
                if (!validacionSencilla("$archivo1")) {
                    echo 'no existe'
                } 
            }
        }
    }
    stage('create directory sin sh'){
        steps{
            script{
                crearDirectorio("{$directorio}")
            }
        }
    }

}
}
def crearDirectorio(directorio){
   File fullPath = new File('./${directorio}')
    if (!fullPath.exists())
        fullPath.mkdirs() 
}
def validacionSencilla(archivo){
    def comando = false
    if (fileExists(archivo)) {
        comando = true
    }
    return comando
}
def existeLocal(archivo){
    echo 'Validacion'
    if (!existeArchivo("${archivo}")) {
        echo 'no existe'
    } 
}
def existeArchivo(archivo){
            def comando= """if [ -f ${archivo} ]; then echo "Existe" ; else echo "No existe" ;fi"""
            def result = sh (
                script: comando,
                returnStdout: true
            )
            echo "${result}"
            result = "Existe" ? true : false
            return result
}