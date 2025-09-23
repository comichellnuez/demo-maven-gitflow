pipeline {
    agent any

    tools {
        maven 'M3'
        jdk 'JDK17'
    }

environment {
    PATH = "/usr/local/bin:/usr/bin:/bin" // mvn real
        DEPLOY_DIR = "/tmp/demo-maven-gitflow"
        JAR_NAME = "demo-maven-gitflow-1.0-SNAPSHOT.jar"
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn -version'   // se confirma Jenkins ya ve Maven
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Unit Tests') {
            steps { sh 'mvn test' }
            post { always { junit '**/target/surefire-reports/*.xml' } }
        }

        stage('Integration Tests') {
            steps { sh 'mvn verify -DskipUnitTests' }
            post { always { junit '**/target/failsafe-reports/*.xml' } }
        }

        stage('Acceptance Test') {
            steps {
                sh '''
                echo "Ejecutando acceptance test..."
                java -jar target/${JAR_NAME} | grep "Hello World" || exit 1
                echo "✅ Acceptance test OK"
                '''
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                mkdir -p ${DEPLOY_DIR}
                cp target/${JAR_NAME} ${DEPLOY_DIR}/
                echo "✅ Despliegue completado en ambiente de prueba"
                '''
            }
        }
    }

    post {
        failure {
            echo "Pipeline falló: ejecutando rollback"
            sh 'rm -f ${DEPLOY_DIR}/${JAR_NAME}'
        }
        success {
            archiveArtifacts artifacts: "target/${JAR_NAME}", fingerprint: true
            echo "Pipeline completado con éxito"
        }
    }
}





