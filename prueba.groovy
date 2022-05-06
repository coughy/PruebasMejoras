@Library('java-classes@javatest') _
import mx.com.uam.utils.Validate
import java.io.File
def validate = new Validate()
def archivo1 = "prueba.txt"
def archivo2 = "prueba2.txt"
def directorioname = "prueba"
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
                if (!validate.validacionSencilla("$archivo1")) {
                    echo 'no existe'
                } 
                echo "salida"
            }
        }
    }
    stage('create directory sin sh'){
        steps{
            script{
                echo "$directorioname"
                crearDirectorio("$directorioname")
                sh 'ls -al'
            }
        }
    }

}
}
def crearDirectorio(directorio){
    echo "${env.WORKSPACE}/${directorio}"
   File nombrDirectorio = new File("${env.WORKSPACE}/${directorio}")
    if (!nombrDirectorio.exists()) {
        nombrDirectorio.mkdirs()
        sh 'ls -al' 
    }
    else{
        echo "eliminar directorio"
        nombrDirectorio.deleteDir()
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