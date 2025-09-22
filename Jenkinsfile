pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn -B clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn -B test'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
