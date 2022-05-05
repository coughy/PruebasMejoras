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
            script{
                existeLocal("${archivo2}")
                echo "Validar sencillo"
                if (fileExists("${archivo1}") {
                echo "File  found!"
            }
            }
        }
    }
}
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