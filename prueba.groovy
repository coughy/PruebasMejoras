def archivo1 = "prueba.txt"
def archivo2 = "prueba2.txt"
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
            existeLocal("${archivo2}")
        }
    }
}
}
def existeLocal(archivo){
    echo 'Validacion'
    if (!existeArchivo("${archivo}")) {
        echo "no existe"
    } 
}
def existeArchivo(archivo){
            def comando= """if [ -f ${archivo} ]; then echo "Existe" ; else echo "No existe" ;fi"""
            def result = sh (
                script: comando,
                returnStdout: true
            )
            result = "Existe" ? true : false
            return result
}