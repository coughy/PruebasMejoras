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
}
}